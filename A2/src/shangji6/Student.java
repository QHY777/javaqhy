package shangji6;

class StudentException extends Exception{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//无参构造
    public  StudentException() {

    }
    //有参构造
    public StudentException(String message){
    }
}

public class Student{

    private int number;
    private String name;
    private int age;
    private double grade;

    public Student() {
    }

    public Student(int number, String name, int age, double grade) throws StudentException {
        if(number < 0){
            throw new StudentException("输入学生学号错误");
        }else {
            this.number = number;
        }
        this.name = name;
        if(age < 0){
            throw new StudentException("输入学生年龄错误");
        }else {
            this.age = age;
        }
        if(grade < 0 || grade > 100){
            throw new StudentException("输入学生成绩错误");
        }else {
            this.grade = grade;
        }
    }

    //输出学生信息
    public void println2(){
        System.out.println("学生学号: " + this.number+" 学生姓名: " + this.name + " 学生年龄: " + this.age + " 学生成绩: " + this.grade);
    }
}
