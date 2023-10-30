package fifth_Search;

import java.util.Scanner;

import sixth_Sort.RecordNode;
import sixth_Sort.SeqList;

public class Test_SeqList2 {

	public static void main(String[] args) {
    	Scanner input=new Scanner(System.in);
		System.out.println("请输入顺序表L空间大小：");
		int maxSize=input.nextInt();
		SeqList2 L=new SeqList2(maxSize);   //建立输入空间大小的顺序表

a:		while(true) {
			
			System.out.println("------------------");
			System.out.println("请输入指令： ");
			System.out.println("1，初始化数据");
			System.out.println("2，二分查找");
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
				System.out.println("输入查找关键字：");
			    Comparable key=input.next();
			    if(L.binarySearch(key)==-1) {
			    	System.out.println("查找失败");
			    }else {
			    	System.out.println("查找结果为:  "+L.binarySearch(key));
			    }
			    break;
			case(3):
				System.out.println("展示如下：");
				L.display();
				break;
			case(4):
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
