package blue;

public class m2 {
	
	
	
	public int A(int n) {
		if(n==1) {
			return 1160;
		}else {
			return 2021%A(n-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p=2021;
		int v=1160;
		m2 a=new m2();
		for(int i=0;i<100;i++) {
			if(a.A(i)==1) {
				System.out.println(i);
			}
		}


	}

}
