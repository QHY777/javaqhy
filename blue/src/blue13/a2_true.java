package blue13;
public class a2_true {
	public static void main(String[] args) {
		int temp=0;
		int a,b,c,d,e=0;
		int num=0;
		for(int i=20;i<20000;i++) {
			a=i/10000;
			if(a>0) {
				temp=i%10000;
			}
			b=temp/1000;
			if(b>0) {
				temp=temp%1000;
			}
			c=temp/100;
			if(c>0) {
				temp=temp%100;
			}
			d=temp/10;
			if(d>0) {
				temp=temp%10;
			}
			e=temp;
			if(a<=b&&b<=c&&c<=d&&d<=e)
				num++;
		}
		System.out.println(num);
	}
}
