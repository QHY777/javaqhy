package sj4;

import java.util.LinkedList;
import java.util.Scanner;
 

public class WireRouter {
	public int[][] grid;//方格阵列;=0表示该方格运行布线；=1表示被封锁，不允许布线
	public int size;//方格阵列大小
	public int pathLen;//最短线路长度
	public LinkedList<Position> q;//扩展结点队列，用list存储
	public Position start;//起始位置
	public Position finish;//终点
	public Position[] path;//最短路径
	public WireRouter(int[][] grid,int size,Position start,Position finish){
		this.grid=grid;
		this.size=size;
		this.start=start;
		this.finish=finish;
	}
    //方格所在位置
	public static class Position{
		public int row;//行
		public int col;//列
		
		public Position(int r ,int c){
			row=r;
			col=c;
		}
	}
	//计算从起始位置start到目标位置finish的最短布线路径
	//return 找到最短布线路径则返回true，否则返回false
	 
	public boolean findPath(){
		if(start.row==finish.row&&start.col==finish.col){//start==finish,最短路径为0
			pathLen=0;
			return true;
		}
		
		//初始化相对位移
		Position[] offset=new Position[4];
		offset[0]=new Position(0,1);//右
		offset[1]=new Position(1,0);//下
		offset[2]=new Position(0,-1);//左
		offset[3]=new Position(-1,0);//上
		
		//设置方格阵列“围墙”，方便处理方格边界的情况
		for(int i=0;i<=size+1;i++){
			grid[0][i]=grid[size+1][i]=1;//顶部和底部
			grid[i][0]=grid[i][size+1]=1;//左边和右边
		}
		
		Position here=new Position(start.row,start.col);
		grid[start.row][start.col]=2;//数字0,1表示方格的开放或封锁所以，表示距离时，让所有距离都加2；起始位置的距离为0+2=2
		int numOfNbrs=4;//相邻方格数
		
		//以下为标记可达的方格位置
		q=new LinkedList<Position>();
		Position nbr=new Position(0,0);
		do{
			//标记可达的相邻方格(每个方格有四个相邻方格)
			for(int i=0;i<numOfNbrs;i++){
				nbr.row=here.row+offset[i].row;
				nbr.col=here.col+offset[i].col;
				if(grid[nbr.row][nbr.col]==0){//该方格未被标记，且该方格允许布线
					grid[nbr.row][nbr.col]=grid[here.row][here.col]+1;
					if(nbr.row==finish.row&&nbr.col==finish.col)
						break;
					q.add(new Position(nbr.row,nbr.col));
				}
			}
			
			//检测是否到达目标位置finish
			if(nbr.row==finish.row&&nbr.col==finish.col)
				break;
			if(q.isEmpty())
				return false;
			
			here=q.poll();
		}while(true);
		
		//构造最短布线路径
		pathLen=grid[finish.row][finish.col]-2;
		path=new Position[pathLen];
		
		//从目标位置finish开始向起始位置回溯
		here=finish;
		for(int j=pathLen-1;j>=0;j--){
			path[j]=here;
			//找前驱位置
			for(int i=0;i<numOfNbrs;i++){
				nbr.row=here.row+offset[i].row;
				nbr.col=here.col+offset[i].col;
				if(grid[nbr.row][nbr.col]==j+2)
					break;
			}
			here=new Position(nbr.row,nbr.col);
		}
		System.out.println("最短路线为：");
		for(int j=0;j<pathLen-1;j++){
			System.out.println("点"+(j+1)+"位置:  行-"+path[j].row+" 列-"+path[j].col);
		}
		System.out.println("布线长度为："+pathLen);
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入方格阵列大小：");
		String s1=sc.nextLine();
		Integer size=Integer.parseInt(s1);
		
		System.out.println("请输入起始点的行和列，用空格隔开：");
		String s2=sc.nextLine();
		String[] s3=s2.split(" ");
		int startRow=Integer.parseInt(s3[0]);
		int startCol=Integer.parseInt(s3[1]);
		Position start=new Position(startRow,startCol);
		
		System.out.println("请输入结束点的行和列，用空格隔开：");
		String s4=sc.nextLine();
		String[] s5=s4.split(" ");
		int finishRow=Integer.parseInt(s5[0]);
		int finishCol=Integer.parseInt(s5[1]);
		Position finish=new Position(finishRow,finishCol);
		
		int[][] grid=new int[size+2][size+2];
		System.out.println("请输入方格阵列：");
		for(int i=1;i<=size;i++){
			String str=sc.nextLine();
			String[] strs=str.split(" ");
			for(int j=0;j<strs.length;j++){
				grid[i][j+1]=Integer.parseInt(strs[j]);
			}
		}
		
		WireRouter w=new WireRouter(grid,size,start,finish);
		w.findPath();		
	}
}
/*
输入：
7
请输入起始点的行和列，用空格隔开：
2 3
请输入结束点的行和列，用空格隔开：
4 6
请输入方格阵列：
0 0 1 0 0 0 0
0 0 1 1 0 0 0
0 0 0 0 1 0 0
0 0 0 1 1 0 0
1 0 0 0 1 0 0
1 1 1 0 0 0 0
1 1 1 0 0 0 0
输出：
最短路线为：
点1位置:  行-3 列-3
点2位置:  行-4 列-3
点3位置:  行-5 列-3
点4位置:  行-5 列-4
点5位置:  行-6 列-4
点6位置:  行-6 列-5
点7位置:  行-6 列-6
点8位置:  行-5 列-6
布线长度为：9
 */