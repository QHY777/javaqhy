package first_Sq_LinkList;

public class RemoveRepeat {

         public static void removeRepeat(LinkList L) {
        	 Node p=L.head;   //p初始为头结点

        	 while(p.next!=null) {
        		p=p.next;
        		Object n=p.data;//被比较值n
        		Node q=p;   //比较的结点
        		while(q.next!=null) {
        		   
        		    if(q.next.data.equals(n)) {
        			    q.next=q.next.next;    //删除重复的
	        		}else {
	        			q=q.next;      //后移一个进行比较
	        		}
	        	  }
	        	 }
	         }
         
         
         //主方法测试
         public static void main(String[] args) {
     		try {
    			LinkList L = new LinkList(10,false);
    			System.out.println("处理前：");
    			L.display();
    			System.out.println();
    			System.out.println("处理后:");
    			removeRepeat(L);
    			L.display();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
        	 
        	 
		}
	
}
