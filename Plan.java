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
import java.sql.*;
import java.util.*;

public class Plan extends JFrame  implements ActionListener,ItemListener
{
public JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
public JTextField t1,t2,t4,t5,t6,t7,t8,t9;
public JButton b1,b2,b3;
public String ts1,ts2,ts3,ts4,ts5,ts6,ts7,ts8,ts9;
public String st1,st2,st3,st4,st5,st6,st7,st8,st9;
public JPanel panel;
public Font g;
public JComboBox c;

public Plan()
{
g=new Font("",Font.BOLD,18);

getContentPane().setBackground(Color.orange);
panel=(JPanel)getContentPane();
panel.setLayout(null);

l=new JLabel("Plan For Job Training");
l1=new JLabel(" Training Name");
l2=new JLabel("Objective For Training");
l3=new JLabel("Duration Of Training");
l4=new JLabel(" Required Employees");
l5=new JLabel(" Employee's Id");
l6=new JLabel("Criteria For Training");
l7=new JLabel("Incharge");
l8=new JLabel("Incharge Details");
l9=new JLabel("Modification");

t4=new JTextField(20);
t5=new JTextField(20);
t6=new JTextField(20);
t7=new JTextField(20);
t8=new JTextField(20);
t1=new JTextField(20);
t2=new JTextField(20);
t9=new JTextField(20);

c=new JComboBox();

b1=new JButton("Submit");
b2=new JButton("Next");
b3=new JButton("Back");

c.addItem("one Month");
c.addItem("two Month");
c.addItem("six Month");
c.addItem("one Year");

t1.setBounds(200,50,150,30);
t2.setBounds(200,100,150,30);
t4.setBounds(200,200,150,30);
t5.setBounds(200,250,150,30);
t6.setBounds(200,300,150,30);
t7.setBounds(200,350,150,30);
t8.setBounds(200,400,150,30);
t9.setBounds(200,450,150,30);
c.setBounds(200,150,150,30);

panel.add(b1);
b1.setBounds(500,400,80,30);
panel.add(b2);
b2.setBounds(500,450,80,30);
panel.add(b3);
b3.setBounds(600,400,80,30);

panel.add(l);
l.setBounds(250,1,300,35);
l.setFont(g);

panel.add(l1);
l1.setBounds(20,50,150,30);

panel.add(l2);
l2.setBounds(20,100,150,30);
panel.add(l3);
l3.setBounds(20,150,150,30);
l4.setBounds(20,200,150,30);
l5.setBounds(20,250,150,30);
panel.add(l4);
l6.setBounds(20,300,150,30);
l7.setBounds(20,350,150,30);
panel.add(l5);
panel.add(l6);
l8.setBounds(20,400,150,30);
l9.setBounds(20,450,150,30);

panel.add(l7);
panel.add(l8);
panel.add(l9);

panel.add(t1);
panel.add(t2);
panel.add(t4);
panel.add(t5);
panel.add(t6);
panel.add(t7);
panel.add(t8);
panel.add(t9);

panel.add(c);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
c.addItemListener(this);
}

public void itemStateChanged(ItemEvent ie)
{
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();




if(str=="Back")
{
Shortlist f=new Shortlist();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str=="Next")
{
job_req f=new job_req();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str=="Submit")
{

  try { 
	       
		System.out.println("starting Established..");
                Connection con;
		
                 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
                 //Connection con=DriverManager.getConnection("jdbc:odbc:mrp","scott","tiger");
                 con=DriverManager.getConnection("jdbc:mysql://localhost/qb", "root", "chakrimvn");
		con.setAutoCommit(false);
             
				 System.out.println("Connection Established.. ........");
				 		
             Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);	
	   	 
		ts1=t1.getText();
        ts2=t2.getText();
  ts3=(String)c.getSelectedItem();
		ts4=t4.getText();
        ts5=t5.getText();
		ts6=t6.getText();				
		ts7=t7.getText();	
		ts8=t8.getText();	    
		ts9=t9.getText();


System.out.println("query2 Established..");

sm.executeUpdate("create table plan(train_name varchar2(12),tain_objective varchar2(20),duration varchar2(10),emp_required number(3),emp_id varchar2(12),train_criteria varchar2(10),train_incharge varchar2(6),incharge_details varchar2(30),modification varchar2(10))");
System.out.println("plan for Job_Training Established..");


PreparedStatement psm=con.prepareStatement("insert into plane values(?,?,?,?,?,?,?,?,?)");
		psm.setString(1,ts1);
		psm.setString(2,ts2);
		psm.setString(3,ts3);		
		psm.setString(4,ts4);
		psm.setString(5,ts5);
		psm.setString(6,ts6);
		psm.setString(7,ts7);
		psm.setString(8,ts8);
		psm.setString(9,ts9);

int i=psm.executeUpdate();
                  
    
                  
con.commit();
JOptionPane.showMessageDialog(this,"Query Executed","Record Inserted",JOptionPane.WARNING_MESSAGE);



t1.setText("");
t2.setText("");
/* t3.setText(""); */// as the choice has been encountered//
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
}
		catch(SQLException es){}
		}
}
public static void main(String args[])
{
Plan f=new Plan();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}

