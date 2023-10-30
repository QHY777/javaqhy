package CourseGrading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Third_CorrectQuestions {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line=br.readLine();
			int k = Integer.parseInt(line);  ///小明答对题目
			String line1=br.readLine();  //我的答案
			String line2=br.readLine();  //小明答案
//			System.out.println(n+"  "+line1+"  "+line2);
			int n=line1.length();
			int yes=0;  //答案一样个数
			int no=0;  //不一样个数
			for(int i=0;i<n;i++) {
				if(line1.charAt(i)==line2.charAt(i))
					yes++;
			}
			no=n-yes;
			if(k<=yes)
				System.out.println(no+k);
			else
				System.out.println(yes+no-(k-yes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
