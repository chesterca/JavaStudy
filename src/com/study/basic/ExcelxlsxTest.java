/*
 * PROJECT NAME: mytest
 * PACKAGE NAME: ge.wu.test
 * FILE    NAME: test.java
 * COPYRIGHT: Copyright(c) 2013 上海斐讯数据通信技术有限公司 All Rights Reserved.
 */ 
package com.study.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * TODO（描述类的职责）
 * @author ge.wu
 * @date 2017年6月16日 下午4:30:14
 * @version <b>1.0.0</b>
 */
public class ExcelxlsxTest {

	/**
	 * TODO（POI测试方法）
	 * @author ge.wu
	 * @date 2017年6月16日 下午4:30:14
	 * @param args
	 */
	public static void main(String[] args) {
        String [] title = {"SEQNO","SNNO","CARDNO","ORDERID","ORDERTIME","ORDERSTATUS","AMOUNT","CONSIGNEENAME","CONSIGNEEPHONE","CONSIGNEEADDRESS","CHANNELNAME","GOODSNAME","GOODTYPE","ESN","FACTORYCODE"};
        List<Huaxiainfo> listdata = new ArrayList<Huaxiainfo>();
//        for (int i = 0; i < 11111; i++) {
//			Huaxiainfo huaxiainfo = new Huaxiainfo();
//			huaxiainfo.setCardNo(i+1+"");
//			listdata.add(huaxiainfo);
//			
//		}
        listdata=getDateFromDataBase(listdata);
        
        //创建excel工作薄
        @SuppressWarnings("resource")
		XSSFWorkbook workbook= new XSSFWorkbook();
        //创建一个工作表sheet
        Sheet sheet = workbook.createSheet("第0页");
        //设置样式
        XSSFFont font1 = workbook.createFont();
        //设置行高使用HSSFRow对象的setHeight和setHeightInPoints方法，这两个方法的区别在于setHeightInPoints的单位是点，而setHeight的单位是1/20个点，所以setHeight的值永远是setHeightInPoints的20倍。
        //设置字号大小
         //font1.setFontHeight(20);
        //设置字号大小
        font1.setFontHeightInPoints((short) 10);
         //设置字体
         font1.setFontName("微软雅黑");
        //设置加粗
        font1.setBold(true);
         //设置斜体
        font1.setItalic(true);
         //设置字体颜色
        //font1.setColor(IndexedColors.PINK.getIndex());
       //或者
        //font1.setColor(HSSFColor.YELLOW.index);
         XSSFCellStyle style = workbook.createCellStyle();
         style.setFont(font1);
        
        
        //创建第一行
        Row row = sheet.createRow(0);
        Cell cell = null;
        //插入第一行数据
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);//设置该单元格格式
            sheet.autoSizeColumn((short)i); //调整该列宽度
        }
        
        
        int  number=0;
        int  sheetNo=0;
        for (Huaxiainfo huaxiainfo : listdata) {
        	number++;
			if (number%5001==0) {//因为有标题列所以一共是分页数量加1，例如按5000分页，应该取余5001
				//新建一个工作表sheet
				sheetNo++;
		        sheet = workbook.createSheet("第"+sheetNo+"页");
		        row = sheet.createRow(0);
		        cell = null;
		        //插入第一行数据
		        for(int i=0;i<title.length;i++){
		            cell = row.createCell(i);
		            cell.setCellValue(title[i]);
		            cell.setCellStyle(style);//设置该单元格格式
		            sheet.autoSizeColumn((short)i); //调整该列宽度
		        }
		        //初始化number
		        number=1;
			}
        	CreatExcelxlsx(huaxiainfo, sheet,number);
		}
        
        //创建一个文件
        File file = new File("d:/poi_test.xlsx");
        try {
            file.createNewFile();
            //创建输出流 
            FileOutputStream stream = FileUtils.openOutputStream(file);
            //将拼好的Excel写入到文件流
            workbook.write(stream);
            //关闭输出流
            stream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	
	
	
	private static List<Huaxiainfo> getDateFromDataBase(
			List<Huaxiainfo> listdata) {
		// TODO Auto-generated method stub
		
		
		
		
		return listdata;
	}



	public static void CreatExcelxlsx(Huaxiainfo huaxiainfo,Sheet sheet, int number) {
        //追加数据
            Row nextRow = sheet.createRow(number);
            Cell cell =  nextRow.createCell(0);
            cell.setCellValue("");
            cell =  nextRow.createCell(1);
            cell.setCellValue(huaxiainfo.getSnNo());
            cell =  nextRow.createCell(2);
            cell.setCellValue(huaxiainfo.getCardNo());
            cell =  nextRow.createCell(3);
            cell.setCellValue(huaxiainfo.getOrderId());
            cell =  nextRow.createCell(4);
            cell.setCellValue(huaxiainfo.getOrderTime());
            cell =  nextRow.createCell(5);
            cell.setCellValue(huaxiainfo.getOrderStatus());
            cell =  nextRow.createCell(6);
            cell.setCellValue(huaxiainfo.getAmount());
            cell =  nextRow.createCell(7);
            cell.setCellValue(huaxiainfo.getConsigneeName());
            cell =  nextRow.createCell(8);
            cell.setCellValue(huaxiainfo.getConsigneePhone());
            cell =  nextRow.createCell(9);
            cell.setCellValue(huaxiainfo.getConsigneeAddress());
            cell =  nextRow.createCell(10);
            cell.setCellValue(huaxiainfo.getChannelName());
            cell =  nextRow.createCell(11);
            cell.setCellValue(huaxiainfo.getGoodsName());
            cell =  nextRow.createCell(12);
            cell.setCellValue(huaxiainfo.getGoodType());
            cell =  nextRow.createCell(13);
            cell.setCellValue(huaxiainfo.getEsn());
            cell =  nextRow.createCell(14);
            cell.setCellValue(huaxiainfo.getFactoryCode());

	}

}
