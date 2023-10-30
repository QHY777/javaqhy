package CourseGrading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second_Goldbach2 {

	int sum;
	Second_Goldbach2(){
		this.sum=0;
	}
	public boolean place(int n) {
		boolean flag = true;
		if(n<2) 
			return false;
		else {
			for(int i=2;i<=Math.sqrt(n);i++) {
				if(n % i == 0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	public int Goldbach2(int n) {
		int max=0;
		for(int i=2;i<=n/2;i++) {
			if(place(i)&&place(n-i)) {
				max=n-2*i;
				 break;
			}
		}
		sum+=1;
		if(max<4)
			return sum;
		return Goldbach2(max);
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line=br.readLine();
			int n = Integer.parseInt(line);
			Second_Goldbach2 g=new Second_Goldbach2();
			if(n==2)
				System.out.println(0);
			else
				System.out.println(g.Goldbach2(n));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
