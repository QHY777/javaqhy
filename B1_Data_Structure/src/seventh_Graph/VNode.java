package seventh_Graph;

public class VNode {
	public Object data;
	public ArcNode firstArc;
	public VNode() {
		this(null,null);
	}
	public VNode(Object data) {
		this(data,null);
	}
	public VNode(Object data,ArcNode firstArc) {
		this.data = data;
		this.firstArc = firstArc;
	}
}
