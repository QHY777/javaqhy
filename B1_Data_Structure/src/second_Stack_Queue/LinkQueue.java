package second_Stack_Queue;

import first_Sq_LinkList.Node;

public class LinkQueue implements IQueue{
	        private Node front;
	        private Node rear;
		    public LinkQueue() {
		    	front=rear=null;
		    }
			@Override
			public void clear() {
				front=rear=null;
				
			}
		
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
		
			@Override
			public int length() {
				// TODO Auto-generated method stub
				return 0;
			}
		
			@Override
			public Object peek() {
				// TODO Auto-generated method stub
				return null;
			}
		
			@Override
			//入队
			public void offer(Object x)  {
				Node p=new Node(x);
				if(front!=null) {
					rear.next=p;
					rear=p;
				}else {
					front =rear=p;
				}
				
			}
		
			@Override
			//出队
			public Object poll() {
				if(front!=null) {
					Node p=front;
					front=front.next;
					if(p==rear) {
						rear=null;
					}
					return p.data;
				}else {
				return null;
				}
			}
		          
		}
