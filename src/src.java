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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
class about extends JFrame implements ActionListener
{
	Connection con; 
	Button b1,b2,b3,b4,b5,b6,l,b7,b8,y;
	JPasswordField t2;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JPanel p1,p2,p3;
	JTextField t1,t3,t4,t5;
	String uid,pwd,sq,ans,doj;
	PreparedStatement pst;
	boolean flag;
	JComboBox j,k;
	about()
	{		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		Container c=getContentPane();
		c.setLayout(null);
		p1=new JPanel();
		p1.setLayout(null);
		c.add(p1);
		//----------------------
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createTitledBorder("Developed By"));
     	p2.setBounds(200,100, 500, 500);
		c.add(p2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//--------------------------------
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createTitledBorder("Developed At"));
     	p3.setBounds(700,100, 400, 500);
		c.add(p3);
		//------------------
		l1=new JLabel("This application is being created by Sanjeev Goyal");
		l1.setSize(700,40);
		l1.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
		//l1.setBounds(250,100, 500, 500);
		l1.setLocation(40,40);
		p2.add(l1);
		//-------------------
		l2=new JLabel("by using J2SE and Swings Framework");
		l2.setSize(700,40);
		l2.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
		//l1.setBounds(250,100, 500, 500);
		l2.setLocation(40,100);
		p2.add(l2);
		//-------------------
		l2=new JLabel("  COPYRIGHT.All Rights Reserved");
		l2.setSize(700,40);
		l2.setFont(new Font("Arial",Font.HANGING_BASELINE,25));
		//l1.setBounds(250,100, 500, 500);
		l2.setLocation(40,400);
		p2.add(l2);
		//-------------------
		l3=new JLabel("This Software is creaed at Bangalore");
		l3.setSize(700,40);
		l3.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
		//l1.setBounds(250,100, 500, 500);
		l3.setLocation(40,40);
		p3.add(l3);
		//-------------------
		l4=new JLabel("Computer Education at Bathinda.");
		l4.setSize(700,40);
		l4.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
		//l1.setBounds(250,100, 500, 500);
		l4.setLocation(40,100);
		p3.add(l4);
		//-------------------
		l5=new JLabel("Email Support:goyal.sanjeev94@gmail.com");
		l5.setSize(500,40);
		l5.setFont(new Font("Arial",Font.HANGING_BASELINE,25));
		//l1.setBounds(250,100, 500, 500);
		l5.setLocation(300,628);
		c.add(l5);
		//-------------------
		 b1=new Button("Start");
	       b1.setSize(100, 20);
	       b1.setLocation(1100,628);
	       b1.addActionListener
	           (
	    		   new ActionListener()
	    		   {
	    			public void actionPerformed(ActionEvent ev)
	    			   {
	    				setVisible(false);   
	    				authentication aaa=new authentication();
	    			   }
	    		   }
	    	  );       
	       c.add(b1);
	       b1.setBackground(Color.white);		
		c.setBackground(Color.lightGray);		p3.setBackground(Color.white);		p2.setBackground(Color.white);
		//p1.setForeground(Color.GREEN);
		  //.setSelectionBackground(Color.red);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
     	setSize(1370,770);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
}
public class aboutus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new about();

	}

}
