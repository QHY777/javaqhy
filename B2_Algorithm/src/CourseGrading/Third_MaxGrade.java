package CourseGrading;

import java.util.Scanner;
//错的
//见2
//CourseGrading.Third_MaxGrade
public class Third_MaxGrade {

	int maxGrade;
	int n;
	int[] date;
	int[] grade;
	int d;   //当前日期
	int dg;  //当前成绩
	int maxd;  //最大天数
	//结点可行性
	private boolean place(int k) {
		//System.out.println("天数："+d+"当前成绩"+dg);
		if(date[k]<d&&d>maxd)
			return false;
		return true;
	}
	private void backtrack(int t) {
		if(t==n) {
			//System.out.println("当前t:"+t+"当前分数"+dg+"当前天数"+d+"当前最大成绩"+maxGrade);	
			if(dg>maxGrade) {
				maxGrade=dg;
			}
		}else {			
			//System.out.println("当前t:"+t+"当前分数"+dg+"当前天数"+d+"当前最大成绩"+maxGrade+place(t));	
			if(place(t)) {
				//System.out.println("当前t:"+t+"当前分数"+dg+"当前天数"+d+"当前最大成绩"+maxGrade+place(t));	
				dg+=grade[t];
				d++;
				backtrack(t+1);
//			    dg-=grade[t];
//			    d--;
			}else if(!place(t)){
				//System.out.println("00000当前t:"+t+"当前分数"+dg+"当前天数"+d+"当前最大成绩"+maxGrade+place(t));	
				backtrack(t+1);
			}
		}
	}
	public Third_MaxGrade(int n,int[] grade,int[] date) {
		this.d=1;
		this.dg=0;
		this.maxGrade=0;
		this.n=n;
		this.date=date;
		this.grade=grade;
		for(int i=1;i<=n;i++) {
			if(date[i]>maxd)
				maxd=date[i];
		}
		//System.out.println("maxdate"+maxd);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] grade=new int[n+1];
		int[] date=new int[n+1];
		for(int i=1;i<=n;i++) {
			grade[i]=sc.nextInt();
			date[i]=sc.nextInt();
		}
		sc.close();
		Third_MaxGrade T=new Third_MaxGrade(n,grade,date);
		T.backtrack(1);
		System.out.println(T.maxGrade);
		
	}
}
