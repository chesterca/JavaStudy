package com.play.game;

public class NumberGame {

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			if (i%2==1) {
			}else {
				continue;
			}
			if (i%3==0) {
			}else {
				continue;
			}
			if (i%4==1) {
			}else {
				continue;
			}
			if (i%5==4) {
			}else {
				continue;
			}
			if (i%6==3) {
			}else {
				continue;
			}
			if (i%7==0) {
			}else {
				continue;
			}
			if (i%8==1) {
			}else {
				continue;
			}
			if (i%9==0) {
				System.out.println("正确答案是："+i);
			}
		}

	}

}
