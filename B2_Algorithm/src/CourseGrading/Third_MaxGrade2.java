package CourseGrading;

import java.util.Scanner;

//从后往前
public class Third_MaxGrade2 {

	int maxGrade;
	int n;
	int[] date;
	int[] grade;
	int maxd;  //最大天数
	int[] flag;   //0代表未选取
	
	public void operation() {
		for(int i=maxd;i>0;i--) {
			int max=0;
			int temp=0;  //标记最后选取位置
			for(int j=1;j<=n;j++) {
				if(date[j]>=i&&max<grade[j]&&flag[j]==0) {
					max=grade[j];
					temp=j;
				}
			}
			flag[temp]=1;  //标记
			maxGrade+=max;
		}
	}

	//构造方法初始化各成员变量
	public Third_MaxGrade2(int n,int[] grade,int[] date) {
		this.flag=new int[n+1];
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
		Third_MaxGrade2 T=new Third_MaxGrade2(n,grade,date);
		T.operation();
		System.out.println(T.maxGrade);
	}
}
