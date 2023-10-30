package second_Stack_Queue;

public class SqStack implements IStack{
		            
			private Object[] stackElem;
			private int top;  //top指向栈顶元素的下一个
			
			//构造函数
			public SqStack(int maxSize) {
				top=0;   //初始化top
				stackElem =new Object[maxSize];   //栈分配有maxSize个存储单元
		
			}
			//栈置空
			public void clear() {
				top=0;
			}
			//判断是否为空
			public boolean isEmpty() {
				return top==0;
			}
			//求栈中元素个数
			public int length() {
				  return top;
			  }
			//取栈顶元素
			public Object peek() {
				if(!isEmpty()) {
					return stackElem[top-1];
				}else {
					return null;
				}
			}
			//入栈
			public void push(Object x) throws Exception {
				if(top==stackElem.length) {       //栈满了
					throw new Exception("栈已满");
				}else {
					stackElem[top++]=x; //先将新元素压入栈顶，再将top加上一
				}
			}
			//出栈
			public Object pop() {
				if(isEmpty()) {
					return null;
				}else {
					return stackElem[--top];
				}
			}
			public void display() {
				for(int i=top-1;i>=0;i--) {
					System.out.print(stackElem[i].toString()+" ");
				}
			}
			 
}
