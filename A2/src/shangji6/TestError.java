package shangji6;


import java.util.Scanner;

interface Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
   }//接口
     class Circle implements Shape{
    	 double radius;
    	 public Circle(double r) {
    		 this.radius=r;
    	 }
    	 @Override
    	   public double getPerimeter() {
    	   	return 2*Math.PI*radius;
    	   }
    	   @Override
    	   public double getArea() {
    	   	return Math.PI*Math.pow(this.radius, 2);
    	   }
    	   public   String toString() {
    		 return  "圆的半径为："+radius+" 周长为："+getPerimeter()+" 面积为："+getArea();
    	   }
     }
public class TestError {
     static void scV(double r) throws Exception{
    	
         if(r<0) {
        	 throw new Exception();
         }
         Shape circle=new Circle(r);
         System.out.println(circle.toString());
    	}
     public static void main(String[] args) {
    	 Scanner sc =new Scanner(System.in);
         System.out.println("请输入半径：");
         float r=sc.nextFloat();
         sc.close();
         try {
        	 scV(r);
         }catch(Exception e) {
        	 System.out.println("圆的半径不能为负数");
        	 }finally{
        		 System.out.println();
        	 }
	}
     }
	
    


