package shangji8;


import java.awt.*;
import javax.swing.*;

public class Calculator {
    public Calculator() {
    }

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
       JFrame frame =new JFrame("计算器");
       frame.setSize(300, 300);
       frame.setDefaultCloseOperation(3);
       frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
       JButton button1=new JButton("加");
       frame.add(button1);
       JButton button2=new JButton("差");
       frame.add(button2);
       JButton button3 =new JButton("除");
        frame.add(button3);
       JButton button4 =new JButton("积");
       frame.add(button4);
       frame.setVisible(true);
      
	}

}
