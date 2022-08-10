import java.awt.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
class Lottery extends JFrame implements ActionListener
{
   JLabel b1;
	JMenuBar bar=new JMenuBar();
    JMenu a=new JMenu("Prize");	
    JMenu b=new JMenu("Customer");	
    JMenu cc=new JMenu("Agent");	
    JMenu d=new JMenu("Draw");	
    JMenu e=new JMenu("About Us");
    JMenuItem pr=new JMenuItem("Add Prize");
    JMenuItem allpr=new JMenuItem("All Prizes");
    JMenuItem cu=new JMenuItem("Register");
    JMenuItem allcu=new JMenuItem("All Customers");
    JMenuItem ag=new JMenuItem("Add Agent");
    JMenuItem allag=new JMenuItem("All Agents");
    JMenuItem dr=new JMenuItem("Open Draw");
    JMenuItem win=new JMenuItem("Winners");
    Lottery()
   {
    	setUndecorated(true);
	    getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
		Container c=getContentPane();
		c.setLayout(null);
		setJMenuBar(bar);
		bar.add(a);
		bar.add(b);
		bar.add(cc);
		bar.add(d);
		//bar.add(e);
		a.add(pr);
		a.add(allpr);
		b.add(cu);
		b.add(allcu);
		cc.add(ag);
		cc.add(allag);
		d.add(dr);
		d.add(win);
		bar.setBackground(Color.GREEN);
		//------------------
		b1=new JLabel(new ImageIcon("images.gif"));
    	b1.setSize(400,400);
    	b1.setLocation(700,10);
    	c.add(b1);
    	
    	JLabel b2=new JLabel(new ImageIcon("l1.jpeg"));
    	b2.setSize(800,800);
    	b2.setLocation(0,0);
    	c.add(b2);
    	
    	JLabel b3=new JLabel(new ImageIcon("l2.gif"));
    	b3.setSize(800,800);
    	b3.setLocation(500,150);
    	c.add(b3);
    	//----------------------	
	    pr.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  		             AddPrizes ap=new AddPrizes();		  
	  		     		  
	  			   }
	  		   }
	  	  );       
	    allpr.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  				jtableShow app=new jtableShow();		  
	  		     		  
	  			   }
	  		   }
	  	  );       
	    cu.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  				customer cus=new customer();		  
	  		     		  
	  			   }
	  		   }
	  	  );       
	    allcu.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  				jtableShowww allcus=new jtableShowww();		  
	  		     		  
	  			   }
	  		   }
	  	  );       
	    ag.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  		             Agent age=new Agent();		  
	  		     		  
	  			   }
	  		   }
	  	  );       
	    allag.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  				jtableShoww allage=new jtableShoww();		  
	  		     		  
	  			   }
	  		   }
	  	  );       
	    dr.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  				Luckydraw ld=new Luckydraw();		  
	  		     		  
	  			   }
	  		   }
	  	  );
	    win.addActionListener
	     (
	  		   new ActionListener()
	  		   {
	  			public void actionPerformed(ActionEvent ev)
	  			   {
	  				winners winn=new winners();		  
	  		     		  
	  			   }
	  		   }
	  	  );       
		setSize(800,800);
		setVisible(true);
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	 
}
public class lotterysystem extends Lottery {


	public static void main(String[] args) {
     new Lottery();

	}

}
