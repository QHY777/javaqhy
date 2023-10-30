package homework;
import java.util.*;
public class StudentText {
	public static void main(String[] args) {
		String name,sex;
		int age,grade;
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		name = sc.next();
		System.out.print("Sex: ");
		sex = sc.next();
		System.out.print("Age: ");
		age = sc.nextInt();
		System.out.print("Grade: ");
		grade = sc.nextInt();
		Student stu = new Student(name, sex, age, grade);
		System.out.println(stu.getName());
		System.out.println(stu.getSex());
		System.out.println(stu.getAge());
		System.out.println(stu.getGrade());
		sc.close();
	}
	
}
