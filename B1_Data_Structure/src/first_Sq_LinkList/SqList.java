package first_Sq_LinkList;

public class SqList implements Ilist{
       Object[] List;
       private int curLen;   //当前长度
       public SqList(int space) {     //建立一定长度的表
    	   curLen=0;
    	   List=new Object[space];
       }
       public void clear() {         //清空
    	   curLen=0;
       }
       public int getLength() {         //获取表长
    	   return curLen;
       }
       public boolean isEmpty() {     //判断是否为空
    	   return curLen==0;
       }
       
       public Object get(int i) throws Exception{    //获取相应位置元素
    	   if(i<0||i>curLen-1) {
    		   throw new Exception("该元素不存在");
    	   }
    	   return List[i];
       }
       public void insert(int i,Object p) throws Exception{    //插入
    	   if(curLen==List.length) {
    		   throw new Exception("表已经满了");
    	   }
    	   if(i<0||i>curLen) {
    		   throw new Exception("插入位置不合法");
    	   }
    	   for(int j=curLen;j>i;j--) {
    		   List[j]=List[j-1];
    	   }
    	   List[i]=p;
    	   curLen++;
    	
       }
       public void remove(int i) throws Exception {  //删除
    	   if(i<0||i>curLen) {
    		   throw new Exception("位置不合法");
    	   }
    	   for(int j=i;j<List.length-1;j++) {
    		   List[j]=List[j+1];
    	   }
    	   curLen--;
       }
       public int getIndex(Object o) {
    	   int j=-1;
    	   for(int i=0;i<curLen;i++) {
    		   if(List[i]==o) {
    			   j=i;
    			   break;
    		   }
    	   }
		    return j;
       }
       public void display() {
    	   for(int i=0;i<List.length;i++) {
    	   System.out.print(List[i]+" ");
           }	   
       }   
}
