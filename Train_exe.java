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

public class Train_exe  extends JFrame implements ActionListener
{
public JLabel l,l1,l2,l3,l4,l5;
public Choice ch1,ch2;
public JRadioButton b1,b2;
public String ts1,ts2,ts3,ts4;
public  TextArea t;
public Font g;
public JButton b3,b4;
public JPanel panel;

public Train_exe()
{
getContentPane().setBackground(Color.pink);
panel=(JPanel)getContentPane();
panel.setLayout(null);
g=new Font("",Font.BOLD,18);

l=new JLabel("Job Training Result");
l1=new JLabel("Training Name");
l2=new JLabel("Training Status");
l3=new JLabel("Performance of Employee");
l4=new JLabel("Result of Training");

ch1=new Choice();
ch2=new Choice();

JRadioButton b1=new JRadioButton("On Campus",true);
JRadioButton b2=new JRadioButton("Off Campus",false);

 
b3=new JButton("ADD");
b4=new JButton("Cancle");


t=new TextArea(4,4);

panel.add(l);
l.setBounds(200,5,350,50);
l.setFont(g);
panel.add(l1);
l1.setBounds(20,50,150,50);
panel.add(l2);
l2.setBounds(20,120,200,50);
panel.add(l3);
l3.setBounds(20,190,250,50);
panel.add(l4);
l4.setBounds(20,260,350,50);


ch1.addItem("Online Project Training");
ch1.addItem("Offline Project Training");
ch1.addItem("Vocational Training");
ch1.addItem("Dpt.Training/Workshop");
panel.add(ch1);
ch1.setBounds(200,65,250,50);

ch2.addItem("Avegrage");
ch2.addItem("Good");
ch2.addItem("Honourable");
panel.add(ch2);
ch2.setBounds(200,280,150,60);

panel.add(b1);
b1.setBounds(200,120,100,30);
panel.add(b2);
b2.setBounds(350,120,100,30);

panel.add(t);
t.setBounds(200,190,250,60);

panel.add(b3);
b3.setBounds(200,400,100,30);
panel.add(b4);
b4.setBounds(350,400,100,30);
b3.addActionListener(this);
b4.addActionListener(this);
}

public void actionPerformed(ActionEvent a)
{
String str=a.getActionCommand();



if(str=="Cancle")
{ 
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


  ts1=ch1.getSelectedItem();  
  ts3=t.getText();
  ts4=ch2.getSelectedItem();	   
   
System.out.println("query Established..");

sm.executeUpdate("create table execution(train_name varchar2(10),train_status varchar2(12),train_peformance avrcahr2(10),train_result avrchar2(9))");
System.out.println("The Selected Candiadtes are:......................");

PreparedStatement psm=con.prepareStatement("insert into train_exe values(?,?,?,?)");

	            psm.setString(1,ts1);	       
				psm.setString(2,ts2);				
               	psm.setString(3,ts3);				
                psm.setString(4,ts4);	    
 
con.commit();
		  JOptionPane.showMessageDialog(this,"Query Executed","Record Inserted",JOptionPane.WARNING_MESSAGE);
		   System.out.println("Query Executed");
		  
t.setText("");  	 
}
  catch(ClassNotFoundException e)
		{
			  e.printStackTrace();
		}
		catch(SQLException es){}
		}

repaint();
}
public static void main(String args[])
{
        Train_exe f=new Train_exe();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}
