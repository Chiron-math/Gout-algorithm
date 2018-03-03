package arrayList.medium;

import java.util.Arrays;

/**
 * 三种方法：
 * 1.循环两次。思路简单：复杂度：第一次得到0和1个数；第二次将他们从左到右排列；
 * 2.循环一次。/注意交换后的值核实是否有再次交换的价值/将0放在左边，将2放在右边。
 */
public class SortColor {
    private int[] arrays;

    /*方法二：1.*/
    public void sortColor(int[] array){
        int num = array.length;
        int i = 0, k=0,l=num-1;
        while(i<l){
            if (array[i]==0){
                if (i==k) {
                    i++;
                    continue;
                }else {
                    array[i] = array[k]  ;
                    array[k++] = 0;
                }
            }

            if(array[i]==2) {
                if (i==num){
                    i++;
                    continue;
                }else {
                    array[i] = array[l];
                    array[l--] = 2;
                }
            }

            if (array[i]!=1){
                    continue;
            }
            i++;
        }
         this.arrays = array;
    }

    /*方法二：2.*/
    public void sortColor02(int[] arrays){
        int num = arrays.length;
        int i,k,l;
        i=k=l=0;
        while (i<num-l-1){
            if (arrays[i]==0){
                arrays[i]=arrays[k];
                arrays[k]=0;
                k++;
            }else if (arrays[i]==2){
                arrays[i] = arrays[num-l-1];
                arrays[num-1-l] = 2;
                l++;
                i--;//对后面交换过来的元素进行判断
            }

            i++;
        }
        this.arrays = arrays;

    }

    @Override
    public String toString() {
        return "SortColor{" +
                "arrays=" + Arrays.toString(arrays) +
                '}';
    }

    public static void main(String[] args) {
        SortColor sortColor = new SortColor();
        // a[] 结尾是0的时候不对,要改,改好，结果13行的位置增加一个自增防止0出现在第一个而i没自增出现自循环，结尾没有减少自增个数破坏了自增的次数，漏掉了几个
        // 上面修改是将自增添加到14行里
        int[] a = {2,2,1,1,1,0,0,2,1,0,2,1,2,1,2,2,0,0,0,0,1,2,2,1,1,0,1,0,2,1,2,1,2,1,2,1,0,0,0,0,0,0,1,0};
        /*sortColor.sortColor(a);*/
        sortColor.sortColor02(a);
        System.out.println( sortColor.toString());
    }

}
