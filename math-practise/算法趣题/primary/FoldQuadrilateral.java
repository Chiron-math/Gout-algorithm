package com.company.primary;

/**
 * Q16 三根绳子折四边形
 * @author admin
 */
public class FoldtheQuadrilateral {

	/**
	 * 绳子长度为l时，可组合多少种？
	 * @param l 绳子的长度
	 * @return 可组合的种数
	 */
	public static int conjecture(int l){
		if (l%4!=0) {
			return 0;
		}
		int cnt=0,lensid = l/4;
		//因为正方形根据绳长l固定为lensid
		//设第一个长方形长为lensid+i宽为lensid-i
		//设第一个长方形长为lensid+j宽为lensid-j
		//又因两个长方形不可能相同，可以默认i<j
		for (int i = 1; i < lensid-1; i++) {
			for (int j = i+1; j < lensid; j++) {
				if (lensid*lensid == i*i+j*j) {
					cnt++;
				}
			}
		}
		return cnt;
	}


	public static void main(String[] args) {
		int cnt =0;
		for (int i = 4; i < 501; i+=4) {
			cnt+=conjecture(i);
		}
		System.out.println(cnt);
	}

}
