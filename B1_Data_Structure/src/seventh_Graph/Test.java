package seventh_Graph;

import java.util.Scanner;


public class Test {
	public static void main(String[] args) throws Exception {
		ALGraph L = new ALGraph();
		L.creatGraph();
		System.out.println("邻接表创建成功");
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("\n请输入指令：");
			System.out.println("--------菜单--------");
			System.out.println("1,广度优先遍历");
			System.out.println("2,深度优先遍历");
			System.out.println("3,退出");
			int num = input.nextInt();
			switch(num) {
			case 1:
				System.out.print("\n该图的广度优先遍历结果为：");
				BTraverser B = new BTraverser();
				B.BFSTraverse(L);
				break;
			case 2:
				System.out.print("\n该图的深度优先遍历结果为：");
				DTraverser D = new DTraverser();
				D.DFSTraverse(L);
				break;
			case 3:
				flag = false;
				System.out.println("\n退出!");
				input.close();
				break;
			}
		}
		
		
	}
}


    



