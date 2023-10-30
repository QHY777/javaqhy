package zuoyesan;

public class Student extends Person{
private int age;
private int cj;
public Student(String name,char sex,int age,int cj){
			super(name,sex);
			this.age = age;
			this.cj = cj;
		}
			public int getAge() {
			return age;
		}
			public void setAge(int age) {
			this.age = age;
		}
			public int getCj() {
			return cj;
		}
			public void setCj(int cj) {
			this.cj = cj;
		}
			public void print(){
		        System.out.println("学生名字是 " + this.getName() + " 是" + this.getSex()
		                +"生 , 年龄是 " + this.age + " 岁，成绩是 " + this.cj);
		    }
}


