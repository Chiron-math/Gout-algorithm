package com.company;
/**
 * ����Ա�㷨Ȥ�⣺Q4
 * ��ľͷ���⣺
 * ˼·���Ӳ�����һ�ο���ʹ�õ����������ʼ���㣬������һ�ο���ʹ�õ����������
 * ��û���
 * @author admin
 *Created by admin on 2018/1/27.
 */
public class SlicerWoods {
	//���˶��ٴ�,���-1����˼�ˡ�Ϊʲô��ô���ã��Ժ������˿��Կ���һ��
	public int i =-1;
	//��ʣ�¶��ٿ�ľͷҪ��
	public int count =1;
	//ľͷ�ĳ���
	public int n =0;
	//���Ƶ��������
	public int m =0;
	
	/**
	 * 
	 * @param n ����Ҫ�еĳ���
	 * @param m ��ͬʱ������������
	 */
	public SlicerWoods(int n,int m) {
		// TODO Auto-generated constructor stub
		this.n = n;
		this.m = m;
	}
	
	/*
	 * ��������������ľͷ��취
	 * �õݹ�ʵ����
	 */
	public void sliceunlimit(int n) {
		++i;
		System.out.println("�Ѿ�����"+i+"��, ��ʱ��"+count+"��ľ�飬��ʣ"+n+"����ľͷҪ��");
		if (n!=1) {
			if (n%2 !=0) {
				 sliceunlimit(n-1);
				 //����������ʱ������һ����������ż���������Ļ�����Ҫ�е�ľͷ����û��
				 //count��������
			}else{
				count *=2;
				//count�������sliceunlimit()��������������˼�ģ�����count��ֵ���䣬ֻ��������count��ֵ�Żᴫ��sliceunlimit��������
				 sliceunlimit(n/2);
			}
		}
	}
	
	/**
	 * ��������m����ľͷ��취����������ò��������ţ�
	 * @param n ����
	 * @param m ���Ƶ�����
	 */
	public void slicelim(int n,int m){
		
		
	}
	
	public static void main(String[] args) {
		SlicerWoods swood = new SlicerWoods(20,3);
		swood.sliceunlimit(20);
		
		int a =5;
		int b =7;
		System.out.println(a+""+b);
	}
}
