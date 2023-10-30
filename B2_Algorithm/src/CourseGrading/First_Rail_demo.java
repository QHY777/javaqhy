package CourseGrading;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class First_Rail_demo {

	static int jieCheng(int a){
        int c;
        c=a;
        for(int i=1;i<c;i++){
            a =a+i;
        }
        return a;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] wide=new int[n];
		for(int i=0;i<n;i++) {
			wide[i]=sc.nextInt();
		}
		sc.close();
		Arrays.sort(wide);
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(0);
		for(int i=0;i<n;i++) {
			int sum=0;
		a:	for(int k=0;k<array.size();k++) {
				sum=0;
				for(int j=k;j<array.size();j++) {
					if(sum<wide[i]) {
						sum+=array.get(j);
					}
					if(sum==wide[i]) {
						break a;
					}
				}
			}
			if(sum!=wide[i]) {
				array.add(wide[i]);
			}
		}
		int result1=array.size();
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<wide.length;i++) {
			for(int j=i+1;j<wide.length;j++) {
				set.add(wide[j]-wide[i]);
			}
		}
		int m=jieCheng(n-1);
		System.out.println("m:"+m);
		System.out.println("set.size"+set.size());
		for (int str : set) {  
		      System.out.println(str);  
		} 
		System.out.println("wide.length"+wide.length);
		int result2=wide.length+1-(m-set.size())/2;
		System.out.println(result1<result2? result1:result2);
	}

}
