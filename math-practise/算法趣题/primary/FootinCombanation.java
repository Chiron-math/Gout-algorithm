package com.company.primary;

/**
 *Q16 30人31足比赛
 * 原则是：不让女生相邻。
 * 只考虑男女的排列情况，不考虑具体某个人的位置
 **/
public class FootinCombanation {
	public static char[] fe={'f','m'};
	public static int cn =0;

/*	public static void F2(String str){
		if (str.length()==30) {
			cn++;
		}
		if (str.endsWith("f")) {
			 F2(str+fe[1]);
		}
		for (int i = 0; i < 2; i++) {
			F2(str+fe[i]);
		}
	}*/

	/**
	 * 男生1 女生 0
	 * 第二种：这道题目说到底是一个条件：n位置往前看
	 * 顺着考虑的话：n-1是0，这里必须1
	 * 				n-1是1，这里 排1,0都可
	 * 返过来 ：		n是1时，n-1可1可0，即是说与n-1位置上的情况一样
	 * 				n是0时，n-1只能为1，与n-2位置的情况。
	 * 可以考虑到思路是第n个位置的情况是位置n-1为女时，n-1的排列情况+位置n-1为男时，n-2的情况
	 * @param n第n个位置排男还是排女
	 * @return
	 */
	public static int F(int n){
		if (n==1) {
			return 2;
		}
		if (n==2) {
			return 3;
		}
		return F(n-1)+F(n-2);
	}


	/**
	 * 第一种：这变成了插空的无条件组合（循环的时候不止i要变，n也要变化-变成）
	 * @param i
	 * @param n
	 * @return
	 */
	public static int C(int i,int n){
		if (i==0) {
			return 1;
		}
		if (i==1) {
			return n;
		}
		return C(i-1,n-1)*n/i;
	}




	public static void main(String[] args) {
		//插空排列
		int max =30	,cnt=0;
		for (int i = 0; i <= (max+1)/2; i++) {
			cnt+=C(i,31-i);
		}
		System.out.println(cnt+"\n");

		//递归逆序
		System.out.println(F(30));
/*		F2("");
		System.out.println(cn);*/

	}
}
