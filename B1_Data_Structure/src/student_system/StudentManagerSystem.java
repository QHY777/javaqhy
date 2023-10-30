package student_system;

import java.util.Scanner;
import  first_Sq_LinkList.SqList;

public class StudentManagerSystem extends SqList {


	// 按顺序构造顺序表，其中参数maxSize指的是顺序表的最大存储空间容量
	public StudentManagerSystem(int maxSize, int n) throws Exception {
		super(maxSize);
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= n; i++) {// 创建n个顺序表结点
			StudentNode node = new StudentNode(sc); // 创建顺序表中的结点
			insert(node); // 插入到顺序表的表尾
		}
	}



	// 覆盖父类的get方法，从顺序表中取出指定学号的学生信息，并返回一个StudentNode对象
	public StudentNode get(int number) throws Exception {
		for (int i = 0; i < getLength(); i++) { // 遍历整个顺序表
			StudentNode node = (StudentNode) super.get(i);// 调用父类的get方法
			if (node.number == number)
				return node;// 包含指定的学号，返回该学生的信息
		}
		throw new Exception("学号" + number + "不存在");// 拋出异常
	}

	// 重载了父类insert方法在顺序表的表尾插入一个学生信息
	public void insert(StudentNode node) throws Exception {
		super.insert(this.getLength(), node); // 调用父类的insert方法
	}

	// 覆盖父类的remove方法
	public void remove(int number) throws Exception {
		for (int i = 0; i < getLength(); i++) {// 遍历整个顺序表
			StudentNode node = (StudentNode) super.get(i);// 取出第i项
			if (node.number == number) {
				super.remove(i);// 去除第i项
				return;
			}
		}
		throw new Exception("学号" + number + "不存在");// 拋出异常
	}
	//根据学号修改学生信息
	public void revise(int num,int num2,String name,String sex,double eng,double math) throws Exception {
		for (int i = 0; i < getLength(); i++) {// 遍历整个顺序表
			StudentNode node = (StudentNode) super.get(i);// 取出第i项
			if (node.number == num) {
				((StudentNode) super.get(i)).number=num2;// 修改第i项
				((StudentNode) super.get(i)).name=name;
				((StudentNode) super.get(i)).sex=sex;
				((StudentNode) super.get(i)).english=eng;
				((StudentNode) super.get(i)).math=math;
				return;
			}
		}
		throw new Exception("学号" + num + "不存在");// 拋出异常
	}
	//求平均分
	public void average() throws Exception {
		double sumEng=0;
		double sumMath=0;
		for (int i = 0; i < getLength(); i++) {// 遍历整个顺序表
			StudentNode node = (StudentNode) super.get(i);// 取出第i项
			sumEng+=node.english;
			sumMath+=node.math;
		}
		System.out.println("英语平均分："+sumEng/getLength()+"  高数平均分："+sumMath/getLength());
	}

	// 重写父类display()方法，输出顺序表中的学生信息
	public void display() {
		for (int i = 0; i < getLength(); i++) {// 遍历顺序表
			try {
				StudentNode node = (StudentNode) super.get(i);
				displayNode(node);
			} catch (Exception e) {}
		}
	}

	// 打印单个结点的信息
	public void displayNode(StudentNode node) {
		System.out.println("学号： " + node.number + " 姓名：" + node.name
				+ " 性别： " + node.sex + " 大学英语成绩：" + node.english
				+ " 高等数学成绩： " + node.math);
	}


}
