/*
 * PROJECT NAME: mytest
 * PACKAGE NAME: ge.wu.test
 * FILE    NAME: test.java
 * COPYRIGHT: Copyright(c) 2013 上海斐讯数据通信技术有限公司 All Rights Reserved.
 */ 
package com.study.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * TODO（描述类的职责）
 * @author ge.wu
 * @date 2017年6月16日 下午4:30:14
 * @version <b>1.0.0</b>
 */
public class ExcelTest {

	/**
	 * TODO（POI测试方法）
	 * @author ge.wu
	 * @date 2017年6月16日 下午4:30:14
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setName("吴革");
		user.setAge(26);
		user.setSex("男");
		user.setPlace("湖北天门");
		CreatExcel(user);
	}
	
	
	
	public static void CreatExcel(User user) {
		

		//创建HSSFWorkbook对象  
		HSSFWorkbook wb = new HSSFWorkbook();  
		//创建HSSFSheet对象  
		HSSFSheet sheet = wb.createSheet("sheet0");  
		
		
		
		
		
		//创建HSSFRow对象  
		HSSFRow row = sheet.createRow(0);  
			//创建HSSFCell对象  
			HSSFCell cell=row.createCell(0);  
			//设置单元格的值  
			cell.setCellValue(user.getName());
			HSSFCell cell1=row.createCell(1);  
			cell1.setCellValue(user.getSex());
			
			
		//输出Excel文件  
		FileOutputStream output;
		try {
			output = new FileOutputStream("d:\\workbook.xls");
			wb.write(output);  
			output.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
