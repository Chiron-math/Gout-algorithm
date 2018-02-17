package com.company.primary;

import java.util.HashSet;

/**
 * Q12平方根
 * 计算平方根最早让 0~9的数字全部出现的最小整数
 * 两种情况：一种包含整数；一种不包含整数时
 * @author admin
 *double范围比long大得多,long精度更高
 */
public class SqureRoot {

	//set的特点是不会重复
	public static Set<Character> se = new HashSet<Character>();



	/**
	 * 包含整数部分与否 进行判断，得到结果包含0~9所有
	 * @param i 分析的字符串，wipNum是否去除整数
	 * @return
	 */
	public static boolean isContainN(String i,boolean wipNum){
		char[] c;
		System.out.println(i);
		if (wipNum) {
			//不包含整数，从小数点后处理
			c = i.substring(i.indexOf(".")+1).toCharArray();
		}else{
			//包含整数，去除小数点直接处理
			c = i.replace(".", "").toCharArray();
		}
		System.out.println(i.substring(i.indexOf(".")+1));
//		char[] c = i.replace(".", "").toCharArray();
		for (int j = 0; j < c.length; j++) {
			se.add(c[j]);
		}
		//平方根的的值不重复的至少有10个
		if (se.size() == 10||se.size()>10&&se.contains('E')) {
			return true;
		}
		//失败后，se清零
		se.clear();
		System.out.println("不包含0-9的全部");
		return false;
	}

	/**
	 * 牛顿迭代法，符合平方根的要求
	 * @param m 待取平方根的数，err 比较的极小值
	 * @return 返回平方根
	 */
	  public static double sqr(double m,double err){
		  if(m<0) return Double.NaN;
		  //err是用来比较的极小值，n=1的时候
		  double n =1;
		  //因为当m值过大时候，下面的计算量大，所以换成除法，更快
		  //while (Math.abs(n*n-m)>err) {
		  while (Math.abs(n-m/n) > err*n){
			n = (m/n+n)/2.0;
		  	}
		  return n;
	  }


	public static void main(String[] args) {
		int i=1;
		while (!isContainN(""+sqr(i, 1e-15),true)) {
			i++;
		}
		System.out.println("包含0~9数字全部出现的最小整数是："+i);

	}


}
