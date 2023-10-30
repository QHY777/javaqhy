package sj1;

import java.util.Scanner;

public class Test_PostOffice {
	
	public static void main(String[] args) {
		
		PostOffice p=new PostOffice();
		Scanner sc=new Scanner(System.in);
		System.out.println("输入居民数：");
		p.n=sc.nextInt();
		p.x=new double[p.n];
		p.y=new double[p.n];
        //添加坐标
		for(int i=0;i<p.n;i++) {
			System.out.println("输入第"+(i+1)+"个居民x坐标");
			p.x[i]=sc.nextDouble();
			System.out.println("输入第"+(i+1)+"个居民y坐标");
			p.y[i]=sc.nextDouble();
		}
		p.post();//获取位置
		System.out.println("邮局x坐标:"+p.postX);
		System.out.println("邮局y坐标:"+p.postY);
		sc.close();
		
	}
}
