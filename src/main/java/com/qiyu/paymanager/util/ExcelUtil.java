package com.qiyu.paymanager.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelUtil {
	protected static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	protected static int SHEET_COUNT = 20000 ;/**Excel的每个sheet所包含数据的最大行数***/
	
	/**
	 * @param title
	 * @param headers
	 * @param cols
	 * @param workbook
	 * @param dataList
	 * @param datePattern
	 * @param start  dataList该序号开始遍历
	 */
	@SuppressWarnings("deprecation")
	protected static void establishSheet(String title, String[] headers,String[] cols,HSSFWorkbook workbook,
				List<Map<String,Object>> dataList,String datePattern,int start){
		 // 生成一个表格
	      HSSFSheet sheet = workbook.createSheet(title);

	      // 设置表格默认列宽度为15个字节
	      sheet.setDefaultColumnWidth((short) 15);

	      // 生成一个样式
	      HSSFCellStyle style = workbook.createCellStyle();

	      // 设置这些样式
	      style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
	      style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	      style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	      style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	      style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	      // 生成一个字体
	      HSSFFont font = workbook.createFont();
	      font.setColor(HSSFColor.VIOLET.index);
	      font.setFontHeightInPoints((short) 12);
	      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

	      // 把字体应用到当前的样式
	      style.setFont(font);

	      // 生成并设置另一个样式
	      HSSFCellStyle style2 = workbook.createCellStyle();

	      style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
	      style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	      style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	      style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	      style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
	      style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
	      style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	      style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	      // 生成另一个字体
	      HSSFFont font2 = workbook.createFont();
	      font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

	      // 把字体应用到当前的样式
	      style2.setFont(font2);

	      // 声明一个画图的顶级管理器
	      //HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
	      HSSFRow row = sheet.createRow(0);

	      for (short i = 0; i < headers.length; i++) {

	         HSSFCell cell = row.createCell(i);
	         cell.setCellStyle(style);
	         HSSFRichTextString text = new HSSFRichTextString(headers[i]);
	         cell.setCellValue(text);

	      }
	      //遍历集合数据，产生数据行

	      //Iterator<Map<String,Object>> it = dataList.iterator();

	      int index = 0;
	      HSSFFont font3 = workbook.createFont();
	     /* while (it.hasNext())*/
	     int  endNum = start+SHEET_COUNT < dataList.size() ? start+SHEET_COUNT : dataList.size() ; 
	     for(int j=start; j<endNum ; j++){
	    	
	         index++;
	         row = sheet.createRow(index);
	         Map<String,Object> map = (Map<String,Object>)(dataList.get(j));
	         //Field[] fields = t.getClass().getDeclaredFields();

	         for (int i=0; i<cols.length; i++) {
	        	
	            HSSFCell cell = row.createCell(i);
	            cell.setCellStyle(style2);
	            Object value=null; 
	            if(!map.containsKey(cols[i])){
	            	value = "" ;
	            }else{
	            	value = map.get(cols[i]);
	            }
	            String textValue = null;  
	            if(value == null){
	            	textValue = "";
	            }else if (value instanceof Date) {
	            	Date date = (Date) value;
	                SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
	                textValue = sdf.format(date);

	             }else{
	            	  	//其它数据类型都当作字符串简单处理
	                  textValue = value.toString();
	             }
              //利用正则表达式判断textValue是否全部由数字组成
              if(textValue!=null){
                 Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
                 Matcher matcher = p.matcher(textValue);
                 if(matcher.matches()){
                    //是数字当作double处理
                    cell.setCellValue(Double.parseDouble(textValue));

                 }else{

                    HSSFRichTextString richString = new HSSFRichTextString(textValue);
                    font3.setColor(HSSFColor.BLUE.index);
                    richString.applyFont(font3);
                    cell.setCellValue(richString);
                 }
              }
         
	         }  //for

	      }
	}
	
	@SuppressWarnings("deprecation")
	public static void exportExcel(String title, String[] headers,String[] cols,
			  					List<Map<String,Object>> dataList, OutputStream out, String datePattern) {
		      // 声明一个工作薄
	  	 HSSFWorkbook workbook = new HSSFWorkbook();
	  	 int length = dataList.size() ;
	  	 int sheetNum = length / SHEET_COUNT ; 
	  	 for(int i=0; i<sheetNum; i++){
	  		 establishSheet( title+i,  headers, cols,workbook,
					 dataList, datePattern,SHEET_COUNT * i);
	  	 }
	  	if(length % SHEET_COUNT != 0){
	  		establishSheet( title+sheetNum,  headers, cols,workbook,
					 dataList, datePattern,SHEET_COUNT * sheetNum);
	  	}
		    
	    try {

	        workbook.write(out);

	     } catch (IOException e) {

	        e.printStackTrace();

	     }	 
	  }
	  
	  /**
	 * @param response
	 * @throws IOException 
	 * @throws  
	 * @throws IOException 
	 */
	public static void downloadFile(HttpServletResponse response,HttpServletRequest request, String fileName,File file) throws IOException{
		
		InputStream fis = null;
		try {
			fis = new BufferedInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        
        if (!file.exists() || !file.canRead()) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("您下载的文件不存在！");
            return;
        }
        String userAgent = request.getHeader("User-Agent");
        boolean isIE = (userAgent != null) && (userAgent.toLowerCase().indexOf("msie") != -1);
        
       // response.reset();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "must-revalidate, no-transform");
        response.setDateHeader("Expires", 0L);

        response.setContentType("application/x-download");
        response.setContentLength((int) file.length());
        
        String newFileName = null ; 
        	newFileName = URLEncoder.encode(fileName  , "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + newFileName + "\"");
       
        OutputStream toClient=null;
		toClient = response.getOutputStream();
		//response.setContentType("application/octet-stream;charset=utf-8");   /*"text/plain;charset=utf-8"*/
        try {
		IOUtils.copy(fis,toClient);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }finally{
			//IOUtils.closeQuietly(fis);
        }
		
	}
	/**
	 * 获取待导出的EXCEL文件的封装的ResponseEntity数据
	 * @param request
	 * @param response
	 * @param headerNames excel表头
	 * @param colNames 每列对应的Map中的key,意思务必和表头对应
	 * @param fileName 导出的文件的名称
	 * @param result 要导出的数据
	 * @return
	 */
	public static ResponseEntity<byte[]> getExportExcelFileData(HttpServletRequest request, HttpServletResponse response, String[] headerNames, String[] colNames, String fileName, List<Map<String ,Object>> result){
		// 生成要导出的文件
		String path = request.getSession().getServletContext().getRealPath("\\") + "upload\\";
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdir();
		}
		File destFile = new File(filePath,fileName);
		OutputStream out = null;
		String title = fileName.indexOf(".")>0 ? fileName.substring(0,fileName.indexOf(".")) : "Excel"; 
		try {
			out = new FileOutputStream(destFile);
			ExcelUtil.exportExcel(title, headerNames, colNames, result, out, "yyyy-MM-dd HH:mm:ss");
		} catch (FileNotFoundException e) {
			logger.error("验证Excel导出出错！", e);
			// 生成导出数据错误，跳转到提示页面
			// response.sendRedirect("http://www.baidu.com");
			// request.getRequestDispatcher("http://www.baidu.com").forward(request,
			// response);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("生成导出文件时关闭IO出错！", e);
				}
				out = null;
			}
		}

		// 获取导出信息
		ResponseEntity<byte[]> exportData = IOUtils.getResponseEntity(request, destFile.getAbsolutePath());
		// 删除生成的导出文件
		destFile.delete();
		if (exportData == null) {
			// 导出失败，跳转到提示页面，传递提示信息：“导出失败，请联系客服人员！”
			logger.error("信息封装导出数据出错！");
			// response.sendRedirect("http://www.baidu.com");
			// request.getRequestDispatcher("http://www.baidu.com").forward(request,
			// response);
		}
		return exportData;
	}
	
	/**
	 * 获取待导出的EXCEL文件的封装的ResponseEntity数据
	 * @param request
	 * @param response
	 * @param headerNames excel表头
	 * @param colNames 每列对应的Map中的key,意思务必和表头对应
	 * @param fileName 导出的文件的名称
	 * @param result 要导出的数据
	 * @param datePattern 日期格式
	 * @return
	 */
	public static ResponseEntity<byte[]> getExportExcelFileData(HttpServletRequest request, HttpServletResponse response,
                                                                String[] headerNames, String[] colNames, String fileName, List<Map<String ,Object>> result, String datePattern){
		// 生成要导出的文件
		String path = request.getSession().getServletContext().getRealPath("\\") + "upload\\";
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdir();
		}
		File destFile = new File(filePath,fileName);
		OutputStream out = null;
		String title = fileName.indexOf(".")>0 ? fileName.substring(0,fileName.indexOf(".")) : "Excel"; 
		try {
			out = new FileOutputStream(destFile);
			ExcelUtil.exportExcel(title, headerNames, colNames, result, out, datePattern);
		} catch (FileNotFoundException e) {
			logger.error("验证Excel导出出错！", e);
			// 生成导出数据错误，跳转到提示页面
			// response.sendRedirect("http://www.baidu.com");
			// request.getRequestDispatcher("http://www.baidu.com").forward(request,
			// response);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("生成导出文件时关闭IO出错！", e);
				}
				out = null;
			}
		}

		// 获取导出信息
		ResponseEntity<byte[]> exportData = IOUtils.getResponseEntity(request, destFile.getAbsolutePath());
		// 删除生成的导出文件
		destFile.delete();
		if (exportData == null) {
			// 导出失败，跳转到提示页面，传递提示信息：“导出失败，请联系客服人员！”
			logger.error("信息封装导出数据出错！");
			// response.sendRedirect("http://www.baidu.com");
			// request.getRequestDispatcher("http://www.baidu.com").forward(request,
			// response);
		}
		return exportData;
	}
	

	
	  
}
