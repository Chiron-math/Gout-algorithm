package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 程序员算法趣题Q7
 * 日期的二进制转换
 * 问题描述：
 * 01.把年月日表示为YYYYMMDD这样的8位数
 * 02.将整数转换为2进制然后逆序排列
 * 03.再将得到的2进制转换为10进制
 * 04.求与原日期一致的日期
 * @author admin
 * create by  2018/1/29
 */
public class DatePalindrom {
	public isPalindrom ip = new isPalindrom();
	public static DateFormat df2 = new SimpleDateFormat("yyyyMMdd");



	public void isDataPalindrom(int[] start,int[] end){
		//start[1]-1是因为月份 以0开始，按照我们的输入习惯-1
		Calendar sta = new GregorianCalendar(start[0],start[1]-1,start[2]);
		Calendar en = new GregorianCalendar(end[0],end[1],end[2]);
		String dat,revdat ;
		int count =0;


		while(sta.compareTo(en)<=0){
			sta.add(Calendar.DATE, 1);
			dat = df2.format(sta.getTime());
			revdat = ip.deciToX(dat, 10,2,true);
			revdat = ip.deciToX(revdat,2, 10,false);
			if ( revdat.equals(dat)) {
				count ++;
				System.out.println("时间"+dat+"符合要求");
			}
		}

		System.out.println("在"+start.toString()+"到"+end.toString()+"之间有"+count+"个日期符合这样的条件。");
	}



	public static void main(String[] args) {
		String m,n;
		int[] start = {1964,10,10};
		int[] end ={2020,7,24};
		DatePalindrom dp =new DatePalindrom();
		dp.isDataPalindrom(start,end);
		System.out.println();

	}


}
