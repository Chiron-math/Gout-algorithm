package com.company.primary;

import java.util.Iterator;

/**
 * Q13 有多少种满足字母算式的j解法
 * 暂时：改为流程图的字符串自动转运算（意思是没有*'/'优先级大于+-的转换）
 * 123*23/5+1*5不会先算1*5只会先算+1的和再乘以5
 * @author admin
 *
 */
public class Lettersformula {
	//s3是得到的运算符号
	public String s3;
	//s2是作为字符串得到的数字
	public String[] s2;
	//d作为将s2字符串数组型数值转换类型，用于计算
	public double[] d;


	public Lettersformula(String s) {
		//s2 = s.split("[*|/|(|)]");
		System.out.println(s+"从左到右流程的运算结果为：");
		s2 = s.split("[^0-9]+");
		s3 = s.replaceAll("[0-9]+", "");
		d = new double[s2.length];
		for (int i = 0; i < s2.length; i++) {
			d[i] = Double.parseDouble(s2[i]);
		}
		//字符串第一个是数字时的计算
		if (s.charAt(0)>30&&s2.length==s3.length()+1) {
			calc();
		}else {
			System.out.println("错误");
		}
	}

	/**
	 * 前面不考虑括号的字符串运算
	 * @return
	 */
	public double calc(){
		double sum=d[0];
		for (int i =1; i < s2.length; i++) {
			switch (s3.charAt(i-1)) {
			case '+':
				sum += d[i];
				break;
			case '*':
				sum *= d[i];
				break;
			case '/':
				sum /= d[i];
				break;
			case '-':
				sum -= d[i];
				break;
			default:
				System.out.println("字符串里包含错误的字符");
				break;
			}
		}
		System.out.println(sum);
		return sum;
	}

	public static void main(String[] args) {
		String s1 = "123*23/5+1*5";
		Lettersformula lf = new Lettersformula(s1);

	}
}
