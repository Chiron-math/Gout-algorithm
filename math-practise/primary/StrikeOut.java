package com.company.primary;

import java.util.ArrayList;


/**
 * Q完美三振
 * 内存化一次算两格的情况，得到Set类型数值
 * 但由于栈数目过多，报错。记录，下次修改
 * @author admin
 *
 */
public class StrikeOut {
	public Set<String> strs = new CopyOnWriteArraySet<String>();
	//将连续的两个数换为实际的八种顺序
	public String[] s = {"1-2","2-3","7-8","8-9","1-4","3-6","4-7","6-9"};
	public List<Long> l =  new ArrayList<Long>();
	public String sdel ="";
	public Long d = 0L;

	public StrikeOut() {
		for (int i = 0; i < s.length; i++) {
			strs.add(s[i]);
		}
		l.add((long) 1);
		System.out.println(C(this.strs));
	}

	public Set<String> DelS(String sr,Set<String> strs){
		char[] ca = sr.toCharArray();
		for(String ss : strs){
			char[] ba = ss.toCharArray();
			//只要有一次判断成功，即除去整个，所以不需要更多循环
			aaa:for (int i = 0; i < ba.length; i++) {
					for (int j = 0; j < ca.length; j++) {
						if (ba[i]==ca[j]&&ba[i]!='-') {
							strs.remove(ss);
							sdel += ss+"*";
							break aaa;
						}
					}
				}
		}
		return strs;
	}


	public long C(Set<String> strs){
		long dd =0L;
//		System.out.println(strs.size()+"_");
		//strs.size()场上还剩几个连着的球
		if (strs.size()==3) {
			return 4;
		}else{
			for (String s : strs) {
//				strs.remove(s);
				//DelS里方法里重复删去了该元素
				DelS(s,strs);
				dd+=C(strs);
				String[] sps =sdel.split("\\*");
				for(String sp : sps){
					strs.add(sp);
				}
				sdel ="";
			}
		}
		return dd;

	}

	public static void main(String[] args) {
		StrikeOut so = new StrikeOut();
//		so.C();
//		so.strs.remove("1-2");
//		so.DelS("1-2");
//		so.DelS("3-6");
/*		System.out.println(so.sdel);
		String[] q = so.sdel.split("\\*");
		for (String string : q) {
			System.out.println(string);
		}
		for (String string : so.strs) {
			System.out.print(string+"\t");
		}*/
	}
}
