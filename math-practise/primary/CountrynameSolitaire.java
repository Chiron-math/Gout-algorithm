package com.company.primary;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Q14世界杯参赛国的国名接龙
 * @author admin
 * 假设每个国名只能使用一次
 * 求能接的最长的顺序，以及响应的国名个数
 * 这里删去了返回int值的递归，因为返回的int值信息少无法转换为对应的最长顺序字符串
 */
public class CountrynameSolitaire {
	public static String[] s = {"Brazil","Croatia","Mexico","Spain","Netherlands","Chile","Australia",
								"Colombia","Greece","Cote d'lvoire","Japan","Uruguay","Costa Rica",
								"England","Italy","Swizerland","Ecuador","France","Honduras","Agentina",
								"Bosina  and Heraegovina","Iran","Nigeria","Germany","Portugal","Ghana",
								"USA","Belgium","Algeria","Russia","Korea Republic","Cameroon"};
	public static String[] s1;
	public static Set<String> se1 =new CopyOnWriteArraySet<String>();


	public CountrynameSolitaire() {
		String sss = null;
		int m=0, n=0;
		for (int i = 0; i < s.length; i++) {
			s[i] = s[i].toUpperCase();
			se1.add(s[i]);
		}
		for (String string : se1) {
			s1 = solitatire(string).split("->");
			n = s1.length;
			if (m<n) {
				m=n;
				sss = solitatire(string);
			}
		}
		System.out.println("最多的接龙有"+m+"种，情况是"+sss);
	}


	public static String solitatire(String str){
		int n =0,m=0;
		String val= "",val2 ="";
		//刚开始remove和add放在while里，总是引起并发问题，且不需要
		se1.remove(str);
		Iterator<String> it = se1.iterator();
		while(it.hasNext()){
			String value = it.next();
			if (value.charAt(0)==str.charAt(str.length()-1)) {
				val = str+"->"+solitatire(value) ;
			}
			if (val2.length()<val.length()) {
				val2 = val;
			}
		}
		se1.add(str);
		if (val2=="") {
			return str;
		}
		return val2;
	}


	public static void main(String[] args) {
		CountrynameSolitaire cs =new CountrynameSolitaire();
//		System.out.println(solitatire(s[1]));



	}
}
