package sj1;

public class PostOffice {

	int n;  //居民数
	double[] x;  //x坐标
	double[] y;  //y坐标
	double postX;
	double postY;
	
	@SuppressWarnings("unused")
	public void post() {	  //邮局坐标
		
		selectSort(this.x);   
		selectSort(this.y);
		//取中位数
		if(n%2==0) {       //偶数个
			postX= 0.5*(x[n/2-1]+x[n/2]);
			postY= 0.5*(y[n/2-1]+y[n/2]);
		}else {                 //奇数个
			postX= x[(n+1)/2-1];
			postY= y[(n+1)/2-1];
		}
	}
	//直接选择排序
    public void selectSort(double[] S) {
        double temp; //辅助
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
}
