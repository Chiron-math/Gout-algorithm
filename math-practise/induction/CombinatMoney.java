package com.company;

/**
 * 程序员算法趣题Q5
 * 纸币换币
 * @author admin
 *  Created by admin on 2018/1/28.
 */
public class CombinatMoney {

	/**
	 * 循环法得到组合
	 * @param mount
	 * @param changes
	 * @param num
	 * @return
	 */
	public static int Combinat(int mount, int[] changes,int num){
		int count = 0;
		for (int i = 0; i <= mount/changes[0]; i++) {
			for (int j = 0; j <= mount/changes[1]; j++) {
				for (int j2 = 0; j2 <= mount/changes[2]; j2++) {
					for (int k = 0; k <= mount/changes[3]; k++) {
						if(mount == i*10+j*50+100*j2+500*k && i+j+k+j2+k<=num)
						{
						count ++;
						System.out.println("10元面值"+i+"张，50元面值"+j+"张，100元面值"+j2+"张，500元面值"+k+"张。\n");
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int[] x = {10,50,100,500};
		int count = 0;

		CombinatMoney cm = new CombinatMoney();

		System.out.println("一共"+cm.Combinat(1000, x, 15)+"种组合方式");

	}

}
