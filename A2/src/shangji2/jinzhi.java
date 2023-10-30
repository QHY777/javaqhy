package shangji2;
import java.util.*;
public class jinzhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner(System.in);
       System.out.println("请输入十进制的数：");
       int n = 0;
       n=sc.nextInt();
       String a = "";
		while(n!=0) {
			a=n%2+a;
			n=n/2;
		}
		System.out.println(a);
       sc.close();
	}

}
