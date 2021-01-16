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
import java.awt.event.*;
import javax.swing.*;

public class Progressbar extends JFrame implements ActionListener
{
static ProgressMonitor pbar;
static int counter =0;
JButton b=new JButton("Click here");

public Progressbar()
{
super("progress monitor demo");
setSize(300,400);
pbar=new ProgressMonitor(null,"monitor progress","Initializing....",0,100);
Timer t=new Timer(250,this);
t.start();
setVisible(true);
}
public static void main(String args[])
{
UIManager.put("progressbar.progressText","HRMS System");
UIManager.put("OptionPane.cancelButtonText","Go away");
 
 new Progressbar();
       welcome f=new  welcome();
         f.setVisible(true);
         f.setSize(800,600);
        f.show();	
}
public void actionPerformed(ActionEvent e)
{
SwingUtilities.invokeLater(new Update());
if(counter==100)
{
b.setEnabled(false);
this.dispose();
} 
}

class Update implements Runnable
{
public void run()
{
if(pbar.isCanceled())
{
pbar.close();
System.exit(1);
}
pbar.setProgress(counter);
pbar.setNote("operation is"+counter+" % complete");
counter+=2;
}
}
}
