package shangjisi;

public class TestExtends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Round round =new Round("这是一个半径为4的圆",4);
	        System.out.println("圆的周长是" + round.getCircumference());
	        System.out.println("圆的面积是" + round.getArea());

	        //创建一个长为4，宽为5的矩形
	        Rectangular rectangular =new Rectangular("这是一个一个长为4，宽为5的矩形",4,5);
	        System.out.println("矩形的周长是" + rectangular.getCircumference());
	        System.out.println("矩形的面积是" + rectangular.getArea());

	        //创建一个边长为3,4,5的三角形
	        Triangle triangle = new Triangle("这是一个一个边长为3,4,5的三角形",3,4,5);
	        System.out.println("三角形的周长是" +triangle.getCircumference());
	        System.out.println("三角形的面积是" + triangle.getArea());

	}

}
