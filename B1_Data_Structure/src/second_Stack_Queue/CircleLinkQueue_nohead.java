package second_Stack_Queue;

import java.util.Scanner;

import first_Sq_LinkList.Node;

//假设以带头结点的循环链表表示队列，并且只设一个指针指向队尾元素结点
//（注意不设头指针）
//试编写相应的队列初始化、入队列和出队列的算法


class CircleLinkQueue_nohead {
	private Node head;
	private Node rear;
	int size;
	public CircleLinkQueue_nohead(){
		head=new Node();
		rear = null;
		size = 0;
	}
	
   //入队
	public void add(Node node){

		if(rear==null){
			node.next = node;
			head.next = node;
			rear=node;
			size++;
		}
		else{
			node.next = rear.next;
			rear.next = node;
			rear=node;
			size++;
		}
	}
	

	public void display(){
		Node p;
		if(head.next==null){
			System.out.println("空表");
		}else{
			rear.next = null;
			p=head.next;
			while(p.next!=null){
				System.out.print(p.data +"<--");
				p=p.next;
			}
			System.out.print(p.data);
			System.out.println();
		}
	}
    //队列置空
	public void Empty(){
		rear.next = null;
		head.next = null ;
	}
	
	// 出队
	
	public void pop(){

		if(head.next.next==head){//头结点后面只有一个结点
			head.next= null;
			rear=null;
		}else{
			Node temp=head.next.next;
			head.next = temp;
		}
	}
	public static void main(String[] args) {

		CircleLinkQueue_nohead link=new CircleLinkQueue_nohead();
		while(true){
			System.out.println("1.入队   2.出队  3.置队空  4  结束");
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			if(n==1){
				System.out.print("输入入队结点:");
				link.add( new Node(sc.nextInt()));
				link.display();
			}
			if(n==2){
				link.pop();
				link.display();
			}
			if(n==3){
				link.Empty();
				link.display();				
			}
			if(n==4) {
				break;
			}
		}
	}
}
