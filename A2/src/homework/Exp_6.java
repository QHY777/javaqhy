package homework;


	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;
	import static javax.swing.JFrame.*;
	
public class Exp_6 {
	   public static void main(String args[]) {
	       WindowNumber win=new WindowNumber();
	   }
	}
	
	 class WindowNumber extends JFrame { 
	   JTextField textInput,textShow;
	   PoliceListen listener;
	   public WindowNumber() {
	      init();
	      setBounds(100,100,150,150);
	      setVisible(true);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	   void init() {
	      setLayout(new FlowLayout());
	      textInput=new JTextField(10);
	      textShow=new JTextField(10); 
	      textShow.setEditable(false);
	      listener=new PoliceListen();
	      listener.setJTextField(textShow); //将textShow的引用传递给listen的text
	      textInput.addActionListener(listener); //textInput是事件源,listener是监视器
	      add(textInput); 
	      add(textShow);
	   }
	}
	 
	
	 class PoliceListen implements ActionListener { 
	   JTextField text;
	   public void setJTextField(JTextField text) {
	      this.text=text;
	   }
	   public void actionPerformed(ActionEvent e) {
	      int n=0,m=0;
	      JTextField textSource=(JTextField)e.getSource();
	      String str=textSource.getText();
	      if(!str.isEmpty()) {
	         try{  
	             n=Integer.parseInt(str);
	             m=n*n;
	              text.setText(""+m);
	         }
	         catch(Exception ee) {
	             textSource.setText("请输入数字");
	         }
	      }
	   }
	}
