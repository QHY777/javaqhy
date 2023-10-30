package zuoye;
/*
 * 试编写一个算法，判断一给定的整型数组a[n]是不是一个堆（大根堆或小根堆)
 */
public class IsHeap {

	int[] r;
	public IsHeap(int [] r) {
		this.r=r;
	}
	//筛选法调整堆算法
    //将以low为根的子树调整成小顶堆，low、high是序列下界和上界
    public void sift_small(int low, int high) {
        int i = low;                                //子树的根
        int j = 2 * i + 1;                         //j为i结点的左孩子
        int temp = r[i];
        while (j < high) {  //沿较小值孩子结点向下筛选
            if (j < high - 1 && r[j]>r[j + 1]) {
                j++;           //数组元素比较,j为左右孩子的较小者
            }
            if (temp>r[j]) { //若父母结点值较大
                r[i] = r[j];           //孩子结点中的较小值上移
                i = j;
                j = 2 * i + 1;
            } else {
                j = high + 1;          //退出循环
            }
        }
        r[i] = temp;                   //当前子树的原根值调整后的位置
    }
    //筛选法调整堆算法
    //大顶堆
    public void sift_big(int low, int high) {
        int i = low;                                //子树的根
        int j = 2 * i + 1;                         //j为i结点的左孩子
        int temp = r[i];
        while (j < high) {  //沿较大值孩子结点向下筛选
            if (j < high - 1 && r[j]<r[j + 1]) {
                j++;           //数组元素比较,j为左右孩子的较大者
            }
            if (temp<r[j]) { //若父母结点值较小
                r[i] = r[j];           //孩子结点中的较大值上移
                i = j;
                j = 2 * i + 1;
            } else {
                j = high + 1;          //退出循环
            }
        }
        r[i] = temp;                   //当前子树的原根值调整后的位置
    }
    //判断是否为堆
    public void isOrNotHeap() {
    	int n=r.length;
    	int[] m=new int[n];   //复制r,存放于m
    	for(int i=0;i<r.length;i++) {
    		m[i]=r[i];
    	}
    	for(int i=n/2-1;i>=0;i--) {       //建立小顶堆
    		sift_small(i,n);
    	}
//    	for(int i=0;i<r.length;i++) {
//    		System.out.println(r[i]);
//    		System.out.println(m[i]);
//    	}
    	boolean flag=true;
    	for(int i=0;i<r.length;i++) {    //比较是否相同
    		if(m[i]!=r[i]) {
    			flag=false;
    			break;
    		}
    	}
//    	System.out.println(flag);
    	//输出结果
    	if(flag==true) {
    		System.out.print("是小顶堆");
    	}else if(flag==false){
    		System.out.print("不是小顶堆");
    	}
    	for(int i=0;i<r.length;i++) {   //将r复原
    		r[i]=m[i];
    	}
    	for(int i=n/2-1;i>=0;i--) {   //建立大顶堆
    		sift_big(i,n);
    	}
    	flag=true;
    	for(int i=0;i<r.length;i++) {
    		if(m[i]!=r[i]) {
    			flag=false;
    			break;
    		}
    	}
    	if(flag==true) {
    		System.out.println(" "+"是大顶堆");
    	}else if(flag==false){
    		System.out.println(" "+"不是大顶堆");
    	}
    }
    public static void main(String[] args) {
		
    	int[] a1= {13,25,18,33,58,95,46,63};   //小顶堆
    	int[] a2= {6,5,8};  //都不是
    	IsHeap s1=new IsHeap(a1);
    	s1.isOrNotHeap();
    	IsHeap s2=new IsHeap(a2);
    	s2.isOrNotHeap();
	}
}
