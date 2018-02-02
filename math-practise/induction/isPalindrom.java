package com.company;

/**
 * 程序员算法趣题Q：01回文十进制数
 * 求用十进制、二进制、八进制表示都是回文数的所有数字中，大于十进制数10的最小值
 * Created by admin on 2018/1/25.
 * 修改一步在deciToX()里，时间2018/1/25
 * 修改deciToX()，完善逆序功能和数值的范围过小导致的溢出问题
 * 将输入的类型都转为String
 */
public class isPalindrom {


	/**
	 * 判断是否回文，用Java默认库将其转换为字符串然后首尾比较
	 * 若是提前while失败，则m定小于数位的一半-1
	 * m<digit是为了防止数组下标越界
	 * @param i
	 * @return
	 */
	public Boolean isPalin(String i){
		boolean b = true;
		int m = 0;
		char[] d = i.toCharArray();
		int digit = i.length()-1;
		while(m < digit && d[m] == d[digit-m])
			m++;
		//之前在m判断里m < (digit+1)/2-1在偶数是有问题
		if( m < (digit+1)/2)
			b = false;
		return b;
	}


	/**
	 * 默认不逆序，只是单纯的M进制->N进制
	 * @param i
	 * @return
	 */
	public static String deciToX(String a,int scale_start, int scale_end){
		char[] b = a.toCharArray();
		long revdat=0;
		int i=0;
		String cc = "";

		//将给的字符串数值按照进制转换为10进制
		do {
			revdat = (long)Math.pow(scale_start,a.length()-i-1)*((b[i]-'0')%scale_start)+revdat;
//			System.out.println(revdat+"第"+i+"次");
			i++;
		} while (i<a.length());
//		System.out.println("转换后的数值"+revdat);
			do {
				cc =  revdat%scale_end+cc;
				revdat/=scale_end;
			} while (revdat>0);
		return cc;
	}
	/**
	 * 考虑逆序的功能要求和如果数值过大，那转为String输出型
	 * 这样就不会因为大的进制转换成小的导致值溢出
	 * @param a
	 * @param scale_start
	 * @param scale_end
	 * @param nixu
	 * @return
	 */
	public static String deciToX(String a,int scale_start, int scale_end, boolean nixu){
		char[] b = a.toCharArray();
		long revdat=0;
		int i=0;
		String cc = "";

		do {
			revdat = (long)Math.pow(scale_start,a.length()-i-1)*((b[i]-'0')%scale_start)+revdat;
//			System.out.println(revdat+"第"+i+"次");
			i++;
		} while (i<a.length());
//		System.out.println("转换后的数值"+revdat);

		if (nixu) {
			do {
				cc +=  revdat%scale_end;
				revdat/=scale_end;
			} while (revdat>0);
		}else{
			do {
				cc =  revdat%scale_end+cc;
				revdat/=scale_end;
			} while (revdat>0);
		}
//		System.out.println(cc);
		return cc;
	}


    public static void main(String[] args) {

    	int i =11;
    	System.out.println("10进制、2进制、8进制回文数字大于10进制的10的最小值是：");

    	isPalindrom ip = new isPalindrom();
    	int cc =0;
    	String m ,n ;
    		System.out.println(ip.isPalin("121"));
    		do{
    			cc++;
    			i +=2;
    			//因为有二进制，最高位必定是1所以求回文的结果也一定是1
    			//得到结论，所求的数值是奇数
    			m = ip.deciToX(i+"", 10,2);
    			n = ip.deciToX(i+"", 10,8);
    		}while(!ip.isPalin(m)||!ip.isPalin(n)||!ip.isPalin(i+""));
    		System.out.println(m+" "+ip.isPalin(m));
    		System.out.println(n+" "+ip.isPalin(n));
    		System.out.println("结果是："+i);

    		System.out.println("程序找了"+cc+"次");
    	/*System.out.println(isPalindrom.deciToX("1024", 10,2, true));*/

	}


}
