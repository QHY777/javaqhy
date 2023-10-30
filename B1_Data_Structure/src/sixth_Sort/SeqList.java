package sixth_Sort;

public class SeqList {
	  
	   public RecordNode[]r;    //记录结点数组
	   public int curlen; //记录长度，即数据个数
	   
	   //构造一个空间为maxSize顺序表
	   public SeqList(int maxSize) {
		   this.r=new RecordNode[maxSize];
		   this.curlen=0;
	   }
	   
	   //在当前顺序表第i个结点前插入一个RecordNode类型的结点x
	   public void insert(int i,RecordNode x)throws Exception{
		   if(curlen==r.length) {
			   throw new Exception("顺序表已满");
		   }
		   if(i<0||i>curlen) {
			   throw new Exception("插入位置不合法");
		   }
		   for(int j=curlen;j>i;j--) {
			   r[j]=r[j-1];           //插入位置及之后的数据元素后移
		   }
		   r[i]=x;
		   this.curlen++;
	   }
	   //希尔排序
	   public void shellSort(int[] d) { //d[]为增量数组
	        RecordNode temp;
	        int i, j;
	        //控制增量，增量减半，若干趟扫描
	        for (int k = 0; k < d.length; k++) {
	            //一趟中若干子表，每个记录在自己所属子表内进行直接插入排序
	            int dk = d[k];
	            for (i = dk; i < this.curlen; i++) {
	                temp = r[i];
	                for (j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j -= dk) {
	                    r[j + dk] = r[j];
	                }
	                r[j + dk] = temp;
	            }
	        }
	    }
       //冒泡排序
       @SuppressWarnings("unchecked")
		public void bubbleSort() {
	    	   RecordNode temp; //辅助结点
	    	   boolean flag=true;     //是否交换的标记
	    	   for(int i=1;i<this.curlen&&flag;i++) {
	    		   flag=false;   //记录未交换
	    	       for(int j=0;j<this.curlen-1;j++) {
	    	    	   if(r[j].key.compareTo(r[j+1].key)>0) {  //逆序交z换
	    	    		   temp=r[j];
	    	    		   r[j]=r[j+1];
	    	    		   r[j+1]=temp;
	    	    		   flag=true;
	    	    	   }
	    	       }
	    	   }
         }
       //一趟快速排序
       //交换排序表[i,j]的位置，使支点记录到位，并返回其所在位置
       public int Partition(int i,int j) {
    	   RecordNode pivot=r[i];     //第一个记录作为支点记录
           while (i < j) {    //从表的两端交替地向中间扫描
	            while (i < j && pivot.key.compareTo(r[j].key) <= 0) {
	                j--;      //j.key>支点，j前移
	            }
	            if (i < j) {
	                r[i] = r[j];   //将比支点记录关键字小的记录向前移动
	                i++;
	            }
	            while (i < j && pivot.key.compareTo(r[i].key) > 0) {
	                i++;     //i.key<支点，i后移
	            }
	            if (i < j) {
	                r[j] = r[i];   //将比支点记录关键字大的记录向后移动
	                j--;
	            }
           }
	       r[i] = pivot;         //支点记录到位
	       return i;             //返回支点位置
       }

       //递归形式的快速排序算法
       //对子表r[low..high]快速排序
       public void qSort(int low, int high) {
           if (low < high) {
               int pivotloc = Partition(low, high);  //一趟排序，将排序表分为两部分
               qSort(low, pivotloc - 1);   //低子表递归排序
               qSort(pivotloc + 1, high);  //高子表递归排序
           }
       }
       
       //顺序表快速排序算法
       public void quickSort() {
           qSort(0, this.curlen - 1);
       }
       
       //不带监视哨的直接插入排序算法
       public void insertSort() {
           RecordNode temp;
           int i, j;
           for (i = 1; i < this.curlen; i++) {//n-1趟扫描
               temp = r[i];  //将待插入的第i条记录暂存在temp中
               for (j = i - 1; j >= 0 && temp.key.compareTo(r[j].key) < 0; j--) { //将前面比r[i]大的记录向后移动
                   r[j + 1] = r[j];
               }
               r[j + 1] = temp;          //r[i]插入到第j+1个位置

           }
       }
       
       //带监视哨的直接插入排序算法
       public void insertSortWithGuard() {
           int i, j;
           for (i = 2; i <this.curlen; i++) {      //n-1趟扫描
               r[0] = r[i];      //将待插入的第i条记录暂存在r[0]中，同时r[0]为监视哨
             //将前面较大元素向后移动
               for (j = i - 1; r[0].key.compareTo(r[j].key) < 0; j--) { 
                   r[j + 1] = r[j];
               }
               r[j + 1] = r[0];          // r[i]插入到第j+1个位置
           }
       }
       
