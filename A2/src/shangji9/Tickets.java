package shangji9;

public class Tickets {
	 int  sum=30;
	 public synchronized int getsum() {// 
		 return sum;
	    }
	   public synchronized void  sellout(){// 
		sum--; 
	    }
	}
