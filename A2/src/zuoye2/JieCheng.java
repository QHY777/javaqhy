package zuoye2;
import java.util.Scanner;//导入Scanner类
public class JieCheng {
	  static int jieCheng(int a){//简单的循环计算的阶乘
		 
	        if(a<0){//判断传入数是否为负数
         System.out.println("错误");

	        }
	        int c;
	        c=a;
	        for(int i=1;i<c;i++){//循环

	            a =a*i;//循环一次进行乘法运算

	        }

	        return a;//返回阶乘的值

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc=new Scanner(System.in);
		  System.out.println("请输入整数：");
		  int b=sc.nextInt();		  
		  System.out.println("阶乘为"+jieCheng(b));
          sc.close();
	}

}
