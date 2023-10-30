package dp;

import java.util.Scanner;

/*
 * 算法实现题3-1 独立任务最优调度问题★问题描述
用两台处理机A和B处理n个作业。设第i个作业交给机器A处理时需要时间a;,
若由机器B来处理,则需要时间b。由于各作业的特点和机器的性能关系,
很可能对于某些i有a≥b,而对于某些j,j≠i,有a,<b,。
既不能将一个作业分开由两台机器处理,也没有一台机器能同时处理两个作业。
设计一个动态规划算法，使得这两台机器外理完这n个作业的时间最短(从任何一台机器开工到最后一台机器停工的总时间)。
研究一个实例:(aj,a2,a3,a4 ,as ,ag)=(2,5,7,10,5,2);(b1 ,b2 ,bs ,bs ,bs,bs)=(3,8,4,11,3,4)。
 */
public class IndependentTask {
//	int n;   //任务数
//	int []  a=new int [n+1];    //a工作时间
//	int []  b=new int [n+1];      //b工作时间
//	/*
//	 * 建立状态T[i][k],整数类型，表示前k个任务中，在A机器上用时小于等于i时，
//	 * 在B机器上的最小用时。T[i][k]=min{ T[i-A[k]][k-1], T[i][k-1]+B[k]};
//	 * 表示若将第k个任务分给A处理，B最少用时为T[i-A[k]][k-1]；
//	 * 若将第k个任务分给B处理则，B最少用时为T[i][k-1]+B[k]。
//	 */
//	int[][] T =new int[Integer.MAX_VALUE][n];
//	int i=0;
//	public void arrange(int k) {
//		T[i][k]= T[i-a[k]][k-1]> T[i][k-1]+b[k]? T[i-a[k]][k-1]:T[i][k-1]+b[k];
//	}
	
	private static int n;
    private static int[] a;
    private static int[] b;
    private static int aSum = 0;
    private static int bSum = 0;
    private static boolean[][][] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入作业个数n：");
        n = sc.nextInt();
        a = new int[n+1];
        b = new int[n+1];
        System.out.println("请输入处理机A完成各作业的时间：");
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
            aSum += a[i];
        }
        System.out.println("请输入处理机B完成各作业的时间：");
        for(int i = 1; i <= n; i++){
            b[i] = sc.nextInt();
            bSum += b[i];
        }

        //设布尔量 (i,j,k)表示前k个作业可以在处理机A用时不超过i且处理机B用时不超过j时间内完成。
        //用动态规划算法计算p(i,j,k)= p(i-a[k]，k-1)|| i，j一b[k]，k-1)。
        p = new boolean[aSum+1][bSum+1][n+1];

        for(int i = 0; i <= aSum; i++){
            for(int j = 0; j <= bSum; j++){
                p[i][j][0] = true;   //k=0,全为true
            }
        }
        //三维矩阵p中
        for(int k = 1; k <= n; k++){
            for(int i = 0; i <= aSum; i++){
                for(int j = 0; j <= bSum; j++){
                    if(i >= a[k]){
                        p[i][j][k] = p[i-a[k]][j][k-1];
                    }
                    if(j >= b[k]){
                        p[i][j][k] = p[i][j][k]||p[i][j-b[k]][k-1];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= aSum; i++){
            for(int j = 0; j <= bSum; j++){
                if(p[i][j][n]){
                    if(Math.max(i,j) < min){
                        min = Math.max(i, j);       //最短时间
                    }
                }
            }
        }
        sc.close();
        System.out.println("最短处理时间为：" + min);
    }

}
