package shangjisan;
import java.util.Scanner;//导入Scanner类
public class AddChong {
  static String  Add() {
	   return "哦豁";
  }
  static  int  Add(int a) {
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
  static  int  Add(int a,int b) {
	  return a+b;
  }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc=new Scanner(System.in);
		  System.out.println("请输入整数：");
		  int b=sc.nextInt();
		  System.out.println("请输入整数：");
		  int a=sc.nextInt();
		  System.out.println("无参数结果:"+Add());
		  System.out.println("一个参数结果:"+Add(a));
		  System.out.println("2个参数结果:"+Add(a,b));
		  sc.close();
	}

}
