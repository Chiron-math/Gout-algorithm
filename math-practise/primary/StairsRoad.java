package com.company.primary;

/**
 * Q15 走楼梯
 * 当存在10级台阶，且移动规则相同时，有多少种两人最终停在同一级的情况
 * 把问题转换为一人从0到i，另一人从i往第11级走。计算i级的情况时，步数遍历，总共情况。
 * @author admin
 *
 */
public class StairsRoad {

	/**
	 * 单人走楼梯问题（并不确定每次的步数）
	 * @param n 从第n个楼梯出发
	 * @param m 目标第m个
	 * @return 多少种类方法（不确定走了多少步）
	 */
	public static long S(int n,int m){
		long a =0;
		if (n+4<=m) {
			return S(n+1,m)+S(n+2,m)+S(n+3,m)+S(n+4,m);
		}else if (n+3<=m) {
			return S(n+1,m)+S(n+2,m)+S(n+3,m);
		}else if (n+2<=m) {
			a = S(n+1,m)+S(n+2,m);
			return S(n+1,m)+S(n+2,m);
		}else{
			return 1;
		}

	}

	/**
	 * 不考虑先后顺序的
	 * @param n 从第n个楼梯出发
	 * @param m 目标第m个  如果10级台阶，最高是11
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

	public static void main(String[] args) {
		int mount=0,steps=0,max=11;

		for (int i = 1; i <= max; i++) {
			steps=i<=10-i?i:max-i;
			for (int j = 0; j < steps; j++) {
				mount+=Stairs(0, i, j)*Stairs(i, max, j);
			}
		}
		System.out.println(mount);
	}

}
