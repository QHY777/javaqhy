package zuoye;

/*
作业3：
1、某地刑侦大队对涉及六个嫌疑人的一桩疑案进行分析：
A、B至少有一人作案；
A、E、F三人中至少有两人参与作案；
A、D不可能是同案犯；
B、C或同时作案，或与本案无关；
C、D中有且仅有一人作案；
如果D没有参与作案，则E也不可能参与作案。
试设计算法将作案人找出来，并进行分析和改进。
 */
public class Suspect {

	public static void main(String[] args) {
		
		int a,b,c,d,e,f;         //1代表犯罪   0无罪   
		for(a=0;a<2;a++) {       //6层循环遍历所有情况
			for(b=0;b<2;b++) {
				for(c=0;c<2;c++) {
					for(d=0;d<2;d++) {
						for(e=0;e<2;e++) {
							for(f=0;f<2;f++) {
								//6个条件
								if((a+b>=1)&&(a+e+f>=2)&&(a+d<=1)&&(b+c!=1)&&(c+d==1)&&(!(d==0&&e==1))){
									System.out.print("A"+(a==1?"犯罪":"无罪")); //输出结果
									System.out.print("  B"+(b==1?"犯罪":"无罪"));
									System.out.print("  C"+(c==1?"犯罪":"无罪"));
									System.out.print("  D"+(d==1?"犯罪":"无罪"));
									System.out.print("  E"+(e==1?"犯罪":"无罪"));
									System.out.print("  F"+(f==1?"犯罪":"无罪"));
								}
							}
						}
					}
				}
			}
		}
	}
}
