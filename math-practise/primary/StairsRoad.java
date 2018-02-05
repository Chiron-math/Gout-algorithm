package com.company.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * Q15 走楼梯
 * 当存在10级台阶，且移动规则相同时，有多少种两人最终停在同一级的情况
 * 第一种：（不分先后顺序，转化为05纸币换钱问题）把问题转换为一人从0到i，另一人从i往第11级走。计算i级的情况时，步数遍历，总共情况。
 * 第二种：动态规划，不考虑终点，两个终止条件。（可以满足单人走楼梯问题，只要减少里面一次for循环，使得m不变）
 * @author admin
 *
 */
public class StairsRoad {
	public static int steps=4, max = 20;
	public static int[][] i = new int[max+1][max+1];


	/**
	 * 第一种
	 * 不考虑先后顺序的
	 * @param n
	 * @param m 如果10级台阶，最高是11
	 * @param x
	 * @return
	 */
	public static int Stairs(int n,int m,int x){
		//确定走x步，从n->m有多少种可能？
		int p=0,l=0;
		for (int i = 0; i <= (m-n)/4; i++) {
			for (int j = 0; j <= (m-4*i-n)/3; j++) {
				for (int k = 0; k <= (m-4*i-3*j-n)/2; k++) {
					l=4*i+3*j+2*k+(x-i-j-k);
						if (m-n == l) {
							p++;
//							System.out.println(i+"次4步\t"+j+"次3步\t"+k+"次2步\t"+(x-i-j-k)+"次1步;\t");
					}
				}
			}
		}
		return p;
	}

	/**
	 * 第二种
	 * 动态规划，只看cnt种情况，不确定终点(问题是m和n相差过大的时候，运算速度变得极慢)
	 * 俩个终止条件，一个是有效，保留
	 * @param n A往上走的起始位置
	 * @param m B往下走的起始位置
	 * @return 全遍历的走，走到了+1（可以满足单人走楼梯问题，只要减少里面一次for循环，使得m不变）
	 */
	//修改第二种，加快程序的运行，所以提前内存化，与斐波那契数列一样
	public static int Stairs(int n, int m){
		if (n>m) {
			return 0;
		}
		if (n == m) {
			return i[n][n]=1;
		}
		int cnt =0;
		for (int i = 1; i <= steps; i++) {
			for (int j = 1; j <= steps; j++) {
				cnt+= Stairs(n+i, m-j);
			}
		}
		return i[n][m]=cnt;
	}

	public static void main(String[] args) {

		System.out.println(Stairs(0, 11));


	}

}
