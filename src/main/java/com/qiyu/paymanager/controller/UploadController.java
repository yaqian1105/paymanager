package com.qiyu.paymanager.controller;

import com.qiyu.common.result.ModelResult;
import com.qiyu.paymanager.service.FileService;
import com.qiyu.paymanager.service.UploadImageCallable;
import com.qiyu.paymanager.util.DateUtil;
import com.qiyu.paymanager.util.FileUpload;
import com.qiyu.paymanager.util.UuidUtil;
import com.qiyu.upload.domain.request.UploadBase64Req;
import com.qiyu.upload.domain.result.UploadBase64Rlt;
import com.qiyu.upload.service.UploadService;
import com.yunjiangzhe.tools.JsonUtil;
import com.yunjiangzhe.tools.MediaTypes;
import com.yunjiangzhe.tools.annotation.ServiceExceptionRet;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Dean on 2016/4/26.
 */
@Controller
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private FileService fileService;

    @ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "upload",produces = MediaTypes.JSON_UTF_8 )
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {

        ModelResult result = fileService.upload(file);
        return JsonUtil.toJson(result);
    }
    
    
    @ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "uploadBase64",produces = MediaTypes.JSON_UTF_8 )
    public String uploadBase64(UploadBase64Req uploadBase64Req,HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
     
    	ModelResult<UploadBase64Rlt> result= uploadService.uploadBase64(uploadBase64Req);
        
        return JsonUtil.toJson(result);
    }

    /**
     * 文件上传
     */
    @RequestMapping(value="/uploadFile")
    @ResponseBody
    public Map uploadFile(HttpServletRequest request, @RequestParam(value="file") MultipartFile[] files) {
        Map<String,Object> result = new HashedMap();
        String path = "";
        try {
            for(MultipartFile file : files) {

                String ffile = DateUtil.getDay(), fileName = "";
                if (null != file && !file.isEmpty()) {
                    String filePath = "/data/upload/" + ffile;		//文件上传路径
                    fileName = FileUpload.fileUp(file, filePath, UuidUtil.get32UUID());				//执行上传
                    System.out.println("fileName: " + fileName);

                }else{
                    System.out.println("上传失败");
                    result.put("code",9999);
                    return result;
                }

                path += ("/data/upload/"+ffile + "/" + fileName + ",");
            }
            System.out.println("路径为:"+path);
            if (!StringUtils.isEmpty(path)) {
                result.put("filePath", path.length() > 0 ? path.subSequence(0, path.length() - 1) : "");
            }
            result.put("code",0);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /*@ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "upload",method = RequestMethod.OPTIONS  ,produces = MediaTypes.JSON_UTF_8 )
    public String upload1(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        //Map<String,Object> result=qiniuService.upload(request,response);
        return JsonUtil.toJson(RestResult.restSuccess(null));
    }*/

    /*@ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "download",method = {RequestMethod.POST ,RequestMethod.OPTIONS } ,produces = MediaTypes.JSON_UTF_8 )
    public String download(@RequestParam(value = "keys",required = true)String keys, HttpServletResponse response) throws IllegalStateException, IOException {
        Map<String,Object> result=qiniuService.download(keys);
        return JsonUtil.toJson(result);
    }

    @ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "loadPic",method = {RequestMethod.POST ,RequestMethod.OPTIONS },produces = MediaTypes.JSON_UTF_8 )
    public String loadPic(@RequestParam(value = "key",required = true)String key, HttpServletResponse response) throws IllegalStateException, IOException {
        String result=qiniuService.loadPic(key);
        return result;
    }*/
}
