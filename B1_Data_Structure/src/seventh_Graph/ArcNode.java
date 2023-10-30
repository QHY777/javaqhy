package seventh_Graph;

public class ArcNode {
	public int adjVex;
	public int value;
	ArcNode nextArc;
	public ArcNode() {
		this(-1,0,null);
	}
	public ArcNode(int adjVex) {
		this(adjVex,0,null);
	}
	public ArcNode(int adjVex,int value) {
		this(adjVex,value,null);
	}
	public ArcNode(int adjVex,int value,ArcNode nextArc) {
		this.adjVex = adjVex;
		this.value = value;
		this.nextArc = nextArc;
	}
}
