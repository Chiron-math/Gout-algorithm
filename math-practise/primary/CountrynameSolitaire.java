package com.company.primary;

import java.util.HashSet;

/**
 * Q14国名接龙
 * @author admin
 *
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

	//这是返回int值，得到最高步数的情况，但是上面的可以显示出来过程
	/*public static int solitatire(String str){
		int n =0,m=0;
		String val= "";
		//刚开始remove和add放在while里，总是引起并发问题，且不需要
		se2.remove(str);
		Iterator<String> it = se2.iterator();
		while(it.hasNext()){
			String value = it.next();
			if (value.charAt(0)==str.charAt(str.length()-1)) {
				n = solitatire(value) +1;
			}
			if (m<n) {
				m=n;
				val = value;
			}
		}

		se2.add(str);
		if (m==0) {
			return 1;
		}

		//这样有错，因为用Iterator进行便利，通过.remove(Object)进行操作，
		//全局修改使得与遍历时定的值不同报错
		for(String string : se2){
			if (string.charAt(0)==str.charAt(str.length()-1)) {
				se2.remove(string);
				n = solitatire(string)+1;
				se2.add(string);
			}
		}

		return m;
	}*/



	public static void main(String[] args) {
		CountrynameSolitaire cs =new CountrynameSolitaire();
//		System.out.println(solitatire(s[1]));



	}
}
