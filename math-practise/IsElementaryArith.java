package com.company;


import java.math.BigDecimal;
import java.util.Arrays;

import com.company.tools.J2SETest;




/**
 * �����㷨Ȥ��Q2
 * �ҵĽⷨһ���ڷ�����ɿ����ҵ��뷨
 * ����1��isElement�������int���͵���/��С���㶼�����ˣ�����ʵ�����д������������ϵ�����Ҫ�޳�->��Ϊdouble
 * ����2���ҵļ���˼·����--->Ӧ��Ҫ��Ϊforѭ����ȫ����
 * �����ҵ�˼·�Ѿ������ƣ�������Ҫ�ĵ��ǲ�ҪԼ���˷��Ĵ���
 *  Created by admin on 2018/1/26.
 *
 */
public class IsElementaryArith {
	public int count = 0;
	public J2SETest jt =new J2SETest();
	//StackOverflowError�����������Ϊ����Ϊ�˵����ڲ��෽��ֱ��ϴ��һ��,�������棬
	//������main�ﶨ��ʵ�ֵ�ʱ��ͻ�ݹ����޶��������
	/*public IsElementaryArith iee = new IsElementaryArith;*/
	
	/**
	 * ��ת����
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
		//m֮ǰֱ�Ӷ���Ϊnullû���޶����ȣ������ᱨ����
		int[] m = new int[String.valueOf(i).length()];
		for(int a =0;a<n.length;a++){
			m[a] = n[a] - '0';
		}
		//��ʾm������ÿһ��
		/*System.out.println(Arrays.toString(m));*/
		return m;
	}
	
	/**
	 * �Ƿ��������ǽ���Ǹ���λ���ϵ����������е���
	 * ��Ϊ��������ص��ڳ˳�
	 * ����λ����ֻ��2λ������2λ������1λ��������λ�����㣬���Կ��ж�������������
	 * @param i
	 * @return
	 */
	public Boolean isElement(int i){
		double j = IsElementaryArith.reverseNum(i);
		int[] m = IsElementaryArith.charArrToint(i);
		
		
		
		//���������鷳��ͨ���½���һ�����������ַ����������������ó��������������˼·��һЩ������ʵ�ʴ���ĸ��Ӷȸ��ߣ�д�ĸ��鷳�����Ƽ�
		//������char�����ԭ���ǣ�int���ͺ�char�������Ĭ��Ϊ���ǵ�asc��������Եò�������Ҫ��Ч����������String�ַ������
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
		//Java�е�ǿ���ͱ���Ҫת��������Ҫ�����Լ��ķ�������
		
		//������Ҫ���򻯡�������жϣ���Ҫȫ���������������Ȼ��ǰֻ��Ҫ*��""������������
		//ÿ�ν������ΪString Ȼ�����ַ���ƥ��������
		//������ʵ���У���������ķ����Ǽ򵥵ģ������������˵�㹻����������
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
				System.out.println("��"+ie.count+"�η��Ͻ�������ǣ�"+i);
			}
		} while (i<=9999);
		/*��Ҫֱ��1234���Ա�ΪString���;Ϳ���ֱ��λ����ӣ�Ȼ����ת��int���;���System.out.println(i+1);*/
		System.out.println("һ���У�"+ie.count+"��");
		
	}

}
