package first_Sq_LinkList;

public class SqList_inverse {
        public static void inverse(Object[] list) {
        	Object tmp;
        	for(int i=0,j=list.length-1;i<j;i++,j--) {
        		tmp=list[i];
        		list[i]=list[j];
        		list[j]=tmp;
        	}
        }
        public static void main(String[] args) {
			SqList L=new SqList(5);
			try {
			L.insert(0, "qhy");
			L.insert(1, "地区");
			L.insert(2,"好的");
			L.insert(3, "nnn");
			L.insert(4, 123);
			System.out.println("逆置前:");
			L.display();
		    System.out.println();
			System.out.println("逆置后:");
			inverse(L.List);
			L.display();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
