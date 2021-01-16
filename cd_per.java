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

public class cd_per extends JFrame implements ActionListener
{
public JLabel l,l1,l2,l3,l4,l5;
public JTextField t4,t1,t2,t3,t5;
public String ts1,ts2,ts3,ts4,ts5;
public JPanel panel;
public Font g;
public JButton b1,b2,b3,b4;

public cd_per()
{
 g=new Font("",Font.BOLD,18);
getContentPane().setBackground(Color.pink);
panel=(JPanel)getContentPane();
panel.setLayout(null);

l=new JLabel("Candidate Performnace ");
l1=new JLabel("Initial_interview");
l2=new JLabel("Written");
l3=new JLabel("Final_interview");
l4=new JLabel("Description");
l5=new JLabel("Candidate_id");

b1=new JButton("Submit");
b2=new JButton("Next");
b3=new JButton("Search");
b4=new JButton("Back");

t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
t5=new JTextField(20);

t1.setBounds(200,50,150,30);
t2.setBounds(200,100,150,30);
t3.setBounds(200,150,150,30);
t4.setBounds(200,200,150,30);
t5.setBounds(200,250,150,30);

panel.add(b1);
b1.setBounds(500,400,80,30);
panel.add(b2);
b2.setBounds(500,450,80,30);
panel.add(b3);
b3.setBounds(600,400,80,30);
panel.add(b4);
b4.setBounds(600,450,80,30);

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

panel.add(t1);
panel.add(t2);
panel.add(t3);
panel.add(t4);
panel.add(t5);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
}

public void actionPerformed(ActionEvent ae)
{
String str1=ae.getActionCommand();
if(str1=="Next")
{
Shortlist f=new Shortlist();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
if(str1=="Back")
{
masterdetails01 f=new masterdetails01();
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
		
                 Connection con=DriverManager.getConnection("jdbc:odbc:mrp","scott","tiger");
		con.setAutoCommit(false);
             
		 System.out.println("Connection Established.. ........");
		
             Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);	

		   		 
		ts1=t1.getText();
        int a1=Integer.parseInt(ts1);
        ts2=t2.getText();
        int a2=Integer.parseInt(ts2);
        ts3=t3.getText();
		int a3=Integer.parseInt(ts3);
        ts4=t4.getText();		
		ts5=t5.getText();


sm.executeUpdate("create table performance(ini_interview number(20),written number(20),final_inter number(9),descr varchar2(20))");
System.out.println("query2 Established..");

	
PreparedStatement psm=con.prepareStatement("insert into can_perfor values(?,?,?,?,?)");
psm.setInt(1,a1);
psm.setInt(2,a2);
psm.setInt(3,a3);		
psm.setString(4,ts4);
psm.setString(5,ts5);

 int i=psm.executeUpdate();
 System.out.println("query.........Established..");               
        
                   
con.commit();
JOptionPane.showMessageDialog(this,"Query Executed","Record Inserted",JOptionPane.WARNING_MESSAGE);
		   System.out.println("Query Executed");
		  

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
cd_per f=new cd_per();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}

