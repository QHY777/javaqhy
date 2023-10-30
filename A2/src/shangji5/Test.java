package shangji5;

import java.util.Random;

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
     class Square implements Shape {
    	 double length;
      	  double width;
      	public   Square(double x,double y) {
      		   this.length=x;
      		   this.width=y; 		  
      	  }
      	   @Override
      	 public double getPerimeter() {
            return (this.length+this.width)*2;
        }
        @Override
        public double getArea() {
   		return this.length*this.width;
        }
        public String toString(){
        	return  "长方形的长和宽为："+this.length+","+this.width+" 周长为："+getPerimeter()+" 面积为："+getArea();
        }
      	 
     }
  public class Test {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Random random=new Random();
			int n=random.nextInt();
			System.out.println("随机数为："+n);
			if(n%2==0) {
				Shape circle=new Circle(4);
			     System.out.println(circle.toString());
			     //偶数  圆
			}else {
				Shape square=new Square(4,3);
			     System.out.println(square.toString());
			     //奇数  长方形
			}
     }

}
