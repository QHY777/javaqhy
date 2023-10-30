package second_Stack_Queue;

public class CircleSqQueue implements IQueue{
            
			private Object[] queueElem;  //队列存储空间
			private int front;  //  队首的引用，指向队首元素
			private int rear;   //  队尾的引用，指向队尾下一位元素
			//循环队列构造函数
			public CircleSqQueue(int maxSize) {
				front=rear=0;
				queueElem=new Object[maxSize];
			}
			
			//队列置空
			public void clear() {
				front=rear=0;
			}
		
			//判断队列是否为空
			public boolean isEmpty() {
				return front==rear;
			}
		
			//求长
			public int length() {
				return (rear -front+queueElem.length)%queueElem.length;
			}
		
			//读取队首元素
			public Object peek() {
				if(front==rear) {   //队列空
					return null;
				}else {
					return queueElem[front];
				}
			}
		
			//入队
			public void offer(Object x) throws Exception {
				if((rear+1)%queueElem.length==front) { //队列满
					throw new Exception("队列已满");
				}else {
					queueElem[rear]=x;
					rear=(rear+1)%queueElem.length;
				}
				
			}
		
			//出队
			public Object poll() {
				if(front==rear) {    //队列为空
					return null;
				}else {
					Object t=queueElem[front];
					front=(front+1)%queueElem.length;
					return t;     //返回队首元素
				}
			}
			public void display() {
				if(!isEmpty()) {
					for(int i=front;i!=rear;i=(i+1)%queueElem.length) {
						System.out.print(queueElem[i].toString()+" ");
					}
				}else {
					System.out.println("此队列为空");
				}
			}
			   

}
