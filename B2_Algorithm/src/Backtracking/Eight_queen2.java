package Backtracking;

public class Eight_queen2 {
	//蛮力法八皇后
	public static void main(String[] args) {
		
		int sum=0;
		for(int i1=1;i1<=8;i1++) {
			for(int i2=1;i2<=8&&i2!=i1;i2++) {
				for(int i3=1;i3<=8&&i3!=i1&&i3!=i2;i3++) {
					for(int i4=1;i4<=8&&i4!=i1&&i4!=i2&&i4!=i3;i4++) {
						for(int i5=1;i5<=8&&i5!=i1&&i5!=i2&&i5!=i3&&i5!=i4;i5++ ) {
							for(int i6=1;i6<=8&&i6!=i1&&i6!=i2&&i6!=i3&&i6!=i4&&i6!=i5;i6++) {
								for(int i7=1;i7<=8&&i7!=i1&&i7!=i2&&i7!=i3&&i7!=i4&&i7!=i5&&i7!=i6;i7++) {
									for(int i8=1;i8<=8&&i8!=i1&&i8!=i2&&i8!=i3&&i8!=i4&&i8!=i5&&i8!=i6&&i8!=i7;i7++) {
										sum+=1;     //记录种数
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
	}

}
