package blue13;
import java.util.Scanner;

public class test_c {

	public static void main(String[] args) {
		/*
		 * char a='A'; System.out.println(a-'B');
		 */
		/*
		 * Scanner sc=new Scanner(System.in); int n=sc.nextInt(); String
		 * last=sc.nextLine(); System.out.println(last); String[] ai=last.split(" ");
		 * int length=ai.length; int[] a1=new int[length]; // for(int i=0;i<length;i++)
		 * { // a1[i]=Integer.parseInt(ai[i]); // System.out.println(a1[i]); // }
		 */		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a0=new int[n];
		int[] result=new int[n];
		for(int i=0;i<n;i++) {
			a0[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			System.out.print(a0[i]+" ");
		}
		
	}
}
