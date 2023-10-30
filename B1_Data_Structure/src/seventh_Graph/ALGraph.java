package seventh_Graph;

import java.util.Scanner;

public class ALGraph implements IGraph{
	private GraphKind kind;
	private int vexNum,arcNum;
	private VNode[] vexs;
	public ALGraph() {
		this(null,0,0,null);
	}
	public ALGraph(GraphKind kind,int vexNum,int arcNum,VNode[] vexs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}
	//创建图
	public void creatGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入图的类型：");
		GraphKind kind = GraphKind.valueOf(sc.next());
		switch(kind) {
		case DG:	//有向图
			creatDG();
			return;
		case UDG:	//无向图
			creatUDG();
			return;
		case DN:	//右向网
			creatDN();
			return;
		case UDN:	//无向网
			creatUDN();
			return;
		}
	}
	//创建无向网
	public void creatUDN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数：");
		System.out.println("图的顶点数为：");
		vexNum = sc.nextInt();
		System.out.println("图的边数为：");
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点：");
		for(int v = 0;v < vexNum; v++) {
			System.out.println("第" + (v + 1) + "个顶点为：");
			vexs[v] = new VNode(sc.next());
			}
		System.out.println("请输入各边的顶点及其权值：");
		for(int k = 0;k < arcNum;k++) {
			System.out.println("第" + (k + 1) +"条边的两个顶点分别为：");
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			System.out.println("该边的权值为：");
			int value = sc.nextInt();
			addArc(v,u,value);
			addArc(u,v,value);
		}
	}
	//创建有向网
	public void creatDN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数：");
		System.out.println("图的顶点数为：");
		vexNum = sc.nextInt();
		System.out.println("图的边数为：");
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点：");
		for(int v = 0;v < vexNum; v++) {
			System.out.println("第" + (v + 1) + "个顶点为：");
			vexs[v] = new VNode(sc.next());
			}
		System.out.println("请输入各边的顶点及其权值：");
		for(int k = 0;k < arcNum;k++) {
			System.out.println("第" + (k + 1) +"条边的两个顶点分别为：");
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			System.out.println("该边的权值为：");
			int value = sc.nextInt();
			addArc(v,u,value);
			}	
		}
	//创建无向图
	public void creatUDG() {
		
	}
	//创建有向图
	public void creatDG() {
			
		}
	@Override
	public int getVexNum() {
		// TODO Auto-generated method stub
		return vexNum;
	}
	@Override
	public int getArcNum() {
		// TODO Auto-generated method stub
		return arcNum;
	}
	@Override
	public Object getVex(int v) throws Exception{
		// TODO Auto-generated method stub
		if(v < 0 && v > vexNum)
			throw new Exception("第" + v + "个结点不存在"); 
		return vexs[v].data;
	}
	//给定结点的值vex，返回其在图中的位置，若图中不包含此顶点，则返回-1
	public int locateVex(Object vex) {
		// TODO Auto-generated method stub
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].data.equals(vex))
				return v;
		return -1;
	}
	//返回v表示结点的值
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		VNode vex = vexs[v];
		if (vex.firstArc != null)
			return vex.firstArc.adjVex;
		else
			return -1;
	}
	//查找下一个邻接点的算法
	public int nextAdjVex(int v,int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		VNode vex = vexs[v];

		ArcNode arcvw = null;
		for (ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc)
			if (arc.adjVex == w) {
				arcvw = arc;
				break;
			}
		if (arcvw != null && arcvw.nextArc != null)
			return arcvw.nextArc.adjVex;
		else
			return -1;
	}
	//在图中插入边(或弧)结点
	public void addArc(int v,int u,int value) {
		ArcNode arc = new ArcNode(u,value);
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}
}
