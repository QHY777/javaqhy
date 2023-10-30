package sj2;

import java.util.Scanner;


//鍥剧殑閭绘帴鐭╅樀绫荤殑鎻忚堪
public class MGraph {

	private int vexNum,arcNum; //鍥剧殑褰撳墠椤剁偣鏁板拰杈规暟
	private Object[] vexs; //椤剁偣
	private int[][] arcs;    //閭绘帴鐭╅樀
	public MGraph() {
		this(0,0,null,null);
	}
	public MGraph(int vexNum,int arcNum,Object[] vexs,int[][] arcs) {
		this.arcNum=arcNum;
		this.vexNum=vexNum;
		this.vexs=vexs;
		this.arcs=arcs;
	}
	//杩斿洖椤剁偣鏁�
	public int getVexNum() {
		return this.vexNum;
	}
	//杩斿洖杈规暟
	public int getArcNum() {
		return this.arcNum;
	}
	//鏃犲悜鍥�
	public void creatUDG() {
		Scanner sc = new Scanner(System.in);
		System.out.println("璇疯緭鍏ュ浘鐨勯《鐐规暟銆佽竟鏁帮細");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("璇峰垎鍒緭鍏ュ浘鐨勫悇涓《鐐癸細");
		//鏋勯�犻《鐐瑰悜閲�
		for (int v = 0; v < vexNum; v++)
			vexs[v] = sc.next();
		arcs = new int[vexNum][vexNum];
		//鍒濆鍖栭偦鎺ョ煩闃�
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = 0;
		System.out.println("璇疯緭鍏ュ悇涓竟鐨勪袱涓《鐐癸細");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = arcs[u][v] = 1;
		}
	}
	//椤剁偣瀹氫綅
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}
}
