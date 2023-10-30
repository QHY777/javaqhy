package shangji2;
import java.util.Scanner;
public class PanZhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入一个数组的长度：");
    int o= sc.nextInt();
    int[] a= new int[o];
    Scanner sca = new Scanner(System.in);
    System.out.print("请输入数组中的数,用空格隔开:");
    for(int i=0;i<o;i++) {
    	a[i]=sca.nextInt();
    }
    for( int i=0;i<a.length;i++) {
    	if (a[i]>0) {
    		System.out.print(a[i]+" ");
    	}else {
    		System.out.print(0+" ");
    	}
    }
    
    
    sc.close();
    sca.close();
	}

}
