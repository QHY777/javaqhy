package homework;

public class Student extends Person {
	private int age;
	private int grade;
	public Student(String name, String sex, int age, int grade) {
		super(name,sex);
		this.age = age;
		this.grade = grade;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
