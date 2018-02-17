package com.company;
/**
 * 程序员算法趣题：Q4
 * 切木头问题：
 * 思路：从不限制一次可以使用的最大人数开始计算，再限制一次可以使用的最大人数后
 * 结束完成
 * @author admin
 *Created by admin on 2018/1/28.
 */
public class SlicerWoods {
	//已经切了多少次了
	public int i =0;
	//还剩下多少块木头要切
	public int count =1;
	//木头的长度
	public int n =0;
	//限制的最大人数
	public int m =0;
	//目前木头的根叔
	public int current =1;

	/**
	 *
	 * @param n 工程要切的长度
	 * @param m 可同时工作最大的人数
	 * 当m>n的时候 不限制人数的条件就满足了(定义域同时满足不限制人数的情况)
	 */
	public SlicerWoods(int n,int m) {
		// TODO Auto-generated constructor stub
		this.n = n;
		this.m = m;
	}


	/**
	 * 限制人数m的切木头最快法，（最大利用不让人闲着）
	 * @param n 长度
	 * @param m 限制的人数
	 */
	public void slicelim(int current){
		if (current < n) {
			System.out.println("已经切了"+i+"次, 这时有"+current+"个木块");
			if(current<m){
				slicelim(current * 2);
			}else{
				slicelim(current + m);
			}
		}else {
			System.out.println("已经切了"+i+"次, 这时有"+n+"个木块");
		}
		i++;
	}

	public static void main(String[] args) {
		SlicerWoods swood = new SlicerWoods(20,3);
		swood.slicelim(1);

		/*SlicerWoods swood1 = new SlicerWoods(100,5);
		swood1.slicelim(1);*/
	}
}
