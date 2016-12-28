package com.qiyu.paymanager.service;

import com.qiyu.common.constants.ErrorCode;
import com.qiyu.common.result.ModelResult;
import com.qiyu.upload.domain.request.UploadBase64Req;
import com.qiyu.upload.service.UploadService;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

/**
 * Created by Administrator on 2016/8/24.
 */
@Service
public class FileService {

    private Logger logger= LoggerFactory.getLogger(FileService.class);

    @Autowired
    private UploadService uploadService;

    private ExecutorService pool = null;

    public ModelResult upload(MultipartFile file) throws IOException {

        ModelResult modelResult = new ModelResult();
        UploadBase64Req uploadBase64Req = new UploadBase64Req();
        try {
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            byte[] data = file.getBytes();

            Base64 base64Util = new Base64();
            String base64 = base64Util.encodeToString(data);
            base64 = new String(base64.getBytes(), "utf-8");

            uploadBase64Req.setPrefix("");
            uploadBase64Req.setSuffix(suffix);
            uploadBase64Req.setBase64(base64);
            logger.info("uploadBase64Req={}",uploadBase64Req);
            modelResult =  uploadService.uploadBase64(uploadBase64Req);
        } catch (Exception e) {
            modelResult.withError(ErrorCode.SERVICE_ERROR);
            e.printStackTrace();
        } finally {
            return  modelResult;
        }

    }
}
