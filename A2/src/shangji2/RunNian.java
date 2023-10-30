package shangji2;
import java.util.Scanner;

public class RunNian {
	private static boolean runNian(int n) {
		if(n%4== 0&& n%100!=0||n%400==0) {
			return true;
			
		}else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc =new Scanner(System.in);
        System.out.println("输入年份：");
        System.out.println(runNian(sc.nextInt()));
        sc.close();
	}

}
