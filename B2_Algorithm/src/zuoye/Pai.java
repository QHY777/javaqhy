package zuoye;
/*
 * 根据ppt的示例，设计一个使用蒙特卡洛方法计算圆周率的程序，
 * 并测试随机次数与圆周率的准确性的关系，给出测试结果，
 * 当重复次数n为10、100、1000、10000、100000等不同数量级时，
 * 算法总共耗时、圆周率结果分别是多少，并给出你的结论，
 * 欲得出小数点后10位精确度的圆周率，需要多少级别的n？20位呢？
 */
import java.util.Random;
import java.util.Scanner;


public class Pai {

	public static void caculatePI(int countInSquarel) {
		int countInCircle = 0, i, resulttimes;
		double x, y; /* 坐标 */
		Random s = new Random();
		for (resulttimes = 0; resulttimes < 10; resulttimes++) { /* 输出十次结果 */
			for (i = 1; i <= countInSquarel; i++) {
				x = s.nextDouble(); /* 在0~1之间产生一个随机x坐标 */
				y = s.nextDouble(); /* 在0~1之间产生一个随机y坐标 */
				if (caculateAcreage(x,y)<= 1.0)
				countInCircle++; /* 统计落入单位圆中的点数 */
		    }
			System.out.println("结果为：" + (double) countInCircle / countInSquarel* 4); /* 计算出π的值 */
			countInCircle = 0;
	}
	}
	
	private static double caculateAcreage(double xPosition,double yPosition){
		return xPosition*xPosition+yPosition*yPosition;
	}
	
	public static void main(String[] args) {
		System.out.println("请输入次数: ");
		Scanner sc=new Scanner(System.in);
		caculatePI(sc.nextInt());
	}
	
	
	
}