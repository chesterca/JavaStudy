/*
 * PROJECT NAME: mytest
 * PACKAGE NAME: ge.wu.test
 * FILE    NAME: JavaBasicTest.java
 * COPYRIGHT: Copyright(c) 2013 上海斐讯数据通信技术有限公司 All Rights Reserved.
 */ 
package com.study.basic;

/**
 * TODO（描述类的职责）
 * @author ge.wu
 * @date 2017年6月27日 下午1:38:41
 * @version <b>1.0.0</b>
 */
public class JavaBasicTest {

	/**
	 * TODO（java基础）
	 * @author ge.wu
	 * @date 2017年6月27日 下午1:38:41
	 * @param args
	 */
	public static void main(String[] args) {
		  long ct = System.currentTimeMillis();
		  String t = String.valueOf(ct);
		  String loid="Y"+t.substring(0,12);
		  
		  System.out.println(loid);
		  System.out.println(t);
		  System.out.println(ct);
		  System.out.println(System.nanoTime());
	}

}
