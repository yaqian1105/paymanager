package com.qiyu.paymanager.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiyu.data.vo.UploadPicResp;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * About Qiniu
 * @author KK
 * 
 */
public class QiniuUtils {
	private static final Logger log = LoggerFactory.getLogger(QiniuUtils.class);

	public static String RES_URL = null;
	private static String defaultBucket = null;
	private static String thumbnail = "";
	private static boolean initialized = false;
	private static Auth auth = null;

	private static Map<String, String> bucketDomain = null;

	private static Map<String, String> bucketResType = null;
	private static UploadManager uploadManager = new UploadManager();
	public static String QN_URL_PRE = "http://o7fgoifen.bkt.clouddn.com/";
	private QiniuUtils() {
	}

	public static void init() {
		log.info("QiniuUtils Initializing...");
		String ACCESS_KEY = "np_1Wv5hGc7V7hH1eYutl4NnN5HEQ6-Ek25pkP3F";
		String SECRET_KEY = "RrmpT3nJ16F-P3fHJnat2Lia_yyPQ1_A7V3K3dWM";

		// audio video picture
		bucketDomain = new HashMap<String, String>();
		bucketDomain.put("wangwang", QN_URL_PRE);

		bucketResType = new HashMap<String, String>();
		bucketResType.put("wangwang", "wangwang");

		defaultBucket = "wangwang";

		auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		initialized = true;
		log.info("QiniuUtils Initialized...");
	}

	public static String getBucket(String resType) {
		if (!initialized) {
			QiniuUtils.init();
		}
		if (StringUtils.isBlank(resType)) {
			return defaultBucket;
		}
		String bucket = bucketResType.get(resType);

		if (StringUtils.isNotBlank(bucket)) {
			return bucket;
		}

		return defaultBucket;
	}

	/**
	 * 获取上传凭证
	 * 
	 * @return
	 */
	public static String getToken() {
		// 请确保该bucket已经存在
		if (!initialized) {
			QiniuUtils.init();
		}
		String uptoken = auth.uploadToken(defaultBucket);
		return uptoken;
	}

	/**
	 * 获取上传凭证
	 * 
	 * @param saveKey
	 * @return
	 */
	public static String getToken(String saveKey) {
		// 请确保该bucket已经存在
		if (!initialized) {
			QiniuUtils.init();
		}
		String uptoken = auth.uploadToken(defaultBucket, saveKey);
		return uptoken;
	}

	public static String getResourcePath(String bucket, String saveKey) {
		return bucket + ":" + saveKey;// 这个KEY要保存到数据库
	}

	/**
	 * 获取上传凭证
	 * 
	 * @param bucket
	 * @param saveKey
	 * @return
	 */
	public static String getToken(String bucket, String saveKey) {
		// 请确保该bucket已经存在
		if (!initialized) {
			QiniuUtils.init();
		}
		// String uptoken = auth.uploadToken(bucket, saveKey);
		String uptoken = auth
				.uploadToken(
						bucket,
						saveKey,
						3600,
						new StringMap()
								.putNotEmpty(
										"returnBody",
										"{\"fsize\": $(fsize), \"key\": $(key), \"hash\": $(etag), \"width\": $(imageInfo.width), \"height\": $(imageInfo.height)}"));
		return uptoken;
	}

	public static String getResUrl(String path) {
		if (!initialized) {
			QiniuUtils.init();
		}
		if (StringUtils.isBlank(path))
			return "";
		if (!StringUtils.startsWithIgnoreCase(path, "http://")) {
			String[] paths = StringUtils.split(path, ":");
			if (paths != null && paths.length == 2) {
				return bucketDomain.get(paths[0]) + path;
			}
			return bucketDomain.get(defaultBucket) + path;
		} else {
			return path;
		}
	}

	public static UploadPicResp upload(byte[] data, String key, String resType) {
		String bucket = getBucket(resType);
		String path = QiniuUtils.getResourcePath(bucket, key);
		String token = getToken(bucket, path);

		try {
			Response res = uploadManager.put(data, path, token);
			if (res.isOK()) {
				UploadPicResp ret = res.jsonToObject(UploadPicResp.class);
				ret.setKey(path);
				ret.setUrl(getResUrl(path));
				return ret;
			}
		} catch (QiniuException e) {
			Response r = e.response;
			log.error(r.toString());
			try {
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 下载网络文件
	 * 

	 */
	public static byte[] downLoanImage(String targetImage) {
		URL url = null;
		InputStream infile = null;
		URLConnection con = null;
		byte[] buffer = null;
		try {
			url = new URL(targetImage);

			con = url.openConnection();
			infile = con.getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream(
					infile.available());
			buffer = new byte[1024];
			int len = 0;
			while (-1 != (len = infile.read(buffer, 0, 1024))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (infile != null) {
					infile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String args[]) {
		System.out.println(getResUrl("youjianggame:0E7vfCvW134oXckqrY52Hb"));
		// byte data[] =
		// downLoanImage("http://ubmcmm.baidustatic.com/media/v1/0f000jHuvpI5zmR-j_lOqf.jpg");
		// UploadPicResp resp = upload(data, StrUtils.get64UUID(), "wxavater");
		// System.out.println(resp);
	}

	// public static String getResThumbUrl(String path) {
	// if (!initialized) {
	// QiniuUtils.init();
	// }
	// if (!StringUtils.startsWithIgnoreCase(path, "http://")) {
	// String[] paths = StringUtils.split(path, ":");
	// if(paths != null && paths.length == 2) {
	// return bucketDomain.get(paths[0]) + path + "/" + QiniuUtils.thumbnail;
	// }
	// return bucketDomain.get(defaultBucket) + path + "/" +
	// QiniuUtils.thumbnail;
	// } else {
	// return path + "/" + QiniuUtils.thumbnail;
	// }
	// }
}
