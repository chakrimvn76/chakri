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
import javax.swing.*;
import java.awt.event.*;

public class help1 extends JFrame implements ActionListener  
{
public TextArea t;
public Font g;
public JButton b;
public JLabel l1;
public JPanel panel;
public help1()
{
g=new Font("",Font.BOLD,24);


getContentPane().setBackground(Color.gray);
panel=(JPanel)getContentPane();
panel.setLayout(null);

t=new TextArea("str",600,500);
panel.add(t);
t.setBounds(50,50,700,500);
l1=new JLabel("About Project Requriments");
panel.add(l1);
l1.setBounds(250,5,400,40);
l1.setFont(g);
l1.setForeground(Color.red);
b=new JButton("BACK");
panel.add(b);
b.setBounds(650,5,100,30);   
b.setBackground

(Color. blue);
b.setFont(new Font("",Font.BOLD,18));             
b.setForeground(Color.pink);
b.addActionListener(this);

}
public void actionPerformed(ActionEvent a)
{
String s1="BACK";
String str=a.getActionCommand();
if(s1.equals(str))
{
help f=new help();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
}
public static void main(String args[])
{
help1 f=new help1();
f.setVisible(true);
f.setSize(800,600);
f.show();
}
}

