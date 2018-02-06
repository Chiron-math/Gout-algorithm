package com.company.primary;

import java.util.ArrayList;

/**
 * Q19 找朋友
 * 有相同约数即为朋友
 * 1到n中取7个数字，满足最长找6层的最小n值
 * “6度空间理论”
 * 合数按照相通的约数（质数）跳转，那么满足最长6次的最小n值意味着，这里面的质数变6次
 * 最小意味着 2,3,5,7,11,13里面找，最小合数从最小质数积4（2的平方）开始到最后一个 质数积X（X的平方）经过 6次————遍历6的质数的路径
 * 找到每条路径里的最大值，然后 再比较这些最大值里最小的一个，表示出来
 * @author admin
 *
 */
public class Friendstofri {
	public static int[] pri = {3,5,7,11,13};
	//用来遍历的数组
	public static List<Integer> l = new CopyOnWriteArrayList<Integer>();
	//最终得出的最大值N
	public static int pmax=169;
	//最终得出的路径
	public static String s="";


	//构造函数里表示了一切
	public Friendstofri() {
		for (int i : pri) {
			this.l.add(i);
		}
		fri(6, 2, 4, "[  4");
		System.out.println("取出来的七个数字是："+s);
		System.out.println("得到的最小N值是："+pmax);
	}


	/**
	 * 这次的递归使我充分体会了什么能传进来，如何传，是否需要输出
	 * @param n  还有几步要转
	 * @param m  上一步的质数传递下来，根据这一次的选择得到质数积
	 * @param max  这一次路径里的最大值
	 * @param str  这一次路径的字符串表示
	 */
	public static void fri(int n,int m,int max,String str){
		if (n==1) {
			str += ",  "+ m*m +"]";
			if (m*m>max) {
				max = m*m;
			}
			//比较所有遍历结果的最大值中取最小
			//得到其中的路径
			if (max<pmax) {
				pmax=max;
				s =str;
			}
		}
		String s = str;
		for (Integer a : l) {
			l.remove(a);
			//str存放的是每次选择的路径
			str += ",  "+ a*m;
			//max和该点的值（由上一个位置上质数和这次位置上质数的积）比较
			//提取最大值
			if (m*a > max) {
				fri(n-1, a, a*m, str);
			}else {
				fri(n-1, a, max, str);
			}
			l.add(a);
			str = s;
		}
	}

	public static void main(String[] args) {
		Friendstofri ff = new Friendstofri();
	}


}
