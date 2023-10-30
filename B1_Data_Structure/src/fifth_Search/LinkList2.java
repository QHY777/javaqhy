package fifth_Search;


import java.util.Scanner;
import first_Sq_LinkList.Node;
import sixth_Sort.RecordNode;


public class LinkList2 {
     
		    public Node head; //头指针
			
			public LinkList2() {
				   head=new Node();
			}
			public LinkList2(int n,boolean Order) throws Exception {
				head=new Node();
				if(Order) {
					createHead(n);
				}else {
					createLast(n);
				}
				
			}
			//头插法
			public void createHead(int n) throws Exception {
				Scanner sc=new Scanner(System.in);
				System.out.println("输入头插法插入的"+n+"个元素");
				for(int j=0;j<n;j++) {
					System.out.println("输入结点关键字：");
				    Comparable key=sc.next();
				    System.out.println("输入结点数据：");
				    Object data=sc.next();
				    RecordNode r=new RecordNode(key,data);
					insert(0,r);
				}
				sc.close();
			}
			//尾插法
			public void createLast(int n) throws Exception {
				Scanner sc=new Scanner(System.in);
				System.out.println("输入尾插法插入的"+n+"个元素");
				for(int j=0;j<n;j++) {
					System.out.println("输入结点关键字：");
				    Comparable key=sc.next();
				    System.out.println("输入结点数据：");
				    Object data=sc.next();
				    RecordNode r=new RecordNode(key,data);
					insert(0,r);
				}
				sc.close();
			}
			public int getLength() {
				Node p=head.next;
				int length=0;
				while(p!=null) {
					p=p.next;
					length++;
				}
				return length;
			}
			
			public void insert(int i,RecordNode x) throws Exception{       //插入
				Node p=head;
				int j=-1;
				while(p!=null&&j<i-1) {
					p=p.next;
					++j;
				}
				if(j>i-1||p==null) {                    //异常处理
					throw new Exception("插入位置不合法");
				}
				Node s=new Node(x);
				s.next=p.next;
				p.next=s;
			}
			public void remove(int i) throws Exception{
				Node p=head;
				int j=-1;
				while(p.next!=null&&j<i-1) {     //找到第i个结点的前驱
					p=p.next;
					++j;
				}
				if(j>i-1||p.next==null) {
					throw new Exception("删除位置不合法");	
				}
				p.next=p.next.next;
			}
			//顺序查找
				public int seqSearch(Comparable key) {
					int i=0;
					int n=getLength();
					Node p=head.next;
					while(i<n&&((RecordNode)p.data).key.compareTo(key)!=0) {
						p=p.next;
						i++;
					}
					if(i<n) {
						return i;  //查找成功，返回元素下标，否则返回-1
					}else {
						return -1;
					}
				}
				
				
				public RecordNode get(int i) throws Exception{//按序号查找
					Node p=head.next;
					int j=0;
					while(p!=null&&j<i) {
						p=p.next;
						++j;
					}
					if(j>i||p==null) {
						throw new Exception("第"+i+"元素不存在");
					}
					return ((RecordNode)p.data);
				}
				
			
		
			
			public void display() {
				Node o=head.next;
				for(int i=0;i<getLength();i++) {
					System.out.println("key:"+((RecordNode)o.data).key.toString()+"    element:"+((RecordNode)o.data).element.toString());
							o=o.next;
						}
					}

}


