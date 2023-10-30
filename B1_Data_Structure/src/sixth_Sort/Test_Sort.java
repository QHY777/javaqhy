package sixth_Sort;

import java.util.Scanner;

public class Test_Sort {
	
	public static void main(String[] args) {
    	Scanner input=new Scanner(System.in);
		System.out.println("请输入顺序表L空间大小：");
		int maxSize=input.nextInt();
		SeqList L=new SeqList(maxSize);   //建立输入空间大小的顺序表
		
a:		while(true) {
			
			System.out.println("------------------");
			System.out.println("请输入指令： ");
			System.out.println("1，初始化数据");
			System.out.println("2，插入");
			System.out.println("3，直接插入排序");
			System.out.println("4，简单选择排序");
			System.out.println("5，冒泡排序");
			System.out.println("6，堆排序");
			System.out.println("7，快速排序");
			System.out.println("8，归并排序");
			System.out.println("9，希尔排序");
			System.out.println("10，展示");
			System.out.println("11，退出");
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
				System.out.println("输入插入位置：");
			    int int1=input.nextInt();
			    System.out.println("输入结点关键字：");
			    Comparable key=input.next();
			    System.out.println("输入结点数据：");
			    Object data=input.next();
			    RecordNode r=new RecordNode(key,data);
			    try {
					L.insert(int1, r);
				} catch (Exception e) {
					e.printStackTrace();
				}
			    break;
			case(3):
				L.insertSort();
			    System.out.println("直接插入排序完毕");
			    break;
			case(4):
				L.selectSort();
				System.out.println("简单选择排序完毕");
			    break;
			case(5):
				L.bubbleSort();
				System.out.println("冒泡排序完毕");
			    break;
			case(6):
				L.heapSort();
			    System.out.println("堆排序完毕");
			    break;
			case(7):
				L.quickSort();
			    System.out.println("快速排序完毕");
			    break;
			case(8):
				L.mergeSort();
			    System.out.println("归并排序完毕");
			    break;
			case(9):
				int[] d=new int[4];
			    System.out.print("输入4个增量（使用空格或回车分隔）：");
			    for(int m=0;m<d.length;m++) {
			    	d[m]=input.nextInt();
			    }
				L.shellSort(d);
				System.out.println("希尔排序完毕");
				break;
			case(10):
				System.out.println("展示如下：");
				L.display();
				break;
			case(11):
				System.out.println("成功退出");
			    input.close();
				break a;
			default:
                System.out.println("输入有误！");
                break;
			}
		}
	}

}
