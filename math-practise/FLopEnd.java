package com.company;

import java.awt.FlowLayout;

/**
 * ����Ա�㷨Ȥ�⣺Q3
 * ���շ���˳�򣬸տ�ʼȫ������ӵ�n�ſ�ʼÿ��n-1�Ʒ�һ�Σ�����100���Ʊ��泯�ϵ�����Щ��
 * ������泯�ϣ���ʼ���棬������boolean[]Ĭ��Ϊfalse������ж���false����
 * ���������ƽ����
 * ��������Ϊ����1�⣬ÿ���ƶ��ᱻ������һ�Ρ����Է�������һ����ż����
 * ����������ɹ��ɼ�����n��ΪԼ����������������1����ôһ�㶼��������Լ��
 * Ҫ�ﵽż���Σ�Լ����һ����һ���ǲ�����������ϣ��Լ������Լ������֣�����ƽ����
 * @author admin
 * Created by admin on 2018/1/27.
 */
public class FLopEnd {
	boolean[] a = null;
	int count = 0;
	
	public FLopEnd(int count) {
		// TODO Auto-generated constructor stub
		this.a = new boolean[count];
		this.count = count;
	}
	
	
	public void calcToEnd(){
		
		System.out.println(a.length);
		//����
		for (int j = 1; j < a.length; j++) {
			for (int i = j; i < a.length; i+=j+1) {
				a[i] = !a[i];
			}
		}
		//���
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			if(!a[i])
				System.out.print(i+1+" ");
		}
		System.out.println("]");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FLopEnd fe =new FLopEnd(100);
		fe.calcToEnd();
		
	}

}
