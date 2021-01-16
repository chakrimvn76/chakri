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
import java.sql.*;
import java.awt.event.*;

public class Shortlist extends JFrame implements ActionListener
{
public JLabel l,l1,l2,l3,l4,l5,l6,l7;
public JTextField t1,t2,t4,t5,t6,t7;
public String ts1,ts2,ts3,ts4,ts5,ts6,ts7;
public TextArea t3;
public JButton b1,b2,b3;
public JPanel panel;
public Font g;

public Shortlist()
{
g=new Font("",Font.BOLD,22);
getContentPane().setBackground(Color.pink);
panel=(JPanel)getContentPane();
panel.setLayout(null);

l=new JLabel("Shortlisted Candidates ");
l1=new JLabel("Candidate's Id");
l2=new JLabel("Candidate's Name");
l3=new JLabel("Candidate's Address");
l4=new JLabel("Candidate's Phone");
l5=new JLabel("Candidate's Resume No.");
l6=new JLabel("Round Of Qualified");
l7=new JLabel("Candidate's E-mail");

t3=new TextArea(5,8);
t4=new JTextField(20);
t5=new JTextField(20);
t6=new JTextField(20);
t7=new JTextField(20);
t1=new JTextField(20);
t2=new JTextField(20);

b1=new JButton("Submit");
b2=new JButton("Next");
b3=new JButton("Back");

t1.setBounds(200,100,150,30);
t2.setBounds(200,150,150,30);
t3.setBounds(200,400,150,60);
t4.setBounds(200,200,150,30);
t5.setBounds(200,250,150,30);
t6.setBounds(200,300,150,30);
t7.setBounds(200,350,150,30);
 
panel.add(b1);
panel.add(b2);
panel.add(b3);

b1.setBounds(450,200,100,30);
b2.setBounds(450,300,100,30);
b3.setBounds(450,400,100,30);

panel.add(l);
l.setBounds(250,10,300,35);
l.setFont(g);
panel.add(l1);
l1.setBounds(20,100,150,30);

panel.add(l2);
l2.setBounds(20,150,150,30);
panel.add(l3);
l3.setBounds(20,200,150,30);
l4.setBounds(20,250,150,30);
l5.setBounds(20,300,150,30);
panel.add(l4);
l6.setBounds(20,350,150,30);
l7.setBounds(20,400,150,30);
panel.add(l5);
panel.add(l6);
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
if(str1=="Next")
{
Plan f=new Plan();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str1=="Back")
{
cd_per f=new cd_per();
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
 int a1=Integer.parseInt(ts4);
 ts5=t5.getText();
 int a2=Integer.parseInt(ts5);
 ts6=t6.getText();
 ts7=t7.getText();
 int a3=Integer.parseInt(ts6);
System.out.println("query Established..");


sm.executeUpdate("create table shortlist(candi_id varchar2(10) primary key,candi_name varchar2(12),candi_add varchar2(12),candi_phone varchar2(10),resume_no varchar(6),round_no number(2),caindi_mail varchar2(12))");
System.out.println("shortlisted candiadtes info recieved..............");


PreparedStatement psm=con.prepareStatement("insert into shortlist_cand values(?,?,?,?,?,?,?)");

	            psm.setString(1,ts1);	       
				psm.setString(2,ts2);				
               	psm.setString(3,ts3);				
                psm.setInt(4,a1);			
		        psm.setInt(5,a2);                
		        psm.setInt(6,a3);	
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

	       catch(ClassNotFoundException e)
		{
			  e.printStackTrace();
		}
		catch(SQLException es)
		{
		}
		}

}
public static void main(String args[])
{
Shortlist f=new Shortlist();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}

