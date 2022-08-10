import java.awt.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.*;
class AddCustomer extends JFrame implements  ActionListener
{
	Connection con; 
	Button b1,b2,b3,b4,b5,b6,l;
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JPanel p1,p2,p3;
	JTextField t1,t8,t3,t5,t6,t7;
	JTextArea t4;
	String lottery,aid,cname,caddress,city,mobile,email;
	PreparedStatement pst;
	boolean flag;
	JComboBox t2;
	AddCustomer()
	 { 
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		try{
		     Class.forName("com.mysql.jdbc.Driver");
		     con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/Lottery","root","sanjeev");
	         //JOptionPane.showMessageDialog(null,"Sanjeev welcomes you..");
		 }
		catch(Exception exp){exp.printStackTrace();}
	   	//--------------------------------
		Container c=getContentPane();
		c.setLayout(null);
		p1=new JPanel();
		p1.setLayout(null);
		c.add(p1);
		//---------------------------------
				l1=new JLabel("ADD CUSTOMERS");
				l1.setSize(200,40);
				l1.setLocation(500,40);
				l1.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
				c.add(l1);
		     	//------------------------
				p2=new JPanel();
				p2.setLayout(null);
				p2.setBorder(BorderFactory.createTitledBorder("Details"));
		     	p2.setBounds(200,100, 700, 500);
				c.add(p2);
				
				//--------------------------------
				p3=new JPanel();
				p3.setLayout(null);
				p3.setBorder(BorderFactory.createTitledBorder("Choose"));
		     	p3.setBounds(900,100, 200, 500);
				c.add(p3);
		     	setSize(800,800);
				setVisible(true);
				//----------------------
				l1=new JLabel("Lottery No");
				l1.setSize(100,40);
				l1.setLocation(40,45);
				p2.add(l1);
				//-------------------
				l2=new JLabel("Agent Id");
				l2.setSize(100,40);
				l2.setLocation(40,104);
				p2.add(l2);
				//-------------------
				l3=new JLabel("Customer Name");
				l3.setSize(130,40);
				l3.setLocation(40,153);
				p2.add(l3);
				//-------------------
				l4=new JLabel("Customer Address");
				l4.setSize(130,40);
				l4.setLocation(40,203);
				p2.add(l4);
				//-------------------
				l5=new JLabel("City");
				l5.setSize(100,40);
				l5.setLocation(40,256);
				p2.add(l5);
				//-------------------
				l6=new JLabel("Call Me");
				l6.setSize(100,40);
				l6.setLocation(40,316);
				p2.add(l6);
				//-------------------
				l7=new JLabel("Mail me @");
				l7.setSize(100,40);
				l7.setLocation(40,386);
				p2.add(l7);
				//-------------------
				t1=new JTextField();
				t1.setSize(200,20);
				t1.setLocation(200,45);
				p2.add(t1);
				//--------------------
				/*t8=new JTextField();
				t8.setSize(200,20);
				t8.setLocation(200,104);
				p2.add(t8);*/
				//--------------------
				t2=new JComboBox();
				t2.setSize(200,20);
				t2.setLocation(200,104);
				fetche();
			/*	t2.addActionListener
	            (
	     		   new ActionListener()
	     		   {
	     			public void actionPerformed(ActionEvent ev)
	     			   {
	     				  lottery=t1.getText();
	     				  aid= t2.getSelectedItem().toString();
	     				  cname=t3.getText();
	     				  caddress=t4.getText();
	     				  city=t5.getText();
	     				  mobile=t6.getText();
	     				  email=t3.getText();

	     				   if(fetchGetOne()==false)
							 {
								   JOptionPane.showMessageDialog(null,"the Lottery no with name"+lottery+"does not exist");
							 }

	     			   }
	     		   }
	     				   
	     	  );    */   

		     p2.add(t2);
		     //-----------------
		    

				//p2.add(t2);
				//--------------------
				t3=new JTextField();
				t3.setSize(200,20);
				t3.setLocation(200,153);
				p2.add(t3);
				//--------------------
				t4=new JTextArea(5,20);
				t4.setBorder(BorderFactory.createTitledBorder(""));
				t4.setSize(200,40);
				t4.setBounds(50,50,200,40);
				t4.setLocation(200,203);
				/*JScrollPane j=new JScrollPane(t4);
				j.setBounds(200, 200, 200, 50);
				p2.add(j);*/p2.add(t4);
				//--------------------
				t5=new JTextField();
				t5.setSize(200,20);
				t5.setLocation(200,256);
				p2.add(t5);
				//--------------------
				t6=new JTextField();
				t6.setSize(200,20);
				t6.setLocation(200,316);
				p2.add(t6);
				//--------------------
				t7=new JTextField();
				t7.setSize(200,20);
				t7.setLocation(200,386);
				p2.add(t7);
				//--------------------
				b1=new Button("clear");
			       b1.setSize(100, 20);
			       b1.setLocation(40,70);
			       b1.addActionListener
			       (
					   new ActionListener()
					   {
						public void actionPerformed(ActionEvent ev)
						   {
							t1.setText("");     		  
							t2.setSelectedIndex(0);     		  
							//t8.setText("");     		  
							t3.setText("");     		  
							t4.setText("");     		  
							t5.setText("");     		  
							t6.setText("");     		  
							t7.setText("");     		  

						   }
					   }
				  );       
			       p3.add(b1);
			       b3=new Button("Exit");
			       b3.setSize(100, 20);
			       b3.setLocation(40,350);
			       b3.addActionListener
			       (
					   new ActionListener()
					   {
						public void actionPerformed(ActionEvent ev)
						   {
							   int a=JOptionPane.showConfirmDialog(null,"do u want to exit","warning",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
							   if(a==0)
								   dispose();
						   }
					   }
				  );       
			       b1=new Button("Put Lottery");
			       b1.setSize(100, 20);
			       b1.setLocation(40,200);
			       b1.addActionListener
			           (
			    		   new ActionListener()
			    		   {
			    			public void actionPerformed(ActionEvent ev)
			    			   {
			    				    
			    				 lottery=t1.getText();
			    				 aid=t2.getSelectedItem().toString();
			    				 cname=t3.getText();
			    				 caddress=t4.getText();
			    				 city=t5.getText();
			    				 mobile=t6.getText();
			    				 email=t7.getText();
			    				   if(fetchOne(lottery)==true)
			    				    {
			    					   JOptionPane.showMessageDialog(null,lottery+" already authenticated!");
			    				    }
			    				 else
			    					 doSave();     		  
			    			   }
			    		   }
			    	  );       
			       p3.add(b1);
			       
			       //------------------
			       p3.add(b3);
			       //------------------

			       c.setBackground(Color.gray);
			       p2.setBackground(Color.LIGHT_GRAY);
			       p3.setBackground(Color.LIGHT_GRAY);
			       

     }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	boolean fetchOne(String uid)
	{
		try{
			pst=(PreparedStatement)con.prepareStatement("select * from lottery where LotteryNo=?");
	         pst.setString(1,lottery);
	        ResultSet rs=pst.executeQuery();
	        flag=false; 
	        while(rs.next())
	         {
	        	  flag=true;
	         }
		  }
		catch(Exception e){e.printStackTrace();}
	   return flag;
	}
	 boolean fetchGetOne()
	 	{
	 		try{
	 			pst=(PreparedStatement)con.prepareStatement("select AId from lottery ");
	 	         pst.setString(1,aid);
	 	        ResultSet rs=pst.executeQuery();
	 	        flag=false; 
	 	        while(rs.next())
	 	         {
	 	        	  flag=true;
	 	        	  t2.addItem(rs.getString("AId"));
	 	        	  t1.setText(rs.getString("LotteryNo"));
	 	        	  t8.setText(rs.getString("AgentId"));
	 	        	  t3.setText(rs.getString("CustomerName"));
	 	        	  t4.setText(rs.getString("CustomerAddress"));
	 	        	  t5.setText(rs.getString("City"));
	 	        	  t6.setText(rs.getString("Mobile"));
	 	        	  t7.setText(rs.getString("EmailId"));
	 	         }
	 		  }
	 		catch(Exception e){e.printStackTrace();}
	 	   return flag;
	 	}
	 void fetche()
	 {
		 try{
	 			pst=(PreparedStatement)con.prepareStatement("select AId from agents");
	 	         //pst.setString(1,);
	 	        ResultSet rs=pst.executeQuery();
	 	        //flag=false; 
	 	        while(rs.next())
	 	         {
	 	        	 
	 	        	  t2.addItem(rs.getString("AId"));
	 	        	 
	 	         }
	 		  }
	 		catch(Exception e){e.printStackTrace();}
	 	   
	 
	 }

	void doSave()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("insert into lottery values(?,?,?,?,?,?,?)");  
	          pst.setString(1,lottery);
	          pst.setString(2,aid);
	          pst.setString(3,cname);
	          pst.setString(4,caddress);
	          pst.setString(5,city);
	          pst.setString(6,mobile);
	          pst.setString(7,email);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"User successfully authenticated");
	          else
	        	  JOptionPane.showMessageDialog(null,"sorry user not authenticated");
		    }
		 catch(Exception e){e.printStackTrace();}

	}
}
public class customer extends AddCustomer {

	public static void main(String[] args) {
	 new AddCustomer();

	}

}
