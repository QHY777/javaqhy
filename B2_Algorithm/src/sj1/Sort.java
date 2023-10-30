package sj1;

public class Sort {
	
	int[] S;   //存放数据的数组
	
	public Sort() {    //无参构造方法
		
	}
	//直接选择排序
    public void selectSort() {
        int temp; //辅助
        //n-1趟排序
        //每趟在从S[i]开始的子序列中寻找最小元素
        for (int i = 0; i < S.length - 1; i++) {
            int min = i;               //设第i条记录最小
          //在子序列中选择最小的记录
            for (int j = i + 1; j <S.length; j++) {
                if (S[j]<S[min]) {
                    min = j;             //记住最小记录的下标
                }
            }
            if (min != i) {    //将本趟最小的记录与第i条记录交换
                temp = S[i];
                S[i] = S[min];
                S[min] = temp;
            }
        }
    }
    
  //筛选法调整堆算法
    //将以low为根的子树调整成小顶堆，low、high是序列下界和上界
    public void sift(int low, int high) {
        int i = low;                                //子树的根
        int j = 2 * i + 1;                         //j为i结点的左孩子
        int temp = S[i];
        while (j < high) {  //沿较小值孩子结点向下筛选
            if (j < high - 1 && S[j]>S[j + 1] ) {
                j++;           //数组元素比较,j为左右孩子的较小者
            }
            if (temp>S[j]) { //若父母结点值较大
                S[i] = S[j];           //孩子结点中的较小值上移
                i = j;
                j = 2 * i + 1;
            } else {
                j = high + 1;          //退出循环
            }
        }
        S[i] = temp;                   //当前子树的原根值调整后的位置
    }
    
    //堆排序
    public void heapSort() {
        int n = S.length;
        int temp;
        for (int i = n / 2 - 1; i >= 0; i--) {//创建堆
            sift(i, n);
        }
      //每趟将最小值交换到后面，再调整成堆
        for (int i = n - 1; i > 0; i--) {
            temp = S[0];
            S[0] = S[i];
            S[i] = temp;
            sift(0, i);
        }
    }

}
