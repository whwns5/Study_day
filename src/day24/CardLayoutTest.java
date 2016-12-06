package day24;

import java.awt.*;
import java.awt.event.*;

public class CardLayoutTest {

 /**
  * ī�巹�̾ƿ� �̿�

    --> �������� ī��(�г�)�� ����� ���ϴ� ī�带 ���� ���ʿ� �ø��ٴ� �������� �����ϸ� �ȴ�.

    --> �Ѱ��� Frame�� �������� Panel �� ����� Ȱ���ؾ� �Ѵ�.
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  CardLay css = new CardLay();
  css.setVisible(true);
  css.setSize(500, 500);
  
  css.addWindowListener(new WindowAdapter(){
   public void windowClosing (WindowEvent  e) {
    System.exit(1);
   }
  });
 }

}
class CardLay extends Frame implements ActionListener{
 Button b1,b2,b3;
 Panel p,p1,p2,p3;
 CardLayout card; //ī�巹�̾ƿ� ����� ����
 CardLay(){
     super("ī�巹�̾ƿ�");
     p = new Panel();
     p1 = new Panel();  p1.setBackground(Color.blue);
  
     TextField tf = new TextField();
  
     p2 = new Panel();  p2.setBackground(Color.red);
     p3 = new Panel();  p1.setBackground(Color.black);
     b1 = new Button("����1");  b1.addActionListener(this);
     b2 = new Button("����2");  b2.addActionListener(this);
     b3 = new Button("����3");  b3.addActionListener(this);
   //��ư�� Ŭ������ �� ī�尡 �ٲ�� ó��

    p1.add(b1);
    p2.add(b2);
    p3.add(b3);
    p1.add(tf);
  
  card = new CardLayout(0,0);   // 0,0�� ������ â�� ���̾ƿ� ������ ���� ����� �ǹ���.
  setLayout(card);
  p1.setLayout(new FlowLayout(FlowLayout.CENTER));
  p2.setLayout(new FlowLayout(FlowLayout.CENTER));
  p3.setLayout(new FlowLayout(FlowLayout.CENTER));
  
  add("a1",p1);
  add("a2",p2);
  add("a3",p3);  // Panel�� Frame�� �����Ҷ� a1,a2,a3 ��� ������ �̸��� �������־�� �Ѵ�.
 }
 @Override
 public void actionPerformed(ActionEvent e) {
  String str = e.getActionCommand();
  if(str.equals("����1")){
   card.show(this,"a3"); //�̿Ͱ��� ������� �ٸ� ī��(Panel)���� ��ȯ�� �����ϴ�.
  }
  else if(str.equals("����2")){
   card.show(this,"a1");
  }
  else if(str.equals("����3")){
   card.show(this,"a2");
  }
 }
}
 