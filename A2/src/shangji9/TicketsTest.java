package shangji9;

public class TicketsTest  {
	static Tickets tickets = new Tickets();		
	public static void main(String[] args){
		Thread t1 = new TicketsThread(tickets, "A站点");
	    Thread t2 = new TicketsThread(tickets, "B站点");
	    t1.start();
		t2.start();
			}
}
