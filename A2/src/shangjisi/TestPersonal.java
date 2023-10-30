package shangjisi;

public class TestPersonal {
public static void main(String[] args) {
	Personal per=new Personal("19200107135","戚宏宇",20,'男');
	System.out.println("学号:"+per.getId()+" 年龄:"+per.getAge()+" 姓名:"+per.getName()+" 性别:"+per.getSex());
}

}

