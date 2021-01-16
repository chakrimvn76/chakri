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

public class masterdetails01  extends JFrame implements ActionListener
{                  
public JLabel l,l0,l1,l2,l3,l4,l5,l7,l8,l9,l10;
public JTextField t,t0,t1,t2,t3,t4,t5;
public Choice ch1,ch2;
public Font g;
public String ts1,ts2,ts3,ts4,ts5,ts6,ts7,ts8,ts9,ts10;
public List list;
public JButton b1,b2,b3;
public JPanel panel;

public masterdetails01()
{
getContentPane().setBackground(Color.pink);
panel=(JPanel)getContentPane();
panel.setLayout(null);
 g=new Font("",Font.BOLD,18);

 l=new JLabel("Training Department Information");
l0=new JLabel("Department Name");
l1=new JLabel("Cost of Training");
l2=new JLabel("Number of Departments");
l3=new JLabel("Number of Employees/Batch");
l4=new JLabel("Details of Employees");
l5=new JLabel("Duration of Training");
l7=new JLabel("Person Assigned for Training");
l8=new JLabel("Name of Training Program");
l9=new JLabel("Department Details");
l10=new JLabel("Training for which post");
ch1=new Choice();
ch2=new Choice();

l.setFont(g); 
List list=new List(10,true);
 
t=new JTextField(20);
t0=new JTextField(20);
t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
t5=new JTextField(20);

b1=new JButton("ADD");
b2=new JButton("Next");
b3=new JButton("Back");
               
panel.add(l);
l.setBounds(250,5,400,40);
panel.add(l0);
l0.setBounds(20,30,350,50);
panel.add(l1);
l1.setBounds(20,80,350,50);
panel.add(l2);
l2.setBounds(20,130,350,50);
panel.add(l3);
l3.setBounds(20,180,350,50);
panel.add(l4);
l4.setBounds(20,230,350,50);
panel.add(l5);
l5.setBounds(20,280,350,50);
panel.add(l7);
l7.setBounds(20,330,350,50);
panel.add(l8);
l8.setBounds(20,380,350,50);
panel.add(l9);
l9.setBounds(20,430,350,50);
panel.add(l10);
l10.setBounds(20,480,350,50);
list.add("One");
list.add("Two");
list.add("Three");
list.add("Four");
panel.add(list);
list.setBounds(420,140,200,50);

ch1.addItem("Rs. 10000 upto 20000");
ch1.addItem("Above 20000 upto 50000");
ch1.addItem("Above 50000");
panel.add(ch1);
ch1.setBounds(420,100,200,50);

ch2.addItem("60 Hours/90 Hours");
ch2.addItem("45 Days");
ch2.addItem("6 Months");
ch2.addItem("12 Months");
panel.add(ch2);
ch2.setBounds(420,300,200,50);
 
panel.add(t);
t.setBounds(420,40,120,30);
panel.add(t0);
t0.setBounds(420,200,120,30);
panel.add(t1);
t1.setBounds(420,250,120,30);
panel.add(t2);
t2.setBounds(420,350,120,30);
panel.add(t3);
t3.setBounds(420,400,120,30);
panel.add(t4);
t4.setBounds(420,450,120,30);
panel.add(t5);
t5.setBounds(420,500,120,30);
 
panel.add(b1);
b1.setBounds(650,400,80,30);
panel.add(b2);
b2.setBounds(650,450,80,30);

panel.add(b3);
b3.setBounds(650,500,80,30);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent a)
{  
String str=a.getActionCommand();
if(str=="Back")
{
masterdetails f=new masterdetails();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str=="Next")
{
cd_per f=new cd_per();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str=="ADD")
{
try { 
 	       	System.out.println("starting Established..");


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 	       	System.out.println(" Established..");

		Connection con=DriverManager.getConnection("jdbc:odbc:mrp","scott","tiger");
		
System.out.println("Connection Established.. ........");
		
con.setAutoCommit(false);
		 Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

  ts1=t.getText();	   
  ts2=ch1.getSelectedItem();
  ts3=list.getSelectedItem();
  ts4=t0.getText();
 int a1=Integer.parseInt(ts4);
  ts5=t1.getText();
  ts6=ch2.getSelectedItem();
  ts7=t2.getText();
  ts8=t3.getText();
  ts9=t4.getText();
  ts10=t5.getText();

System.out.println("query Established..");

sm.executeUpdate("create table mastredetails01(dpt_name varchar2(20),charges varchar2(6),total_dpts varchar2(10),total_emp/batch varchar2(12),emp_details/batch,duration varchar2(12),incharge_name varchar2(10),taining_name avrchar2(12),dpt_details varchar2(12),train_designation varchar2(12))");
System.out.println("Table named masterdatils01 created.........");

PreparedStatement psm=con.prepareStatement("insert into masterdetails01 values(?,?,?,?,?,?,?,?,?,?)");

                psm.setString(1,ts1);	       
				psm.setString(2,ts2);				
               	psm.setString(3,ts3);				
                psm.setInt(4,a1);			
                psm.setString(5,ts5);                
		        psm.setString(6,ts6);	
	            psm.setString(7,ts7);
                psm.setString(8,ts8);  		
                psm.setString(9,ts9);  		
                psm.setString(10,ts10);  		
                 
 int i=psm.executeUpdate();     
 System.out.println("query.");
 
 con.commit();
		  JOptionPane.showMessageDialog(this,"Query Executed","Record Inserted",JOptionPane.WARNING_MESSAGE);
		   System.out.println("Query Executed");
		  
t0.setText("");
 t.setText("");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");   	 
}

	       catch(ClassNotFoundException e)
		{
			  e.printStackTrace();
		}
		catch(SQLException es){}

}
}
public static void main(String args[])
{
        masterdetails01 f=new masterdetails01();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
  }
  }       

