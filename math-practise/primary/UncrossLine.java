package com.company.primary;

/**
 * Q22不缠绕的纸杯电话
 * N个人围成圈，结对用纸杯电话相互通话，要求纸杯电话的绳子不能交叉
 * 那么判断得到每一对一定分两个范围来看，求得那次所得即是两边种类的积
 * 16个人，N先除2再进行计算
 * @author admin
 *
 */
public class UncrossLine {


	/**
	 * 简化抽象不交叉连线，动态规划
	 * 不求具体的每次多少得到，将所有过程递归表示
	 * 套用终值条件，计算得到所求
	 * @param n 是实际人数的一半
	 * @return
	 */
	public static int C(int n){
		int t=0;
		if (n==0||n==1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			t+=C(i)*C(n-i-1);
		}
		return t;
	}

	public static void main(String[] args) {
		int n = 16/2;
		System.out.println(C(n)+"种");
	}
}
