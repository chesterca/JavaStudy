/*
 * PROJECT NAME: mytest
 * PACKAGE NAME: ge.wu.test
 * FILE    NAME: CSVTest.java
 * COPYRIGHT: Copyright(c) 2013 上海斐讯数据通信技术有限公司 All Rights Reserved.
 */ 
package com.study.basic;

/**
 * TODO（描述类的职责）
 * @author ge.wu
 * @date 2017年7月4日 上午9:45:37
 * @version <b>1.0.0</b>
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;  
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;



public class CSVTest {
	public static void read() throws IOException{File file = new File("e:\\read.csv");  
    FileReader fReader = new FileReader(file);  
    CSVReader csvReader = new CSVReader(fReader);  
    String[] strs = csvReader.readNext();  
    if(strs != null && strs.length > 0){  
        for(String str : strs)  
            if(null != str && !str.equals(""))  
                System.out.print(str + " , ");  
        System.out.println("\n---------------");  
    }  
    List<String[]> list = csvReader.readAll();  
    for(String[] ss : list){  
        for(String s : ss)  
            if(null != s && !s.equals(""))  
                System.out.print(s + " , ");  
        System.out.println();  
    }  
    csvReader.close();  }
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		read();
	}
	
	
}  
