package shangjisi;

public class SuShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("素数：");
		for(int i=2;i<50;i++) {
			boolean f=true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
				f=false;
				break;
				}
			}
			if(f==false) {
				continue;
			}
			
			System.out.print(" "+i);
		}
       }
	}

