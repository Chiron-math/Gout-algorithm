package com.company;

/**
 * Q10轮盘赌
 * 轮盘设计有欧式和美式规则两种，
 * 在这些规则下找出“连续n个数字的和”最大位置（条件：n中美式规则的和大于欧式规则）
 * @author admin
 *
 */
public class Roulette {
	public int[] Euro_rul ={0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26};
	public int[] Amer_rul ={0,28,9,26,30,11,7,20,32,17,5,22,34,15,3,24,36,13,1,00,27,10,25,29,12,8,19,31,18,6,21,33,16,4,23,35,14,2};
	public int sum_amr,sum_eur;
	public int a=0,b=0;

	/**
		 * 提前赋值使得每次变化的和只要加一个新的第n数，减去一个旧的前数
		 * 这样减少了循环数量
		 * 求n个
		 * @param n个连续数里马努在美式大于欧式的情况则输出
		 */
		public boolean get(int n){

			for (int j = 0; j < n; j++) {
				a+=Euro_rul[j];
				}
			for (int i = 0; i < Euro_rul.length; i++) {
				if (i+n>=Euro_rul.length) {
						a+=Euro_rul[i+n-Euro_rul.length]-Euro_rul[i];
					}else {
						a=a+Euro_rul[i+n]-Euro_rul[i];
					}
				if (a>sum_eur) {
					sum_eur = a;
				}
			}
			a=0;
	//		System.out.print(sum_eur+"  ");
			for (int j = 0; j < n; j++) {
				b+=Amer_rul[j];
				}
			for (int j = 0; j < Amer_rul.length; j++) {
				if (j+n>=Amer_rul.length) {
					b=b+Amer_rul[j+n-Amer_rul.length]-Amer_rul[j];
				}else {
					b=b+Amer_rul[j+n]-Amer_rul[j];
				}
				if (b>sum_amr) {
					sum_amr = b;
				}
			}
			b=0;
	//		System.out.println(sum_amr+"\n");

				if (sum_amr>sum_eur) {
	//			System.out.println("美式规则更大，且最大的数字和为："+sum_amr);
					return true;
				}

			return false;
		}



	public static void main(String[] args) {
		Roulette rl = new Roulette();
//		if (rl.get(2)) {
//			System.out.println("满足要求");
//		}
		System.out.print("n为[ ");
		for (int i = 2; i <= 36; i++) {
			if (rl.get(i)) {
				System.out.print(""+i+", ");
			}
		}
		System.out.println("]时满足要求");
	}
}
