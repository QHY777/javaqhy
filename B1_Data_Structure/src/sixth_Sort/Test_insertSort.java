package sixth_Sort;

/*编程序实现线性表基础上直接插入排序，并输出排序结果。
 数据可通过随机函数随机生成，也可通过键盘直接输入。*/
import java.util.Scanner;

public class Test_insertSort {
	
	    public static void main(String[] args) {
	    	Scanner input=new Scanner(System.in);
			System.out.println("请输入顺序表L空间大小：");
			int maxSize=input.nextInt();
			SeqList L=new SeqList(maxSize);   //建立输入空间大小的顺序表
			
	a:		while(true) {
				
				System.out.println("------------------");
				System.out.println("请输入指令： ");
				System.out.println("1，输入数据");
				System.out.println("2，排序");
				System.out.println("3，展示");
				System.out.println("4，退出");
				System.out.println("------------------");
				
				int i=input.nextInt();
				switch(i) {
				    
				case(1):
					System.out.println("输入数据数");
			        int int2=input.nextInt();
			        for(int n=0;n<int2;n++) {
				    	System.out.println("输入第"+n+"个结点关键字：");
					    Comparable key=input.next();
					    System.out.println("输入第"+n+"个结点数据：");
					    Object data=input.next();
					    RecordNode r=new RecordNode(key,data);
					    try {
							L.insert(n, r);
						} catch (Exception e) {
							e.printStackTrace();
						}
			        }
				    break;
				case(2):
					L.insertSort();
				    System.out.println("排序完毕");
				    break;
				case(3):
					System.out.println("展示如下：");
					L.display();
					break;
				case(4):
					input.close();
					break a;
				default:
	                System.out.println("输入有误！");
	                break;
				
				}
			}
		}

}
