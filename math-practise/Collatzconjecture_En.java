package com.company;

/**
 *  程序员算法趣题Q6
 *  新版考拉兹猜想
 *  从小于10000的所有偶数中找能回到初始值的偶数（规定偶数第一次也要当作奇数：n*3+1）
 *  @author admin
 *  Created by admin on 2018/1/29.
 *
 */
public class Collatzconjecture_En {

	public boolean isCollatz(int n,int m){
		boolean b1,b2 ;
		/*System.out.print(n+"->");*/
		n= n%2 == 0? n/2:n*3+1;
		b1 = (n ==1)?false:(b2=(n==m)?true:isCollatz(n, m));
		if b1
			System.out.print(n+"符合标准。\n");
		return b1;
	}


	public static void main(String[] args) {
		Collatzconjecture_En cc= new Collatzconjecture_En();
		int count =0;
		for (int i = 2; i < 10000; i+=2) {
			if (cc.isCollatz(i*3+1, i)) {
				count++;
			}
		}
		System.out.println("一共有"+count+"个符合要求的数字");
		/*System.out.println(cc.isCollatz(7,2));*/
	}
}
