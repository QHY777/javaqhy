package shangji8;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class jsq1 {
   public static void main(String args[]) {
    WindowOperation win=new WindowOperation();
      win.setBounds(100,100,390,360);
      win.setTitle("简单计算器");
   }
}

 @SuppressWarnings("serial")
class WindowOperation extends JFrame {
   JTextField inputNumberOne,inputNumberTwo; 
   JComboBox<String> choiceFuhao;
   JTextArea textShow;
   JButton button;
   OperatorListener operator;    //监视ItemEvent事件的监视器
   ComputerListener computer;  //监视ActionEvent事件的监视器
   public WindowOperation() {
      init();
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void init() {
      setLayout(new FlowLayout());
      inputNumberOne = new JTextField(5);
      inputNumberTwo = new JTextField(5);
      choiceFuhao = new JComboBox<String>();
      button = new JButton("计算"); 
      choiceFuhao.addItem("选择运算符号:");
      String [] a = {"+","-","*","/"};
      for(int i=0;i<a.length;i++) {
          choiceFuhao.addItem(a[i]);
      }
      textShow = new JTextArea(9,30);
      operator = new OperatorListener();
      computer = new ComputerListener();
      operator.setJComboBox(choiceFuhao);
      operator.setWorkTogether(computer);
      computer.setJTextFieldOne(inputNumberOne);
      computer.setJTextFieldTwo(inputNumberTwo);
      computer.setJTextArea(textShow);
      choiceFuhao.addItemListener(operator);   //choiceFuhao是事件源,operator是监视器
      button.addActionListener(computer);     //button是事件源,computer是监视器
      add(inputNumberOne);
      add(choiceFuhao);
      add(inputNumberTwo);
      add(button);
      add(new JScrollPane(textShow));
      }
   }

 class OperatorListener implements ItemListener {
   JComboBox<String> choice;
   ComputerListener workTogether;
   public void setJComboBox(JComboBox<String> box) {
      choice = box;
   }
   public void setWorkTogether(ComputerListener computer) {
      workTogether = computer;
   }
   public void itemStateChanged(ItemEvent e)  {
      String fuhao = choice.getSelectedItem().toString();
      workTogether.setFuhao(fuhao);
   }
}

 class ComputerListener implements ActionListener {
   JTextField inputNumberOne,inputNumberTwo; 
   JTextArea textShow;
   String fuhao;
   public void setJTextFieldOne(JTextField t) {
       inputNumberOne = t;
   }
   public void setJTextFieldTwo(JTextField t) {
       inputNumberTwo = t;
   }
   public void setJTextArea(JTextArea area) {
       textShow = area;
   }
   public void setFuhao(String s) {
       fuhao = s;
   }
   public void actionPerformed(ActionEvent e) {
      try {
            double number1 = Double.parseDouble(inputNumberOne.getText());
            double number2 = Double.parseDouble(inputNumberTwo.getText());
            double result = 0;
            if(fuhao.equals("+")) {
                result = number1+number2;
            }
            else if(fuhao.equals("-")) {
                result = number1-number2;
            }
            else if(fuhao.equals("*")) {
                result = number1*number2;
            }
            else if(fuhao.equals("/")) {
                result = number1/number2;
            }
            textShow.append(number1+" "+fuhao+" "+number2+" = "+result+"\n");
      }
      catch(Exception exp) {
             textShow.append("\n请输入数字字符\n");
      }
   }
}
