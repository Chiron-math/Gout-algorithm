package com.company.primary;
/**
 * Q21 异或运算三角形
 * @author admin
 *
 */
public class Xortriangle {
	public static int[][] a = new int[1000][1000];

	/**
	 * 用数组表示异或求出j行i列的值，如果为0计1，直到2014个
	 * @return
	 */
	public static String C(){
		a[1][1]=1;
		int n =0,t=2,j=0;
		do {
				j=t;
				//计算第j行的情况，挨个异或
				for (int i = 1; i <= t; i++) {
					a[j][i] = a[j-1][i-1]^a[j-1][i];
					if (a[j][i]==0) {
						n++;
//						System.out.println("得到第"+n+"个0的位置是第"+j+"层第"+i+"个");
					}
					if (n==2014) {
						return "得到第2014个0的位置是第"+j+"层第"+i+"个";
					}
				}
				t++;
		} while (n<2014);
		return null;
	}


	public static void main(String[] args) {
		System.out.println(C());

	}
}
