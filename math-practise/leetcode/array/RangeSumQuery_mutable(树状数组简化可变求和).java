package algorithm.lintcode.array;

/**
 * 可以更改，但不增加数组
 * 单个增加和整体增加可以重建立数组再用这个方法
 * @author admin
 *
 */
public class RangeSumQuery_mutable {

	/**
	 * 区域和检索 可变
	 * 树状数组BinaryIndexedTree，查询和修改的复杂度都变为O(log(n))
	 */
	private int[] num,bit;

	public RangeSumQuery_mutable(int[] matrix) {
		num = new int[matrix.length+1];
		bit = new int[matrix.length+1];
		for (int i = 0; i < matrix.length; i++) {
			//matrix是输入的数组从0开始，而我们转换的数组从1开始
			//得到的数组下标均+1处理
			update(i, matrix[i]);
		}
	}

	public void update(int i, int val){
		int diff = val - num[i+1];
		//j&-j的方式得到树状数组上变化的位置差值
		//从低到高
		for (int j = i+1; j < num.length; j+=j&(-j)) {
			bit[j] += diff;
		}
		num[i+1] = val;
	}

	public int sumRange(int i,int j){
		return getSum(j)-getSum(i);
	}

	public int getSum(int i){
		int mou = 0;
		//从高到低
		for (int j = i; j >0; j-=j&(-j)) {
			mou += bit[j];
		}
		return mou;
	}

	public static void main(String[] args) {
		int[] mr = {1,2,3,4,5,6,7};
		RangeSumQuery_mutable rsq = new RangeSumQuery_mutable(mr);
		int q =rsq.sumRange(1,7);
		System.out.println(q);
	}
}
