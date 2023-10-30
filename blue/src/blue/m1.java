package blue;

public class m1 {
	

	public static void main(String[] args) {
		int a =2020;
		int num = 0;
		for(int i=1;i<a;i++) {
			for(int o=2;o<=i;o++) {
				if(i%o!=0&&a%o!=0) {
					num+=1;
				}else {
					break;
				}
			}
		}
		System.out.println(num);
	}

}
