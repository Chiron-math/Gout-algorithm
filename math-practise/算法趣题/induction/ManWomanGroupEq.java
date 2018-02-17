package com.company;

import java.util.ArrayList;

/**
 * Q09落单的男女
 * 让入场人们从队列的某个位置分为两组，如果到场顺序不对，可能出现无论怎么分，都不能男女均等的情况
 * 3男3女时，男男男女女女，男男女男女女（考虑男女位置交换过来）。一共四种情况
 * 为了使得两组男女人数都不均等，那么按照顺序不可能达到k为1过斜对角点
 * 也就是x=y相等且boy数-x=girl数-y这两种情况不能出现（限制条件）
 * 这题目转换为路径遍历的问题，可以向上走向右走
 * 在这道题目中相当于两条k=1分割了宽为10长为20的长方形，分割线的左右都无法通过，只能从中间走
 * @author admin
 *
 */
public class ManWomanGroupEq {
	public long count =0;
	public int boy ,girl ;
	public long[][] a;

	public ManWomanGroupEq(int boy, int girl) {
		//因为是从0开始，所以实际上有人数+1的种情况考虑
		this.boy = boy+1;
		this.girl = girl+1;
		a = new long[this.boy][this.girl];
		a[0][0] =1;
	}

	/*
	 * 计算有多少条路径，并把每个位置的路径数目赋值给它自身
	 */
	public void CountNum(){
		for (int i = 0; i < boy; i++) {
			for (int j = 0; j < girl; j++) {
				if (i!=j&&boy-i!=girl-j) {
					if (j>0) {
						a[i][j] +=a[i][j-1];
					}
					if (i>0) {
						a[i][j] += a[i-1][j];
					}
				}
			}
		}
		count = a[boy-2][girl-1]+a[boy-1][girl-2];
	}


	public static void main(String[] args) {
		ManWomanGroupEq mwge = new ManWomanGroupEq(20,10);
		mwge.CountNum();
		System.out.println("男女人数为："+mwge.boy+","+mwge.girl+"时候，有"+mwge.count+"种情况\n满足无论怎么分两边都不会出现男女人数相同的情况");

	}
}
