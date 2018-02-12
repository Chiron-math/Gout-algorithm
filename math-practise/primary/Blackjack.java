package com.company.primary;

/**
 * Q23 21点通吃
 * 求最开始拥有10，持续24会合后硬币还能剩余的硬币枚数变化情况共有多少种？
 * @author admin
 *
 */
 
public class Blackjack {
	//m是情况的种数
	public static int m =0;

	/**
	 * 递归的方式，每回合两种可能， 回数+1
	 * 题目规定的每次有余即赌上1个，赢+1输-1
	 * @param n 现有的金额
	 * @param count 现在剩余回合数
	 */
	public static void C(int n,int count){
		if (n>0&&count>0) {
			count--;
			C(n-1,count);
			C(n+1,count);
		}else if (n>0) {
			m++;
		}
	}

	public static void main(String[] args) {
		C(10,24);
		System.out.println(m);
	}

}
