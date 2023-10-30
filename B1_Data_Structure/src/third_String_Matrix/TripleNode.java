package third_String_Matrix;

public class TripleNode {    //三元组结点类

		public int  row;    //行
		public int column;    //列
		public int value;     //元素值
		//有参构造方法
		public TripleNode(int row,int column,int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
		//无参构造方法
		public TripleNode() {
			this(0,0,0);
		}


}
