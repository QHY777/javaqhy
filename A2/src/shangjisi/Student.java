package shangjisi;

public class Student extends Personal {
	String department;
	int grade;
	public Student(String id,String name,int age,char sex,String department,int grade) {
		super(id,name,age,sex);
		this.department=department;
		this.grade=grade;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department=department;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade=grade;
	}
	public void print() {
		System.out.println("学号:"+getId()+" 姓名:"+getName()+" 年龄:"+getAge()+" 性别:"+getSex()+"  系:"+getDepartment()+"  年级:"+getGrade());
	}

}
