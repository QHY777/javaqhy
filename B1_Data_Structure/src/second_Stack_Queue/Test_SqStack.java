package second_Stack_Queue;

public class Test_SqStack {
      
	public static void main(String[] args) {
		try {
			SqStack s=new SqStack(10);
			s.push("戚宏宇");
			s.push("青花鱼");
			s.push("失误");
			s.push("hi");
			System.out.print("栈顶元素:");
			System.out.println(s.peek());
			s.isEmpty();
			s.display();
			System.out.println("长度为"+s.length());
			s.pop();  //出栈
			System.out.println();
			System.out.print("栈顶元素:");
			System.out.println(s.peek());
			s.display();
			System.out.println("长度为"+s.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
