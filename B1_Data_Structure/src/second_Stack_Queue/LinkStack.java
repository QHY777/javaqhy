package second_Stack_Queue;

import first_Sq_LinkList.Node;

public class LinkStack implements IStack{
    private Node top;
    
	//将栈置空
	public void clear() {
		top=null;
	}

	//判断链栈是否为空
	public boolean isEmpty() {
		return top==null;
	}

	//求链栈长度
	public int length() {
		Node p=top;
		int length=0;
		while(p!=null) {
			p=p.next;
			++length;
		}
		return length;
		
	}

	//取栈顶元素并返回其值
	public Object peek() {
		if(!isEmpty()) {
			return top.data;
		}else {
			return null;
		}
	}

	//入栈
	public void push(Object x) {
		Node p=new Node(x);
		p.next=top;
		top=p;
	}

	//出栈
	public Object pop() {
		if(isEmpty()) {
			return null;
		}else {
			Node p=top;
			top=top.next;
			return p.data;
		}
	}
	public void display() {
		Node p=top;
		while(p!=null) {
			System.out.print(p.data.toString()+" ");
			p=p.next;
		}
	}

}
