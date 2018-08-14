/*
 * PROJECT NAME: mytest
 * PACKAGE NAME: ge.wu.test
 * FILE    NAME: User.java
 * COPYRIGHT: Copyright(c) 2013 上海斐讯数据通信技术有限公司 All Rights Reserved.
 */ 
package com.study.basic;

/**
 * TODO（用户对象）
 * @author ge.wu
 * @date 2017年6月17日 下午2:38:29
 * @version <b>1.0.0</b>
 */
public class User {
			String name;
			@Override
			public String toString() {
				return "User [name=" + name + ", sex=" + sex + ", age=" + age
						+ ", place=" + place + "]";
			}
			String sex;
			int age;
			String place;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getSex() {
				return sex;
			}
			public void setSex(String sex) {
				this.sex = sex;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			public String getPlace() {
				return place;
			}
			public void setPlace(String place) {
				this.place = place;
			}
	
}
