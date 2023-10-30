package zuoye;

import java.util.HashSet;
import java.util.Set;

/* 
2、将1,2,3,4,5,6,7,8,9共9个数分成三组,分别组成三个三位数,
且使这三个三位数构成1:2:3的比例,
试求出所有满足条件的三个三位数，请设计算法并改进 
 */
public class Num_Nine {
	
	public static void main(String[] args) {
	
		
		/*
		int j,k,l;// 三个数
		for(int i1=1;i1<=9;i1++) {
			for(int i2=1;i2<=9&&i2!=i1;i2++) {
				for(int i3=1;i3<=9&&i3!=i1&&i3!=i2;i3++) {
					j=i1*100+i2*10+i3; //第一个三位数
					for(int i4=1;i4<=9&&i4!=i1&&i4!=i2&&i4!=i3;i4++) {
						for(int i5=1;i5<=9&&i5!=i1&&i5!=i2&&i5!=i3&&i5!=i4;i5++ ) {
							for(int i6=1;i6<=9&&i6!=i1&&i6!=i2&&i6!=i3&&i6!=i4&&i6!=i5;i6++) {
								k=i4*100+i5*10+i6;            //第二个三位数
								for(int i7=1;i7<=9&&i7!=i1&&i7!=i2&&i7!=i3&&i7!=i4&&i7!=i5&&i7!=i6;i7++) {
									for(int i8=1;i8<=9&&i8!=i1&&i8!=i2&&i8!=i3&&i8!=i4&&i8!=i5&&i8!=i6&&i8!=i7;i7++) {
										for(int i9=1;i9<=9&&i9!=i1&&i9!=i2&&i9!=i3&&i9!=i4&&i9!=i5&&i9!=i6&&i9!=i7&&i9!=i8;i9++) {
											l=i7*100+i8*10+i9;       //第三个三位数
											if((k==2*j)&&(k==3*j)) {
												System.out.println("三个数分别为："+j+","+k+","+l);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("结束");
		*/
		
		//前面算法时间复杂度太高，下面是改进后的
		for(int i=123;i<=987/3;i++) {
			Set<Integer> set = new HashSet<Integer>();       //hashSet不允许重复元素
			int j = 2*i;
			int k = 3*i;
			set.add(i%10);       //将三个数的组成数字添加进set
			set.add(i/10%10);
			set.add(i/100);
			set.add(j%10);
			set.add(j/10%10);
			set.add(j/100);
			set.add(k%10);
			set.add(k/10%10);
			set.add(k/100);
			if(set.size()==9) {        //九个数字不重复
				System.out.println("这三个数分别为："+i+","+j+","+k);
			}
		}

	}	
}
