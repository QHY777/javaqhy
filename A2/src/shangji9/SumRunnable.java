package shangji9;

class Runnable1 implements Runnable{ 
	@Override
	public void run(){    
		int sum=0;
		for(int i=101;i<=300;i+=2){  
			sum+=i;
			       }
		System.out.println("奇数之和"+sum); 
		}
	}
class Runnable2 implements Runnable{  
	@Override
	public void run(){    
		int sum=0;
		for(int i=102;i<=300;i+=2){  
			sum+=i;
			       }
		System.out.println("偶数之和"+sum); 
		}
	}

public class SumRunnable {    
	public static void main(String[] args) {   
		Runnable1  r=new Runnable1();
		Thread t3 = new Thread(r); 
		Runnable2  m = new Runnable2();
		Thread t4 = new Thread(m);       
		 t3.start();        
		t4.start();    
		}
}
