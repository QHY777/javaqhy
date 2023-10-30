package first_Sq_LinkList;

public interface Ilist {
      public void clear();
      public boolean isEmpty();
      public int getLength();
      public Object get(int i) throws Exception ;
      public int getIndex(Object o);
      public void insert(int i,Object p) throws Exception;
      public void remove(int i) throws Exception;
      public void display();
      
}
