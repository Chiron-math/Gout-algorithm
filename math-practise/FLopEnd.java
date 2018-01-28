package com.company;

import java.awt.FlowLayout;

/**
 * 程序员算法趣题：Q3
 * 按照翻牌顺序，刚开始全都背面从第n张开始每隔n-1牌翻一次，求结果100张牌背面朝上的有哪些？
 * 结果背面朝上，开始背面，所以设boolean[]默认为false，结果判断是false就用
 * 结果发现是平方数
 * 分析：因为除了1外，每个牌都会被翻至少一次。所以翻回来的一定是偶数次
 * 对于这个反派规律即是有n作为约数的所有数，而除1。那么一般都有奇数个约数
 * 要达到偶数次，约数里一定有一个是不和其他人组合，自己乘以自己的那种，即是平方数
 * @author admin
 * Created by admin 倃on 2018/1/27.
 */
public class FLopEnd {
	boolean[] a = null;
	int count = 0;

	public FLopEnd(int count) {
		// TODO Auto-generated constructor stub
		this.a = new boolean[count];
		this.count = count;
	}


	public void calcToEnd(){

		System.out.println(a.length);
		//运算
		for (int j = 1; j < a.length; j++) {
			for (int i = j; i < a.length; i+=j+1) {
				a[i] = !a[i];
			}
		}
		//输出
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			if(!a[i])
				System.out.print(i+1+" ");
		}
		System.out.println("]");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FLopEnd fe =new FLopEnd(100);
		fe.calcToEnd();

	}

}
