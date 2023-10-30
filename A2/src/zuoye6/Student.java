package zuoye6;



import	java.util.Objects;
public class Student {
	//自定义异常
	public class MyException extends Exception{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyException() {

	    }

	    public MyException(String message) {
	        super(message);
	    }
	}
	private int id;
    private String name;
    private int age;
    private double mark;
    //构造方法
    public Student() {
    }
    public Student(int id, String name, int age, double mark) throws MyException {
        if( id < 0 ){
            throw new MyException("学号不可以小于零");
        }
        if ("".equals(name)){
            throw new MyException("名字不可以为空");
        }
        if (age < 0){
            throw new MyException("年龄不可以小于零");
        }
        if (mark < 0 || mark > 100){
            throw new MyException("成绩不能低于0分，高于100分");
        }
        this.id = id;
        this.name = name;
        this.age =age;
        this.mark =mark;
    }
    //set和get方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getMark() {
        return mark;
    }
    public void setMark(double mark) {
        this.mark = mark;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Double.compare(student.mark, mark) == 0 &&
                Objects.equals(name, student.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, mark);
    }
}
