package blue13;
import java.util.Scanner;

public class h {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String str=sc.next();
		char[] str_char=str.toCharArray();
		int[] num=new int[4];
		int length=str.length();
		for(int i=0;i<length;i++) {
			if(str_char[i]=='U')
				num[0]++;
			else if(str_char[i]=='D')
				num[1]++;
			else if(str_char[i]=='L')
				num[2]++;
			else if(str_char[i]=='R')
				num[3]++;
		}
		int updown=num[0]>num[1]?num[0]:num[1];
		if(updown==0)
			updown++;
		int leftright=num[2]>num[3]?num[2]:num[3];
		if(leftright==0)
			leftright++;
		int[][] result=new int[2*updown+5][2*leftright+5];
		int x=updown+2;
		int y=leftright+2;
		result[x][y]=1;
		for(int i=0;i<length;i++) {
			if(str_char[i]=='U') {
				x--;
				result[x][y]=1;
			}
			else if(str_char[i]=='D') {
				x++;
				result[x][y]=1;
			}
			else if(str_char[i]=='L'){
				y--;
				result[x][y]=1;
			}
			else if(str_char[i]=='R'){
				y++;
				result[x][y]=1;
			}
		}
		boolean flagUDLR=false;
		for(int i=1;i<2*updown+2;i++) {
			for(int j=1;j<2*leftright+2;j++) {
				if(result[i][j]==1)
					continue;
				flagUDLR=result[i-1][j]==1||result[i+1][j]==1
						||result[i][j-1]==1||result[i][j+1]==1;
				if(result[i][j]==0&&flagUDLR) {
					result[i][j]=2;
				}
			}
		}
		int flag=2;
		while(flag>0) {
			boolean flagUDLR2=false;
			for(int i=1;i<2*updown+2;i++) {
				for(int j=1;j<2*leftright+2;j++) {
					if(result[i][j]!=0)
						continue;
					flagUDLR2=result[i-1][j]==2&&result[i+1][j]==2
							&&result[i][j-1]==2&&result[i][j+1]==2;
					if(result[i][j]==0&&flagUDLR2) {
						result[i][j]=2;
					}
				}
			}
			flag--;
		}
		for(int i=0;i<2*updown+5;i++) {
			for(int j=0;j<2*leftright+5;j++) {
				if(result[i][j]==2)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
