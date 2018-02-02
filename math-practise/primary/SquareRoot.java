package com.company.primary;

import java.util.HashSet;
import java.util.Set;

/**
 * Q12平方根
 * @author admin
 *double范围比long大得多,long精度更高
 */
public class SqureRoot {
	public static long n ;
	//位数
	public static int m;

	//脑海第一个想法
	public static int[] b = {0,1,2,3,4,5,6,7,8,9};



	public SqureRoot(long n) {
		this.n = n;
	}

	public static boolean isContainNum(String i){
		int sum =0;
		char[] a = i.toCharArray();
		for (int j = 0; j < a.length; j++) {
			switch (a[j]) {
			case '0':
				b[0]=0;
				break;
			case '1':
				b[1]=0;
				break;
			case '2':
				b[2]=0;
				break;
			case '3':
				b[3]=0;
				break;
			case '4':
				b[4]=0;
				break;
			case '5':
				b[5]=0;
				break;
			case '6':
				b[6]=0;
				break;
			case '7':
				b[7]=0;
				break;
			case '8':
				b[8]=0;
				break;
			case '9':
				b[9]=0;
				break;
			default:
				System.out.println("出错");
				break;
			}
			sum = b[0] +b[1]+b[2]+b[3]+b[4]+b[5]+b[6]+b[7]+b[8]+b[9];
			if (sum==0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 左右逼近，增加位数就将n乘以100，左右逼近的数就可以精确一位,慢
	 * @param n
	 * @return
	 */
	public static long Sqr(long n){
		int li =0;
		long m =0,p=0,a=0;
		a=n;
		while (n!=0) {
			li+=1;
			n=n/10;
		}
		for (m = (long) Math.pow(10, (li-1)/2); m<Math.pow(10, (li+1)/2); m++) {
			if (m*m<=a&&(m+1)*(m+1)>a) {
				p =m;
			}
		}
		return p;
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

	  public static double cbrt(double c)
	  {
	    boolean b = (c>0) ? true : false; //保存c的符号
	    c = (c>0) ? c : -c;
	    double err = 1e-15;
	    double t = c;
	    while(Math.abs(t*t-c/t) > err*t)
	      t = (c/(t*t)+t)/2.0;
	    t = (b) ? t : -t;
	    return t;
	  }


	public static void main(String[] args) {
		/*if (isContainNum("432105946789")) {
			System.out.println("成功");
		}*/
		System.out.println(sqr(9878796543213131564698798779879546465132131564654654987654321D,1e-15));


	}


}
