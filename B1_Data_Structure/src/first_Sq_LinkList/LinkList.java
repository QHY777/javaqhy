package first_Sq_LinkList;

import java.util.Scanner;

public class LinkList implements Ilist{

	public Node head; //头指针
	
	public LinkList() {
		   head=new Node();
	}
	public LinkList(int n,boolean Order) throws Exception {
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
			insert(0,sc.next());
		}
		sc.close();
	}
	//尾插法
	public void createLast(int n) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入尾插法插入的"+n+"个元素");
		for(int j=0;j<n;j++) {
		    insert(getLength(),sc.next());
		}
		sc.close();
	}

           public void clear() {          //清空
	             head.data=null;
	             head.next=null;
             }
			public boolean isEmpty() {   //判断是否为空
				return head.next==null;
				
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
			public Object get(int i) throws Exception{//按序号查找
				Node p=head.next;
				int j=0;
				while(p!=null&&j<i) {
					p=p.next;
					++j;
				}
				if(j>i||p==null) {
					throw new Exception("第"+i+"元素不存在");
				}
				return p.data;
			}
			public int getIndex(Object o) {           //按照值寻找位置
				Node p=head.next;
				int j=0;
				while(p!=null&&!p.data.equals(o)) {
					p=p.next;        //下一个结点
					j++;
				}
				if(p!=null) {
					return j;
				}else {
					return -1;
				}
			}
			public void insert(int i,Object x) throws Exception{       //插入
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
			
			public void display() {
				Node o=head.next;
				for(int i=0;i<getLength();i++) {
					System.out.print(o.data+" ");
					o=o.next;
				}
			}

}
