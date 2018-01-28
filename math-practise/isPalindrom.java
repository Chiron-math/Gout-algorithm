package com.company;

/**
 * 程序员算法趣题Q：01
 * Created by admin on 2018/1/25.
 * 修改一步在deciToX()里，时间2018/1/25
 */
public class isPalindrom {

	
	/**
	 * 判断是否回文，用Java默认库将其转换为字符串然后首尾比较
	 * 若是提前while失败，则m定小于数位的一半-1
	 * m<digit是为了防止数组下标越界
	 * @param i
	 * @return
	 */
	public Boolean isPalin(int i){
		boolean b = true;
		int m = 0;
		char[] d = String.valueOf(i).toCharArray();
		int digit = String.valueOf(i).length()-1;
		while(m < digit && d[m] == d[digit-m])
			m++;
		//之前在m判断里m < (digit+1)/2-1在偶数是有问题
		if( m < (digit+1)/2)
			b = false;
		return b;
	}

	
	/**
	 * do {
			count=10*(count+i%scale);
			i=i/scale;
		} while (i>scale);
		count +=i/scale;
		count =count/10;
		结果会倒过来而且有问题
	 */
	/**
	 * 十进制转化为X进制
	 * 将余数放后，最后得到的除数放在作为位数标记m的位置上（即是首位）
	 * 这样不会出现倒过来的情况
	 * Mtah.pow指数运算(10,m)10的m次运算
	 * @param i
	 * @return
	 */
	public int deciToX(int i, int scale){
		int count=0;
		//更简单方法，直接用String的连接特性，省去相乘的问题
		String cc = "";
		do {
			cc +=  i%scale;
			i/=scale;
		} while (i>0);
			count = Integer.parseInt(cc);
		
		/*int m =0;
		do {
			m++;
			count = count + (int)Math.pow(10, m)*(i%scale);
			i = i/scale;
		} while (i>=scale);
			count = count/10;
			count = count + (int)Math.pow(10, m)*(i);*/
		System.out.println(""+count);
		return count;
	}
	
    public static void main(String[] args) {
		
    	int i =101;
    	System.out.println("10进制、2进制、8进制回文数字大于10进制的10的最小值是：");
    	
    	isPalindrom ip = new isPalindrom();
    	int cc =0;
    	int m = 0 ,n =0;
    		/*System.out.println(ip.isPalin(121));*/
    		do{
    			cc++;
    			i +=2;
    			//因为有二进制，最高位必定是1所以求回文的结果也一定是1
    			//得到结论，所求的数值是奇数
    			m = ip.deciToX(i, 2);
    			n = ip.deciToX(i, 8);
    		}while(!ip.isPalin(m)||!ip.isPalin(n)||!ip.isPalin(i));
    		System.out.println(m+" "+ip.isPalin(m));
    		System.out.println(n+" "+ip.isPalin(n));
    		System.out.println("结果是："+i);
    		
    		System.out.println("程序找了"+cc+"次");
    	
	}


}
