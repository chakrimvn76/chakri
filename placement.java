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



public class placement  extends JFrame implements ActionListener
{
public JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
public JTextField t1,t2,t4,t5,t6,t7,t8;
public TextArea t3;
public String ts1,ts2,ts3,ts4,ts5,ts6,ts7,ts8;
public JButton b1,b2,b3,b4,b5;
public JPanel panel;
public Font g;

public placement()
{
g=new Font("",Font.BOLD,18);
getContentPane().setBackground(Color.orange);
panel=(JPanel)getContentPane();
panel.setLayout(null);

l=new JLabel("Placement Agenicies");
l1=new JLabel("Agencies Id Number");
l2=new JLabel("Agencies Name");
l3=new JLabel("Agencies Address");
l4=new JLabel("Agencies Cont_Person");
l5=new JLabel("Agencies Cont_Phone");
l6=new JLabel("Agencies Charge");
l7=new JLabel("Agencies E-mail ID");
l8=new JLabel("Agencies WebSite");

t3=new TextArea(5,8);
t4=new JTextField(20);
t5=new JTextField(20);
t6=new JTextField(20);
t7=new JTextField(20);
t8=new JTextField(20);
t1=new JTextField(20);
t2=new JTextField(20);

b1=new JButton("submit");
b2=new JButton("Next");
b3=new JButton("search");
b4=new JButton("clear");
 
t1.setBounds(200,50,150,30);
t2.setBounds(200,100,150,30);
t3.setBounds(200,400,150,60);
t4.setBounds(200,150,150,30);
t5.setBounds(200,200,150,30);
t6.setBounds(200,250,150,30);
t7.setBounds(200,300,150,30);
t8.setBounds(200,350,150,30);


panel.add(b1);
b1.setBounds(450,400,80,30);
panel.add(b2);
b2.setBounds(450,450,80,30);
panel.add(b3);
b3.setBounds(550,400,80,30);
panel.add(b4);
b4.setBounds(550,450,80,30);
 
panel.add(l);
l.setBounds(250,1,300,35);
l.setFont(g);
panel.add(l1);
l1.setBounds(20,50,150,30);

panel.add(l2);
l2.setBounds(20,100,150,30);
panel.add(l3);
l3.setBounds(20,400,150,30);
l4.setBounds(20,150,150,30);
l5.setBounds(20,200,150,30);
panel.add(l4);
l6.setBounds(20,250,150,30);
l7.setBounds(20,300,150,30);
panel.add(l5);
panel.add(l6);
l8.setBounds(20,350,150,30);
panel.add(l7);
panel.add(l8);

panel.add(t1);
panel.add(t2);
panel.add(t3);
panel.add(t4);
panel.add(t5);
panel.add(t6);
panel.add(t7);
panel.add(t8);

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
tr_reg f=new tr_reg();
f.setVisible(true);
f.setSize(800,600);
f.show();
this.dispose();
}
try { 
 	       	System.out.println("starting Established..");


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 	       	System.out.println(" Established..");

		Connection con=DriverManager.getConnection("jdbc:odbc:mrp","scott","tiger");
		
System.out.println("Connection Established.. ........");
		
con.setAutoCommit(false);
		 Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);


if(str1=="submit")		
{
 ts1=t1.getText();	   
 ts2=t2.getText();
 ts3=t3.getText();
 ts4=t4.getText();
 ts5=t5.getText();
 int a1=Integer.parseInt(ts5);
 ts6=t6.getText();
int a2=Integer.parseInt(ts6);
 ts7=t7.getText();
 ts8=t8.getText();



System.out.println("query Established..");
sm.executeUpdate("create table placement(ag_id varchar2(8),ag_name varchar2(12),ag_add varchar2(15),cont_person varchar(12),cont_no number(12),ag_charge varchar2(7),ag_mail varchar2(20),ag_site varchar2(20))");
System.out.println("Table created........");


PreparedStatement psm=con.prepareStatement("insert into placement_agenci values(?,?,?,?,?,?,?,?)");

            psm.setString(1,ts1);	       
			psm.setString(2,ts2);				
           	psm.setString(3,ts3);				
            psm.setString(4,ts4);			
            psm.setInt(5,a1);                
	        psm.setInt(6,a2);	
	        psm.setString(7,ts7);
            psm.setString(8,ts5);  		
                 

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
t8.setText("");
}

if(str1=="search")
{
ts1=t1.getText();
ResultSet rs=sm.executeQuery("select * from placement_agenci where ag_id='"+ts1+"'");



if(rs.next())
{
String st1=rs.getString(1);
String st2=rs.getString(2);
String st3=rs.getString(8);
String st4=rs.getString(3);
String st5=rs.getString(4);
String st6=rs.getString(5);
String st7=rs.getString(6);
String st8=rs.getString(7);


         t1.setText(st1);
         t2.setText(st2);
         t3.setText(st3);
         t4.setText(st4);
         t5.setText(st5);
         t6.setText(st6);
         t7.setText(st7);
         t8.setText(st8);
}
else
{
 JOptionPane.showMessageDialog(this,"ID must be exist,may be id is not available","Search is possible",JOptionPane.WARNING_MESSAGE);
}
}
 if(str1=="clear")
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");

}		  
    	}
	       catch(ClassNotFoundException e)
		{
			  e.printStackTrace();
		}
		catch(SQLException es){}
		}
public static void main(String args[])
{
placement f=new placement();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}
