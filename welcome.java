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
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;


public class welcome  extends JFrame implements ActionListener
{
public JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l12,l13,l14,l15,l16,l17;
public JButton b;
public JPanel panel;
Font g,h,i;
Color c; 

public welcome()
{
        g=new Font("",Font.BOLD,25);
        h=new Font("",Font.ITALIC,18);
        i=new Font("",Font.BOLD,12);
    	c =new Color(210,100,205);
        

getContentPane().setBackground(Color.orange);
panel=(JPanel)getContentPane();
panel.setLayout(null);


l=new JLabel("WELCOME");
l1=new JLabel("TO");
l2=new JLabel("WONDERFUL");
l14=new JLabel("WORLD");
l3=new JLabel("OF");
l4=new JLabel("HUMAN RESOURCE MANAGEMENT SYSTEM");
l5=new JLabel("Created by:");
l6=new JLabel("Mahaveer Pandey");
l7=new JLabel("Kanchan Pandey");
l8=new JLabel("Sushil Kumar Pandey");
l13=new JLabel("Manisha Pandey");
l9=new JLabel("Under the Guidance of:");
l10=new JLabel("Mr. Ajit Kumar Singh");
l15=new JLabel("Mr. N.K.Tyagi");
l16=new JLabel("Mr. M.R.Pandey");
l17=new JLabel("M.I.T., Bulandshahr");

l12=new JLabel("Marathawada Institute of Technology Bulandshahr, up-203001");
b=new JButton("Click here");

panel.add(l); 
l.setBounds(300,0,180,60);
l.setFont(g);

panel.add(l1);
l1.setBounds(340,70,100,30);
l1.setFont(g);

panel.add(l2);
l2.setBounds(70,100,200,60);
l2.setFont(g);
panel.add(l14);
l14.setBounds(490,100,130,60);
l14.setFont(g);


panel.add(l3);
l3.setBounds(340,140,100,30);
l3.setFont(g);

panel.add(l4);
l4.setFont(g);
l4.setBounds(100,250,700,30);

panel.add(l5);
l5.setFont(h);
l5.setBounds(60,350,150,30);

panel.add(l6);
l6.setFont(i);
l6.setBounds(100,370,150,30);

panel.add(l7);
l7.setFont(i);
l7.setBounds(100,390,150,30);

panel.add(l8);
l8.setFont(i);
l8.setBounds(100,410,150,30);

panel.add(l13);
l13.setFont(i);
l13.setBounds(100,430,150,30);

panel.add(l9);
l9.setFont(h);
l9.setBounds(450,350,200,30);


panel.add(l10);
l10.setFont(i);
l10.setBounds(470,370,180,30);

panel.add(l15);
l15.setFont(i);
l15.setBounds(470,390,180,30);

panel.add(l16);
l16.setFont(i);
l16.setBounds(470,410,180,30);

panel.add(l17);
l17.setFont(i);
l17.setBounds(470,430,180,30);

panel.add(l12);
l12.setFont(h);
l12.setBounds(180,500,500,30);

panel.add(b);
b.setBounds(320,300,110,30);
b.addActionListener(this);

}
public void actionPerformed(ActionEvent a)
{
String s1="Click here";
String str=a.getActionCommand();
if(s1.equals(str))
{
Login f=new Login();
f.setVisible(true);
f.setSize(800,600);
f.show();
Toolkit tk=f.getToolkit();
Dimension wsize=tk.getScreenSize();
f.setBounds(wsize.width/5,wsize.height/5,wsize.width/2,wsize.height/2);
this.dispose();
}
repaint();
}
public static void main(String args[])
{
        welcome f=new  welcome();
        f.setVisible(true);
        f.setSize(800,600);

        f.show();
}
}
