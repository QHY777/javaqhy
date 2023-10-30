package sixth_Sort;

public class RecordNode {
	      
	       @SuppressWarnings("rawtypes")
		public Comparable key; //关键字
	       public Object element; //数据元素
	    
	       @SuppressWarnings("rawtypes")
		public RecordNode(Comparable key) {   //构造方法
	    	   this.key=key;
	       }
	       @SuppressWarnings("rawtypes")
		public RecordNode(Comparable key,Object element) {   //构造方法
	    	   this.key=key;
	    	   this.element=element;
	       }
              
}
