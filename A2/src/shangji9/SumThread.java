package shangji9;


class Thread1 extends Thread{   
	public void run(){    
		int sum=0;
		for(int i=101;i<=300;i+=2){  
			sum+=i;
			       }
		System.out.println("奇数之和"+sum); 
		}
	}
class Thread2 extends Thread{   
	public void run(){    
		int sum=0;
		for(int i=102;i<=300;i+=2){  
			sum+=i;
			       }
		System.out.println("偶数之和"+sum); 
		}
	}

public class SumThread {    
	public static void main(String[] args) {       
		Thread1 t1 = new Thread1();       
		Thread2 t2 = new Thread2();       
		t1.start();        
		t2.start();    
		}
}
