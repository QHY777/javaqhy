package shangjisan;
import java.util.*;
public class FindLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] jk = new int[10];
      Scanner sc = new Scanner(System.in);
      System.out.println("请输入数x：");
      int x=sc.nextInt();
      for(int i=0;i<10;i++) {
    	  if(jk[i]==x) {
    		  System.out.println("下标为："+i);
    		  continue;
    	  }else if(i==9) {
    		  System.out.println("无此元素");
    		  sc.close();}
      }
	}

}
