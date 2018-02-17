package com.company;

/**
 * Q08 优秀的扫地机器人
 * 一款不会反复清扫同一个地方的机器人，
 * 一次只能前后左右移动，不能走回头路
 * 问走12步有多少种可能性
 * @author admin
 *
 */
public class OntheGrid {
	public String str ="/0,0/";
	public int count = 0,x=0,y=0;
	public OntheGrid() {
	}


	/**
	 * 有点像深度遍历，把所有的情况遍历+1
	 * @param mount 步数
	 */
	public void countNum(int mount){
		if (mount == 0) {
			 ++count;
		}else{
		//1,0
		//即使判断结果为false，xy的值不能变
		if (!str.contains("/"+(1+x)+","+y+"/")) {
			str = str+"/"+(++x)+","+y+"/";
			countNum(mount-1);
			str=str.replace("/"+x+","+y+"/", "");
			x--;
		}
		//0,1
		if (!str.contains("/"+x+","+(y+1)+"/")) {
			str += "/"+x+","+(++y)+"/";
			countNum(mount-1);
			str=str.replace("/"+x+","+y+"/", "");
			y--;
		}
		//-1,0
		if (!str.contains("/"+(x-1)+","+y+"/")) {
			str += "/"+(--x)+","+y+"/";
			countNum(mount-1);
			str=str.replace("/"+x+","+y+"/", "");
			x++;
		}
		//0,-1
		if (!str.contains("/"+x+","+(y-1)+"/")) {
			str +="/"+x+","+(--y)+"/";
			countNum(mount-1);
			str=str.replace("/"+x+","+y+"/", "");
			y++;
		}

		//如果提前进入死路，不算一条;包含进了mount==0的条件里，所以不需要了
/*		if (str.contains("/"+(++x)+","+(++y)+"/")&&str.contains("/"+(--x)+","+(++y)+"/")&&str.contains("/"+(--x)+","+y+"/")&&str.contains("/"+x+","+(--y)+"/")&&mount!=0) {
		}*/

		}

	}

	public static void main(String[] args) {

		OntheGrid og = new OntheGrid();
		og.countNum(12);
		System.out.println("步数为12的时候，一共有"+og.count+"种");



	}

}
