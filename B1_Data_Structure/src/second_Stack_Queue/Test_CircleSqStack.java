package second_Stack_Queue;

public class Test_CircleSqStack {
	
     public static void main(String[] args) {
    	 CircleSqQueue c=new CircleSqQueue(10);
    	 try {
			c.offer("戚宏宇");
			c.offer("qhy");
			c.offer("青花鱼");
			System.out.print("队列为：");
			c.display();
			System.out.println();
			System.out.print("队列长度:"+c.length()+" ");
			System.out.println("队首元素:"+c.peek()+" ");
			System.out.println("出队元素:"+c.poll()+" ");
			System.out.print("队列为：");
			c.display();
			System.out.println();
			System.out.println("队列长度:"+c.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
	}
}
