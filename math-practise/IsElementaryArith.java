package com.company;


import java.math.BigDecimal;
import java.util.Arrays;

import com.company.tools.J2SETest;




/**
 * 程序算法趣题Q2
 * 我的解法一，在方法里可看出我的想法
 * 问题1：isElement方法里的int类型导致/把小数点都忽略了，所以实际上有大量不完美符合的数需要剔除->改为double
 * 问题2：我的计算思路有误--->应该要改为for循环的全遍历
 * 但是我的思路已经很完善，所以需要改的是不要约束乘法的次数
 *  Created by admin on 2018/1/26.
 *
 */
public class IsElementaryArith {
	public int count = 0;
	public J2SETest jt =new J2SETest();
	//StackOverflowError错误出现是因为，我为了调用内部类方法直接洗了一个,就在下面，
	//这样在main里定义实现的时候就会递归无限定义这个类
	/*public IsElementaryArith iee = new IsElementaryArith;*/

	/**
	 * 反转数组
	 * @param paraNum
	 * @return
	 */
	public static int reverseNum(int paraNum){
		int revNum =0;
		while(paraNum !=0 ){
			revNum = paraNum %10 + revNum *10;
			paraNum /=10;
		}
		return revNum;
	}

	public static int[] charArrToint(int i){
		char[] n = String.valueOf(i).toCharArray();
		//m之前直接定义为null没有限定长度，这样会报错误
		int[] m = new int[String.valueOf(i).length()];
		for(int a =0;a<n.length;a++){
			m[a] = n[a] - '0';
		}
		//显示m数组里每一个
		/*System.out.println(Arrays.toString(m));*/
		return m;
	}

	/**
	 * 是否满足算是结果是各个位数上的数逆序排列的数
	 * 因为这个问题重点在乘除
	 * 在四位数中只有2位数乘以2位数或者1位数乘以三位数满足，所以可判断无其它可能性
	 * @param i
	 * @return
	 */
	public Boolean isElement(int i){
		double j = IsElementaryArith.reverseNum(i);
		int[] m = IsElementaryArith.charArrToint(i);



		//方法二：麻烦，通过新建另一个类来处理字符串的四则运算来得出结果，不过它的思路简单一些，但是实际代码的复杂度更高，写的更麻烦，不推荐
		//不能用char定义的原因是，int类型和char类型相加默认为他们的asc码相加所以得不到我们要的效果，必须用String字符串相加
		/*char[] op={'*','\0'};*/
		String[] op = {"*",""};
		String li ="";
		for (int k = 0; k < op.length; k++) {
			for (int k2 = 0; k2 < op.length; k2++) {
				for (int l = 0; l < op.length; l++) {
					li = m[0]+op[k]+m[1]+op[k2]+m[2]+op[l]+m[3];
					if(J2SETest.calc(li).compareTo(BigDecimal.valueOf(j))==0 && !(k==k2&&k2==l&&l==k)){
						System.out.println(li+"----"+J2SETest.calc(li)+"-------"+BigDecimal.valueOf(j));
						return true;
					}
				}
			}
		}
		//Java中的强类型必须要转化所以需要定义自己的方法和类

		//我若是要“简化”下面的判断，需要全部的运算遍历（当然眼前只需要*和""俩个操作符）
		//每次结果定义为String 然后用字符串匹配来运算
		//但是在实际中，现在下面的方法是简单的，对于这道题来说足够，并不多余
		/*if(j/(10*m[0]+m[1])==(10*m[2]+m[3]))
			return true;
		if(j/m[0]==(100*m[1]+10*m[2]+m[3]))
			return true;
		if(j/(m[0]*m[1]*m[2])==m[3])
			return true;
		if(j/(m[0]*m[1])==(10*m[2]+m[3]))
			return true;*/
		return false;
	}


	public static void main(String[] args) {
		int i =1000;
		int b =2;
		IsElementaryArith ie = new IsElementaryArith();
		ie.charArrToint(i);

		do {
			i++;
			if(ie.isElement(i) && i%10!=0){
				ie.count++;
				System.out.println("第"+ie.count+"次符合结果的数是："+i);
			}
		} while (i<=9999);
		/*若要直接1234可以变为String类型就可以直接位数相加，然后再转成int类型就行System.out.println(i+1);*/
		System.out.println("一共有："+ie.count+"次");

	}

}
