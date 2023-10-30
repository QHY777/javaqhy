package shangji9;

public class TicketsThread extends Thread{
	  Tickets tickets = new Tickets();
	    int n = 0 ;
		public TicketsThread(Tickets tickets,String name){
		super(name);
		this.tickets = tickets;
	   }
		public void run(){
			 while(tickets.getsum()>0){
			if(tickets.getsum()>0){
				tickets.sellout();
		        System.out.println(Thread.currentThread().getName() +"售出车票一张，剩余车票："+tickets.sum+"张");	
			}
		}
		}
}

