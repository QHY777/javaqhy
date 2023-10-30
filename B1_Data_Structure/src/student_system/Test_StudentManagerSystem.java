package student_system;

import java.util.Scanner;

public class Test_StudentManagerSystem {
	
	// 主函数，用于功能调试
		public static void main(String[] args) throws Exception {
			
			Scanner sc = new Scanner(System.in);
	        Object L=null;
	   a:     while(true) {
	        	
	        	System.out.println("请输入指令：");
		        System.out.println("---------菜单----------");
		        System.out.println("1，建立顺序表并输入信息");
		        System.out.println("2，按学号查询学生信息");
		        System.out.println("3，按学号删除学生信息");
		        System.out.println("4，在最后添加学生信息");
		        System.out.println("5，按学号修改学生信息");
		        System.out.println("6，求全班各门课平均分");
		        System.out.println("7，展示");
		        System.out.println("8，退出");
		        System.out.println("-----------------------");
		        int n=sc.nextInt();
		        switch(n) {
		        
		        case(1):
			        System.out.println("设定最大存储空间容量:");
			        int maxSize =sc.nextInt();
			        System.out.println("请输入学生的总数： ");
					int n1 = sc.nextInt();
					System.out.println("请按学号、姓名、性别、大学英语和高等数学的顺序输入学生信息： ");
					L = new StudentManagerSystem(maxSize, n1);// 新建顺序表
					((StudentManagerSystem)L).display();
					break;
					
		        case(2):
		        	System.out.println("请输入需要查询学生的学号： ");
				    ((StudentManagerSystem)L).displayNode(((StudentManagerSystem)L).get(sc.nextInt())); // 取出成功，则输出该学生的信息
		            break;
		            
		        case(3):
		        	System.out.println("请输入需要删除学生的学号： "); // 输出
					((StudentManagerSystem)L).remove(sc.nextInt());// 删除指定学号的项
					System.out.println("删除成功！");
					((StudentManagerSystem)L).display();
					break;
					
		        case(4):
		        	System.out.println("请输入需要增加的学生信息:"); // 输出
					((StudentManagerSystem)L).insert(new StudentNode(sc)); // 在顺序表插入指定的项
					((StudentManagerSystem)L).display(); // 输出
					break;
					
		        case(5):
		        	System.out.println("输入修改信息学生的学号：");
				    int num=sc.nextInt();
				    System.out.println("输入修改后的学号、姓名、性别、英语成绩、高数成绩：");
				    int num2=sc.nextInt();
				    String name=sc.next();
				    String sex=sc.next();
				    double eng=sc.nextInt();
				    double math=sc.nextInt();
					((StudentManagerSystem)L).revise(num,num2,name,sex,eng,math);
					((StudentManagerSystem)L).display();
					break;
			       
		        case(6):
		        	((StudentManagerSystem)L).average();
		            break;
		            
		        case(7):
		        	System.out.println("展示:");
		        	((StudentManagerSystem)L).display();
			        break; 
			        
		        case(8):
		        	System.out.println("成功退出");
		        	break a;
			        	    
		        }
		      
				
				

	        }
	        
	        
		}

}
