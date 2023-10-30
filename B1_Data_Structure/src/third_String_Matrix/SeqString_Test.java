package third_String_Matrix;

import java.util.Scanner;

public class SeqString_Test {
			
		public static void menu() {
			System.out.println("---------菜单---------");
			System.out.println("1.清空clear()");
			System.out.println("2.判断是否为空isEmpty()");
			System.out.println("3.串长length()");
			System.out.println("4.返回序号为i的元素charAt(i)");
			System.out.println("5.扩充字符串allocate(int newSpace)");
			System.out.println("6.返回子串substring(int begin,int end)");
			System.out.println("7.插入一个字符串insert(int offset,String str)");
			System.out.println("8.删除一串字符delete(int begin,int end)");
			System.out.println("9.添加字符到串尾concat()");
			System.out.println("10.当前串与目标串进行比较compareTo()");
			System.out.println("11.从start处开始匹配字符串tindex_BF(String t,int start)");
			System.out.println("12.展示");
			System.out.println("13.退出");
			System.out.println("--------------------------");
			System.out.println("请选择你想要进行的操作:");
		}
		public static void main(String[] args) throws Exception {
			System.out.println("请输入一个字符串构成当前串:");
			Scanner input = new Scanner(System.in);
			String SeqStr = input.next();
			SeqString L = new SeqString(SeqStr);
			
			
	a:		while(true) {
		
				menu();
				int num = input.nextInt();
				
				switch(num) {
				case 1:
					L.clear();
					break;
					
				case 2:
					System.out.print("是否为空：");
					System.out.println(L.isEmpty());
					break;
					
				case 3:
					System.out.println("长度为：");
					System.out.println(L.length());
					break;
					
				case 4:
					System.out.println("请输入位序号i:");
					int i = input.nextInt();
					System.out.println("序号为i的元素:");
					System.out.println(L.charAt(i));
					break;
					
				case 5:
					System.out.println("请输入扩充后的空间大小:");
					int a  = input.nextInt();
					L.allocate(a);
					System.out.println("扩充完毕");
					break;
					
				case 6:
					System.out.print("请输入你要返回的字符串的起始序位:");
					int s = input.nextInt();
					System.out.print("请输入你要返回的字符串的终止序位:");
					int d = input.nextInt();
					System.out.print("返回的子串为：");
					System.out.println(L.substring(s,d));
					break;
					
				case 7:
					System.out.println("请输入你要插入的元素在哪个位序号之前:");
					int qw = input.nextInt();
					System.out.println("请输入你要插入的元素:");
					String s1 = input.next();
					SeqString N = new SeqString(s1);
					L.insert(qw,N);
					break;
					
				case 8:
					System.out.print("请输入你要删除的字符串的起始序位:");
					int f = input.nextInt();
					System.out.print("请输入你要删除的字符串的终止序位:");
					int g = input.nextInt();
					System.out.println(L.delete(f,g));
					break;
					
				case 9:
					System.out.print("请输入你想要拼接的字符串:");
					String s2 = input.next();
					SeqString N2 = new SeqString(s2);
					L.concat(N2);
					System.out.println("拼接后的字符串为：" + L);
					break;
					
				case 10:
					System.out.print("输入你想要比较的字符串:");
					String str1 = input.next();
					SeqString SeqStr1 = new SeqString(str1);
					L.compareTo(SeqStr1);
					break;
					
				case 11:
					System.out.println("请输入你要定位的子串:");
					String str2 = input.next();
					SeqString SeqStr2 = new SeqString(str2);
					System.out.println("请输入你想要定位的起始位置:");
					int start = input.nextInt();
					System.out.print("定位起始位置为：");
					System.out.println(L.indexOf_BF(SeqStr2,start));
					break;
					
				case 12:
					L.display();
					break;
					
				case 13:
					System.out.println("您已退出系统!");
					input.close();
					break a;
					
				default:
					System.out.println("你输入的编号有误，请重新输入:");
					break;
			}
		}
	}
}


