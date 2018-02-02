package com.company.primary;

import java.util.ArrayList;
import java.util.List;

/**
 * Q11 斐波那契数列
 * 用斐波那契数列中的每个数初一其数位上所有数字之和
 * 求出144后续5个最小的能整除的数
 * @author admin
 *
 */
public class FibonacciSeries {
	public static int i=0;
	public static int[] a=new int[20];
	public static List<Long> fib = new ArrayList<Long>();


	/**
	 *
	 * @param mount 是求出后续多少个数
	 * @param com 从什么数开始算
	 */
	public FibonacciSeries(int mount ,long com) {
		int m =0,t=1;
		while (m<mount){
			//因为fib是list类型，按顺序记数(它是从0开始)（Cn(n)是从1开始）
			//如果t不从1开始，那么就无法和斐波那切数列一致.（要保证求第n个斐波那契数的时候，fib已经加了n-1次）
			fib.add(Cn(t));
//			System.out.println(fib.get(t-1));
			if (isDivisible(Cn(t))&&Cn(t)>com) {
				m++;
				System.out.println("第"+m+"个"+Cn(t)+" ");
			}
			t++;
		}

	}


	/**
	 * 生成斐波那契数列第n个数值
	 * @param n n>=1
	 * @return long值不够
	 */
	public static  long Cn(int n){
		if (n==1||n==2) {
			return 1;
		}if (fib.size()<n) {
//			fib.add(Cn(n));不能放在这里，会出现越界，递归调用溢出
			return Cn(n-1)+Cn(n-2);
		}
		return fib.get(n-1);
	}

	/**
	 * 判断输入的数值是否满足n能被n上各位数的和整除
	 * @param n
	 * @return
	 */
	public static  boolean isDivisible(long n){
		long sum=0,m;
		m=n;
		while (m!=0) {
			a[i++] = (int)(m%10);
			m/=10;
		}
		for (int b = 0; b < i; b++) {
			sum +=a[b];
		}
		i=0;
		if (n%sum==0) {
			return true;
		}
		return false;
	}



	public static void main(String[] args) {
		FibonacciSeries fs = new FibonacciSeries(5,144);
	}

}
