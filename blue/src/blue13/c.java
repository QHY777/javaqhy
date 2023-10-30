package blue13;
import java.util.Scanner;

public class c {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		sc.close();
		char[] array=input.toCharArray();
		int[] flag=new int[26];
		int length=array.length;
		int temp=0;
		for(int i=0;i<length;i++) {
			temp=array[i]-'A';
			flag[temp]++;
		}
		int max=0;
		for(int i=0;i<26;i++) {
			if(flag[i]>max)
				max=flag[i];
		}
		char[] zimu=new char[] {'A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N',
				'O','P','Q','R','S','T',
				'U','V','W','X','Y','Z'};
		StringBuilder str=new StringBuilder();
		for(int i=0;i<26;i++) {
			if(flag[i]==max) {
				str.append(zimu[i]);
			}
		}
		System.out.println(str.toString());
	}
}
