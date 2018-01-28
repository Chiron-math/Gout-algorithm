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
		/*System.out.print(n+"->");*/
		if(n%2==0){
			n = n /2;
		}else {
			n = n*3+1;
		}
		if (n!=1 && n!=m) {
			return isCollatz(n, m);
		}else if(n == 1 && m!=1){
			/*System.out.println("---");*/
			return false;
		}else{
			System.out.print(n+"符合标准。\n");
			return true;
		}

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
