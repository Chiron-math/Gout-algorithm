package com.company;

/**
 * ����Ա�㷨Ȥ��Q��01
 * Created by admin on 2018/1/25.
 * �޸�һ����deciToX()�ʱ��2018/1/25
 */
public class isPalindrom {

	
	/**
	 * �ж��Ƿ���ģ���JavaĬ�Ͽ⽫��ת��Ϊ�ַ���Ȼ����β�Ƚ�
	 * ������ǰwhileʧ�ܣ���m��С����λ��һ��-1
	 * m<digit��Ϊ�˷�ֹ�����±�Խ��
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
		//֮ǰ��m�ж���m < (digit+1)/2-1��ż����������
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
		����ᵹ��������������
	 */
	/**
	 * ʮ����ת��ΪX����
	 * �������ź����õ��ĳ���������Ϊλ�����m��λ���ϣ�������λ��
	 * ����������ֵ����������
	 * Mtah.powָ������(10,m)10��m������
	 * @param i
	 * @return
	 */
	public int deciToX(int i, int scale){
		int count=0;
		//���򵥷�����ֱ����String���������ԣ�ʡȥ��˵�����
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
    	System.out.println("10���ơ�2���ơ�8���ƻ������ִ���10���Ƶ�10����Сֵ�ǣ�");
    	
    	isPalindrom ip = new isPalindrom();
    	int cc =0;
    	int m = 0 ,n =0;
    		/*System.out.println(ip.isPalin(121));*/
    		do{
    			cc++;
    			i +=2;
    			//��Ϊ�ж����ƣ����λ�ض���1��������ĵĽ��Ҳһ����1
    			//�õ����ۣ��������ֵ������
    			m = ip.deciToX(i, 2);
    			n = ip.deciToX(i, 8);
    		}while(!ip.isPalin(m)||!ip.isPalin(n)||!ip.isPalin(i));
    		System.out.println(m+" "+ip.isPalin(m));
    		System.out.println(n+" "+ip.isPalin(n));
    		System.out.println("����ǣ�"+i);
    		
    		System.out.println("��������"+cc+"��");
    	
	}


}
