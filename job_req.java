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
public class job_req extends JFrame implements ActionListener
{
public JLabel l,l1,l2,l3,l4,l5,l6,l7;
public JTextField t1,t2,t3,t4,t5,t6,t7;
public String ts1,ts2,ts3,ts4,ts5,ts6,ts7;
public JPanel panel;
public Font g;
public JButton b1,b2,b3;

public job_req()
{
 g=new Font("",Font.BOLD,18);
getContentPane().setBackground(Color.pink);
panel=(JPanel)getContentPane();
panel.setLayout(null);

l=new JLabel("Requirements for Job Training");
l1=new JLabel("Job ID");
l2=new JLabel("Job Name");
l3=new JLabel("Job Experience");
l4=new JLabel("Job Vacancies");
l5=new JLabel("Job Location");
l6=new JLabel("Job Dpt. no.");
l7=new JLabel("Qualification");

b1=new JButton("Submit");
b2=new JButton("Next");
b3=new JButton("Cancel");

t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
t5=new JTextField(20);
t6=new JTextField(20);
t7=new JTextField(20);

t1.setBounds(200,50,150,30);
t2.setBounds(200,100,150,30);
t3.setBounds(200,150,150,30);
t4.setBounds(200,200,150,30);
t5.setBounds(200,250,150,30);
t6.setBounds(200,300,150,30);
t7.setBounds(200,350,150,30);

panel.add(b1);
b1.setBounds(500,400,80,30);
panel.add(b2);
b2.setBounds(500,450,80,30);
panel.add(b3);
b3.setBounds(500,350,80,30);

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
panel.add(l4);
l5.setBounds(20,250,150,30);
panel.add(l5);
l6.setBounds(20,300,150,30);
panel.add(l6);
l7.setBounds(20,350,150,30);
panel.add(l7);

panel.add(t1);
panel.add(t2);
panel.add(t3);
panel.add(t4);
panel.add(t5);
panel.add(t6);
panel.add(t7);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

}

public void actionPerformed(ActionEvent ae)
{
String str1=ae.getActionCommand();
if(str1=="Cancel")
{
this.dispose();
}
if(str1=="Next")
{
Train_exe f=new Train_exe();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str1=="Submit")		
{

try { 
 	       	System.out.println("starting Established..");

		
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 	       	System.out.println(" Established..");

		Connection con=DriverManager.getConnection("jdbc:odbc:mrp","scott","tiger");
		
System.out.println("Connection Established.. ........");
		
con.setAutoCommit(false);
		 Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);


  ts1=t1.getText();	   
  ts2=t2.getText();
  ts3=t3.getText();
  ts4=t4.getText();
  ts5=t5.getText();
  ts6=t6.getText();
  ts7=t7.getText();

System.out.println("query Established..");

sm.executeUpdate("create table job_req(job_id varchar2(10),job_desig varchar2(12),job_exp varchar2(10),total_vacancies varchar(12),job_location varchar2(12),job_dpt_no varchar2(9),qualification varchar2(10))");
System.out.println("Requariments of candiadtes for job is recieved:as..................");

PreparedStatement psm=con.prepareStatement("insert into job_req values(?,?,?,?,?,?,?)");

	              psm.setString(1,ts1);	       
				psm.setString(2,ts2);				
               	psm.setString(3,ts3);				
                psm.setString(4,ts4);			
		       psm.setString(5,ts5);                
		         psm.setString(6,ts6);	
				 psm.setString(7,ts7);
              

 int i=psm.executeUpdate();         
System.out.println("query.");

con.commit();
		  JOptionPane.showMessageDialog(this,"Query Executed","Record Inserted",JOptionPane.WARNING_MESSAGE);
		   System.out.println("Query Executed");
		  
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");    	 
}
    	
	       catch(Exception e)
		{
			  e.printStackTrace();
		}	
}
}
public static void main(String args[])
{
job_req f=new job_req();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}