       //直接选择排序
       public void selectSort() {
           RecordNode temp; //辅助结点
           //n-1趟排序
           //每趟在从r[i]开始的子序列中寻找最小元素
           for (int i = 0; i < this.curlen - 1; i++) {
               int min = i;               //设第i条记录的关键字最小
             //在子序列中选择关键字最小的记录
               for (int j = i + 1; j < this.curlen; j++) {
                   if (r[j].key.compareTo(r[min].key) < 0) {
                       min = j;             //记住关键字最小记录的下标
                   }
               }
               if (min != i) {    //将本趟关键字最小的记录与第i条记录交换
                   temp = r[i];
                   r[i] = r[min];
                   r[min] = temp;
               }
           }
       }
       
       //筛选法调整堆算法
       //将以low为根的子树调整成小顶堆，low、high是序列下界和上界
       public void sift(int low, int high) {
           int i = low;                                //子树的根
           int j = 2 * i + 1;                         //j为i结点的左孩子
           RecordNode temp = r[i];
           while (j < high) {  //沿较小值孩子结点向下筛选
               if (j < high - 1 && r[j].key.compareTo(r[j + 1].key) > 0) {
                   j++;           //数组元素比较,j为左右孩子的较小者
               }
               if (temp.key.compareTo(r[j].key) > 0) { //若父母结点值较大
                   r[i] = r[j];           //孩子结点中的较小值上移
                   i = j;
                   j = 2 * i + 1;
               } else {
                   j = high + 1;          //退出循环
               }
           }
           r[i] = temp;                   //当前子树的原根值调整后的位置
       }
       
       //堆排序
       public void heapSort() {
           int n = this.curlen;
           RecordNode temp;
           for (int i = n / 2 - 1; i >= 0; i--) {//创建堆
               sift(i, n);
           }
         //每趟将最小值交换到后面，再调整成堆
           for (int i = n - 1; i > 0; i--) {
               temp = r[0];
               r[0] = r[i];
               r[i] = temp;
               sift(0, i);
           }
       }
       //两个有序序列的归并算法
       //把r数组中的两个相邻的有序表r[a]-r[b]和r[b+1]-r[c]归并为一个有序表order【h]-order[t]
       public void merge(RecordNode[]r,RecordNode[]order,int a,int b,int c) {
    	   int i=a,j=b+1,k=a;
    	   while(i<=b&&j<=c) {
    		   if(r[i].key.compareTo(r[j].key)<=0) {  //较小值复制到order中
    			   order[k++]=r[i++];
    		   }else {
    			   order[k++]=r[j++];
    		   }
    	   }
    	   while(i<=b) {      //将前一个子序列剩余元素复制到order中
    		   order[k++]=r[i++];
    	   }
     	   while(j<=c) {          //将后一个子序列剩余元素复制
    		   order[k++]=r[j++];
    	   }
       }
       
       //一趟归并排序算法
       //r为待排数组，s为待归并有序子序列长度，n为待排序列长度
       public void mergepass(RecordNode[]r,RecordNode[]order,int s,int n) {   
    	   int p=0;         //p为一对待合并表的第1个元素下标，初值为0
    	   while(p+2*s-1<=n-1) { //两两归并长度为s的有序表
    		   merge(r,order,p,p+s-1,p+2*s-1);
    		   p+=2*s;
    	   }
    	   if(p+s-1<n-1) {    //归并最后两个长度不等的有序表
    		   merge(r,order,p,p+s-1,n-1);
    	   }else {
    		   for(int i=p;i<=n-1;i++) { //将剩余有序表复制到order中
    			   order[i]=r[i];
    		   }
    	   }
       }
       //二路归并排序
       public void mergeSort() {
    	   int s=1;   //s待排子序列长度，初值1
    	   int n=this.curlen;
    	   RecordNode[] temp=new RecordNode[n]; //长度n辅助数组temp
    	   while(s<n) {
    		   mergepass(r,temp,s,n);  //r中子序列归并到temp
    		   s*=2;
    		   mergepass(temp,r,s,n);   //temp中子序列归并到r
    		   s*=2;
    	   }
       }

       
       
       public void display() {    //输出数组元素
           for (int i = 0; i < this.curlen; i++) {
               System.out.println("key:" + r[i].key.toString()+"  element:" + r[i].element.toString());
           }
       }
}
