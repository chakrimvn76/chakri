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

public class masterdetails  extends JFrame implements ActionListener
{                  
public JLabel l,l0,l1,l2,l3,l4,l5,l6,l7,l8,l9;
public JTextField t,t0,t1,t2,t3;
public Choice ch1,ch2;
public String ts1,ts2,ts3,ts4,ts5,ts6,ts7,ts8;
public Font g;
public List list;
public JButton b1,b2,b3;

public JPanel panel;
public masterdetails()
{
getContentPane().setBackground(Color.pink);
panel=(JPanel)getContentPane();
panel.setLayout(null);
g=new Font("",Font.BOLD,18);



l=new JLabel("Available Training Agenda");
l0=new JLabel("Institute Name");
l1=new JLabel("Training Criteria");
 l2=new JLabel("Number of Batches");
 l3=new JLabel("Number of Candidates/Batch");
l4=new JLabel("Details of Candidates in each Batch");
 l5=new JLabel("Duration of Training");
 l6=new JLabel("Cost of Training");
 l7=new JLabel("Training Incharge");
  

l.setFont(g);
ch1=new Choice();
ch2=new Choice();
 
List list=new List(10,true);

 
t=new JTextField(20);
t0=new JTextField(20);
t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);

b1=new JButton("ADD");
b2=new JButton("Next");
b3=new JButton("Back");
               
panel.add(l);
l.setBounds(200,5,350,40);

panel.add(l0);
l0.setBounds(20,50,350,50);
panel.add(l1);
l1.setBounds(20,100,350,50);
panel.add(l2);
l2.setBounds(20,150,350,50);
panel.add(l3);
l3.setBounds(20,200,350,50);
panel.add(l4);
l4.setBounds(20,250,350,50);
panel.add(l5);
l5.setBounds(20,300,350,50);
panel.add(l6);
l6.setBounds(20,350,350,50);
panel.add(l7);
l7.setBounds(20,400,350,50);
 

list.add("One");
list.add("Two");
list.add("Three");
list.add("Four");
panel.add(list);
list.setBounds(420,150,200,50);


ch1.addItem("B.Tech./M.Tech.");
ch1.addItem("BCA/MCA");
ch1.addItem("BBA/MBA");
panel.add(ch1);
ch1.setBounds(420,120,200,50);

ch2.addItem("60 Hours/90 Hours");
ch2.addItem("45 Days");
ch2.addItem("6 Months");
ch2.addItem("12 Months");
panel.add(ch2);
ch2.setBounds(420,320,200,50);

panel.add(t0);
t0.setBounds(420,50,120,30);
panel.add(t);
t.setBounds(420,260,120,30);
t1.setBounds(420,360,120,30);
panel.add(t1);
t2.setBounds(420,410,120,30);
panel.add(t2);
t3.setBounds(420,210,120,30);
panel.add(t3);
panel.add(b1);
b1.setBounds(300,450,80,30);
panel.add(b2);
b2.setBounds(400,450,80,30);
panel.add(b3);
b3.setBounds(500,450,80,30);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}

public void actionPerformed(ActionEvent a)
{  
String str=a.getActionCommand();
if(str=="Back")
{
tr_reg f=new tr_reg();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str=="Next")
{
masterdetails01 f=new masterdetails01();
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


  ts1=t0.getText();	   
  ts2=ch1.getSelectedItem();
  ts3=list.getSelectedItem();
  ts4=t3.getText();
  ts5=t.getText();
  ts6=ch2.getSelectedItem();
  ts7=t1.getText();
  ts8=t2.getText();

System.out.println("query Established..");

sm.executeUpdate("create table mastredetails(insti_name varchar2(20),criteria number(5),total_batches number(2),candi/batch number(2),candi_details/batch varchar2(20),duration varchar2(10),charges number(6),incharge_name varchar2(12))");
System.out.println("query2 Established..");

PreparedStatement psm=con.prepareStatement("insert into masterdetails values(?,?,?,?,?,?,?,?)");

                psm.setString(1,ts1);	       
				psm.setString(2,ts2);				
               	psm.setString(3,ts3);				
                psm.setString(4,ts4);			
                psm.setString(5,ts5);                
  		        psm.setString(6,ts6);	
		        psm.setString(7,ts7);
                psm.setString(8,ts5);  		
                
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
        masterdetails f=new masterdetails();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}

