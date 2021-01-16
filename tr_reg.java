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
import java.util.logging.Level;
import java.util.logging.Logger;

public class tr_reg  extends JFrame implements ActionListener,ItemListener
{
public JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
public JTextField t1,t2,t3,t4,t5,t6,t7,t15;
public String ts1,ts2,ts3,ts4,ts5,ts6,ts7,ts8,ts9,ts10,ts11,ts12,ts13,ts14,ts15;
public String s1,s2,s3,s4,s5,s6;
public JToggleButton b1,b2,b3;
public Font g;
public JComboBox ch;
public Checkbox Cb1,Cb2,Cb3,Cb4;
public JPanel panel;
public JRadioButton r1,r2,r3,r4,r5;
public ButtonGroup g1,g2;

public tr_reg()
{
getContentPane().setBackground(Color.pink);
panel=(JPanel)getContentPane();
panel.setLayout(null);
g=new Font("",Font.BOLD,18);

l=new JLabel("Training Ragistration Form");
l1=new JLabel("Name of Candidate");
l2=new JLabel("Fathers Name");
l3=new JLabel("Roll Number");
l4=new JLabel(" Mailing Address");  
l5=new JLabel("Phone Number");
l6=new JLabel("Permanent Address");
l7=new JLabel("PROFF_Qualifications");
l8=new JLabel("Hobbies");
l9=new JLabel("Gender");
l10=new JLabel("Category");
l11=new JLabel("Nationality");
l12=new JLabel("Candidate_id");

b1=new JToggleButton("ADD");
b2=new JToggleButton("Next");
b3=new JToggleButton("Back");

t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
t5=new JTextField(20);
t6=new JTextField(20);
t7=new JTextField(30);
t15=new JTextField(30);


ch=new JComboBox();
panel.add(l);

l.setBounds(240,0,380,60);
panel.add(l1);
l.setFont(g);
l1.setBounds(20,40,120,30);
panel.add(l2);
l2.setBounds(20,100,100,30);
panel.add(l3);
l3.setBounds(20,160,100,30);
panel.add(l4);
l4.setBounds(20,220,100,30);
panel.add(l5);
l5.setBounds(20,280,100,30);
panel.add(l6);
l6.setBounds(20,340,100,30);
panel.add(l7);
l7.setBounds(340,40,150,30);
panel.add(l8);
l8.setBounds(340,100,100,30);
panel.add(l9);
l9.setBounds(340,220,100,30);
panel.add(l10);
l10.setBounds(340,280,100,30);
panel.add(l11);
l11.setBounds(340,340,100,30);
panel.add(l12);
l12.setBounds(340,400,100,30);

panel.add(t1);
t1.setBounds(150,40,100,30);                       
panel.add(t2);
t2.setBounds(150,100,100,30);
panel.add(t3);
t3.setBounds(150,160,100,30);
panel.add(t4);
t4.setBounds(150,220,100,30);
panel.add(t5);
t5.setBounds(150,280,100,30);
panel.add(t6);
t6.setBounds(150,340,100,30);
panel.add(t7);
t7.setBounds(450,340,100,30);
panel.add(t15);
t15.setBounds(450,400,100,30);

panel.add(b1);
b1.setBounds(300,450,80,30);
panel.add(b2);
b2.setBounds(400,450,80,30);
panel.add(b3);
b3.setBounds(500,450,80,30);


ch.addItem("B.Tech.");
ch.addItem("M.Tech.");
ch.addItem("MCA");
ch.addItem("B.Sc.(CS)/M.Sc.(CS)");
ch.addItem("MBA");
panel.add(ch);
ch.setBounds(565,40,150,25);



Cb1=new Checkbox("Painting");
Cb2=new Checkbox("Music");
Cb3=new Checkbox("Playing games");
Cb4=new Checkbox("Solving puzzles");


panel.add(Cb1);
Cb1.setBounds(460,160,100,30);
panel.add(Cb2);
Cb2.setBounds(350,160,100,30);
panel.add(Cb3);
Cb3.setBounds(350,120,100,30);
panel.add(Cb4);
Cb4.setBounds(460,120,100,30);

JRadioButton r1=new  JRadioButton ("Male");
panel.add(r1);
r1.setBounds(350,250,45,25);
JRadioButton r2=new JRadioButton("Female");
panel.add(r2);
r2.setBounds(470,250,70,25);


g1=new ButtonGroup();
g1.add(r1);
g1.add(r2);

JRadioButton r3=new  JRadioButton ("Gen");
panel.add(r3);
r3.setBounds(350,310,70,20);
JRadioButton r4=new  JRadioButton ("OBC");
panel.add(r4);
r4.setBounds(470,310,70,20);
JRadioButton r5=new  JRadioButton ("SC/ST");
panel.add(r5);
r5.setBounds(590,310,70,20);

g2=new ButtonGroup();
g2.add(r3);
g2.add(r4);
g2.add(r5);

 Cb1.addItemListener(this);
Cb2.addItemListener(this);
Cb3.addItemListener(this);
Cb4.addItemListener(this);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

r1.addActionListener(this);
r2.addActionListener(this);
r3.addActionListener(this);
r4.addActionListener(this);
r5.addActionListener(this);

}

public void itemStateChanged(ItemEvent a1)
{
repaint();
}

public void actionPerformed(ActionEvent a)
{
String str=a.getActionCommand();
if(str=="Back")
{
menu f=new menu();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
       
 this.dispose();
}
if(str=="Next")
{
 masterdetails f=new masterdetails();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
 this.dispose();      
}
if(str=="ADD")
{
try { 
 	       	System.out.println("starting Established..");
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con;
con=DriverManager.getConnection("jdbc:mysql://localhost/qb", "root", "chakrimvn");
 	       	System.out.println(" Established..");
//Connection con=DriverManager.getConnection("jdbc:odbc:mrp","scott","tiger");
		
System.out.println("Connection Established.. ........");
con.setAutoCommit(false);

Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);


  ts1=t1.getText();	   
  ts2=t2.getText();	   
  ts3=t3.getText();	   
int a1=Integer.parseInt(ts3);
 ts4=t4.getText();
 ts5=t5.getText();
int a2=Integer.parseInt(ts5);
 ts6=t6.getText();	   
ts7=(String)ch.getSelectedItem();
 ts8=Cb1.getLabel();
 ts9=Cb2.getLabel();
 ts10=Cb3.getLabel();
 ts11=Cb4.getLabel();
String sc=g1.getSelection().getActionCommand();
String sc1=g2.getSelection().getActionCommand();
ts14=t7.getText();
ts15=t15.getText();



System.out.println("query Established..");
//sm.executeUpdate("CREATE TABLE tr_reg(candi_name varchar(20),fathers_name varchar(20),roll_no varchar(20),mailing_add varchar(20),phone_no int(20),permanent_add varchar(20),qualifications varchar(20),hobbie1 varchar(20),hobbie2 varchar(20),hobbie3 varchar(20),hobbie4 varchar(20),gender varchar(10),category varchar(20),nationality varchar(20),candi_id varchar(20))");
System.out.println("Trinee Registration Table  craeted.......");

PreparedStatement psm=con.prepareStatement("insert into tr_reg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                psm.setString(1,ts1);	       
				psm.setString(2,ts2);				
               	psm.setInt(3,a1);				
                psm.setString(4,ts4);			
                psm.setInt(5,a2);                
		        psm.setString(6,ts6);
				psm.setString(7,ts7);
			    psm.setString(8,ts8);
				psm.setString(9,ts9);
				psm.setString(10,ts10);
				psm.setString(11,ts11);
				psm.setString(12,sc);
				psm.setString(13,sc1);
				psm.setString(14,ts14);
				psm.setString(15,ts15);


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
		catch(SQLException es)
		{
		es.printStackTrace();
		}
}
}
public static void main(String args[])
{
        tr_reg f=new tr_reg();
        f.setVisible(true);
        f.setSize(800,600);
        f.show();
}
}

