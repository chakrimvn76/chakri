/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My_Package;

/**
 *
 * @author chakrimvn
 */
import java.awt.*;
  import java.awt.event.*;
  import java.applet.*;
  import javax.swing.*;
  import java.util.*;
public class help extends JFrame implements ActionListener
 {
      public JPanel pane;
      public JButton b1,b2,b3;
      public TextArea t;
  
      public help()
      {
		setTitle("help");
		pane=(JPanel)getContentPane();
		pane.setLayout(null);		

		JLabel j=new JLabel(" HELP FILE ");
		j.setFont(new Font("monotype corsiva",Font.ITALIC,30));
		j.setBounds(300,20,250,50);
		pane.add(j);

                           
		
		t=new TextArea("val",15,20);
		t.setBounds(50,70,700,400);
		t.setBackground(Color.pink);
		t.setForeground(Color.gray);
                Font f2=new Font("Arial",Font.ITALIC,12);
		t.setFont(f2);
		t.setEnabled(true);
		b1=new JButton("ABOUT THE PROJECT");
                b2=new JButton("Shortcut Keys");
                b3=new JButton("Cancle");
                
                pane.add(b1);
                pane.add(b2);
                pane.add(b3);
                                
                b1.setBounds(100,500,200,30);
                b2.setBounds(320,500,200,30);
                b3.setBounds(530,500,100,30);
                 
        b1.setFont(f2);
		b2.setFont(f2);
		b3.setFont(f2);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b3.setBackground(Color.blue);
b3.setForeground(Color.white);		
		                       pane.add(t);
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);	
}
public void actionPerformed(ActionEvent a)
{  
String s1="ABOUT THE PROJECT";
String s2="Shortcut Keys";
String s3="Cancle";
String str=a.getActionCommand();
if(s1.equals(str))
{
help1 f=new help1();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(s2.equals(str))
{
help2 f=new help2();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(s3.equals(str))
{
 this.dispose();
}
}      
public static void main(String args[])
{
help f=new help();
f.setVisible(true);
f.setSize(800,600);
f.show();
}   	
} 

