package com.qiyu.paymanager.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;

/**
 * 处理有关IO的帮助类
 * @author Alan
 *
 */
public class IOUtils extends org.apache.commons.io.IOUtils {			
	
	private static Logger logger=LoggerFactory.getLogger(IOUtils.class);
	private static final int READING_TXT_LINES = 50 ;  /***读取TXT文件的行数**/
	
	/**
	 * 封装导出数据方法
	 */
	public static ResponseEntity<byte[]> getResponseEntity(HttpServletRequest request, String filePath){
		String fileName=filePath.substring(filePath.lastIndexOf("\\")+1);
		//判断是否是IE，处理乱码问题
		ResponseEntity<byte[]> responEntity = null ;
		try {
			HttpHeaders headers = getUTF8FileNameInHeaders(fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			responEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)),headers, HttpStatus.OK);
		} catch (IOException e) {
			logger.error("导出封装数据出现异常！",e);
		} 
		return responEntity ;
	} 
	
	public static String readTxtFile(String filePath){
		String encoding="GBK";
		StringBuffer fileText = new StringBuffer() ;
		File file=new File(filePath);
        try {
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),getCharset(filePath));//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int i=0;
                while((lineTxt = bufferedReader.readLine()) != null){
                	if(i>=READING_TXT_LINES){
                		break ;
                	}
                	fileText.append(lineTxt+"\n") ;
                	i++ ;
                }
                System.out.println(fileText.toString());
                read.close();
            }else{
            	System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return fileText.toString() ;
    }
	
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static String getCharset(String fileName) throws IOException{
        
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));  
        int p = (bin.read() << 8) + bin.read();  
        
        String code = null;  
        
        switch (p) {  
            case 0xefbb:  
                code = "UTF-8";  
                break;  
            case 0xfffe:  
                code = "Unicode";  
                break;  
            case 0xfeff:  
                code = "UTF-16BE";  
                break;  
            default:  
                code = "GBK";  
        }  
        return code;
	}
	
	/**
	 * 中文文件名称乱码修复
	 * @param fileName
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static final HttpHeaders getUTF8FileNameInHeaders(String fileName) throws UnsupportedEncodingException{
		HttpHeaders headers = new HttpHeaders();
		fileName = URLEncoder.encode(fileName, "UTF-8");
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\"");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return headers;
	}

	/**
	 * 封装文件方法
	 */
	public static ResponseEntity<byte[]> getResponseEntity(HttpServletRequest request, String fileName, String filePath){
		ResponseEntity<byte[]> responEntity = null ;
		try {
			HttpHeaders headers = getUTF8FileNameInHeaders(fileName);
			responEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)),headers, HttpStatus.OK);
		} catch (IOException e) {
			logger.error("导出封装数据出现异常！",e);
		} 
		return responEntity ;
	} 
	
}
