package CourseGrading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Second_Goldbach {

	ArrayList<Integer> array0;
	int[] array;
	int sum;
	Second_Goldbach(int n){
		array0=new ArrayList<Integer>();
		sum=0;
		for(int i=2;i<=n;i++){
			boolean flag = true;
			for(int j = 2;j <= Math.sqrt(i);j++){
				if(i % j==0){
					flag = false;
					break;
					}
			}
			if(flag){
				this.array0.add(i);
			}
		}
		this.array=new int[array0.size()];
		for(int i=0;i<array0.size();i++) {
			array[i]=array0.get(i);
		}
	}
	
	public int goldbach(int n) {
		int max=0;
		for(int i=0;i<array.length;i++) {
			for(int j=i;j<array.length;j++) {
				if(array[i]+array[j]==n&&array[j]-array[i]>max)
					max=array[j]-array[i];
			}
		}
		this.sum+=1;
		if(max<4)
			return sum;
		return goldbach(max);
	}
	
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		sc.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line=br.readLine();
			int n = Integer.parseInt(line);
			Second_Goldbach g=new Second_Goldbach(n);
			g.goldbach(n);
			if(n==2)
				System.out.println(0);
			else
				System.out.println(g.sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
