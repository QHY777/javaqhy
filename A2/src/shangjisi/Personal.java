package shangjisi;

public class Personal {
	String name;
	 char sex;
	 String id;
	 int age;
	 public Personal() {
		 System.out.println("黑暗阴影");
	 }
	public Personal(String id,String name,int age,char sex) {
	this.name=name;
	this.sex=sex;
	this.age= age;
	this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	public char getSex() {
	    return sex;
	}
	public void setSex(char sex) {
	    this.sex = sex;
	}

}
