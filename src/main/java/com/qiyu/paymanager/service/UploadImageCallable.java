package com.qiyu.paymanager.service;

import com.qiyu.common.utils.UuidUtil;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/10/28.
 */
public class UploadImageCallable implements Callable {
    private File dirPath;
    private MultipartFile multipartFile;
    public UploadImageCallable(File dirPath,MultipartFile multipartFile) {
        this.dirPath = dirPath;
        this.multipartFile = multipartFile;
    }
    @Override
    public Object call() throws Exception {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String realFileName = multipartFile.getOriginalFilename();
        String uuid = UuidUtil.get32UUID();
        String newRealFileName = format.format(date)+ uuid + realFileName.substring(realFileName.indexOf("."));
        File uploadFile = new File(dirPath, newRealFileName);
        if (!uploadFile.exists()) {
            uploadFile.createNewFile();
        }
        FileCopyUtils.copy(multipartFile.getBytes(), uploadFile);
        return uploadFile.getAbsolutePath();
    }
}
