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
import javax.swing.JTextField;

import com.mysql.jdbc.*;
class AgentAdmin extends JFrame implements ActionListener
{
	 Connection con; 
     JPanel p1,p2,p3;
     JLabel l1,l2,l3,l4,l5,l6;
     Button b1,b2,b3,b4,b5,b6,l;  
     JTextField t2,t3,t4,t5,t6,t7;
     JComboBox t1;
  //   String AIds[]={"12345","12346","123489","12456","14789","45698","522334","45312","78952","32152","65461","16161","611161","484684","136365","161611","1616511","161641","16161648","48796131"};
     String AId,Aname,address,city,mobile,email;
 	PreparedStatement pst;

     boolean flag;
      AgentAdmin()
	{setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
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
				l1=new JLabel("AGENT ADMIN PANEL");
				l1.setSize(250,40);
				l1.setLocation(500,40);
				l1.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
				l1.setBackground(Color.gray);
				c.add(l1);
		     	//------------------------
				p2=new JPanel();
				p2.setLayout(null);
				p2.setBorder(BorderFactory.createTitledBorder("Agent SignUp form"));
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
				p3.setBackground(Color.cyan);		p2.setBackground(Color.cyan);
				
				//----------------------
				l1=new JLabel("Agent ID");
				l1.setSize(100,40);
				l1.setLocation(40,60);
				p2.add(l1);
				//-------------------
				l2=new JLabel("Name");
				l2.setSize(100,40);
				l2.setLocation(40,108);
				p2.add(l2);
				//-------------------
				l3=new JLabel("Address");
				l3.setSize(110,40);
				l3.setLocation(40,153);
				p2.add(l3);
				//-------------------
				l4=new JLabel("City");
				l4.setSize(100,40);
				l4.setLocation(40,203);
				p2.add(l4);
				//-------------------
				l5=new JLabel("Mobile no");
				l5.setSize(100,40);
				l5.setLocation(40,256);
				p2.add(l5);
				//-------------------
				l6=new JLabel("Email Id");
				l6.setSize(100,40);
				l6.setLocation(40,326);
				p2.add(l6);
				//-------------------
			    t2=new JTextField();
				t2.setSize(200,20);
				t2.setLocation(200,60);
				p2.add(t2);
				//--------------------
				t7=new JTextField();
				t7.setSize(200,20);
				t7.setLocation(200,108);
				p2.add(t7);
				//--------------------
				
				t3=new JTextField();
				t3.setSize(200,20);
				t3.setLocation(200,153);
				p2.add(t3);
				//--------------------
				t4=new JTextField();
				t4.setSize(200,20);
				t4.setLocation(200,203);
				p2.add(t4);
				//--------------------
				t5=new JTextField();
				t5.setSize(200,20);
				t5.setLocation(200,256);
				p2.add(t5);
				//--------------------
				t6=new JTextField();
				t6.setSize(200,20);
				t6.setLocation(200,326);
				p2.add(t6);
				//--------------------
				t1=new JComboBox();
				t1.setSize(200,20);
				t1.setLocation(450,60);
				fetche();
				t1.addActionListener(
						new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								       AId=t1.getSelectedItem().toString();
								       
								
								       if(fetchGetOne(AId)==false)
										 {
											   JOptionPane.showMessageDialog(null,"the id with name "+AId+" does not exist");
										 }
					 			
							}
							 					
						}
						);
				p2.add(t1);
                //--------------------------
				b1=new Button("Save");
			       b1.setSize(100, 20);
			       b1.setLocation(40,50);
			       b1.addActionListener
			           (
			    		   new ActionListener()
			    		   {
			    			public void actionPerformed(ActionEvent ev)
			    			   {
			    				    //AId=t1.getSelectedItem().toString();
			    				    AId=t2.getText();
			    				    Aname=t7.getText();
			    				    address=t3.getText();
			    				    city=t4.getText();
			    				    mobile=t5.getText();
			    				    email=t6.getText();
			    				 if(fetchOne(AId)==false)
			    				 {
			    					 doSave();     		    
			    					 //JOptionPane.showMessageDialog(null,AId+"  not already authenticated!");
			    				 }
			    				 else
			    					 JOptionPane.showMessageDialog(null,AId+" already authenticated!");
			    					 
			    			   }
			    		   }
			    	  );       
			       p3.add(b1);
			       
			       //------------------
			     
			       b2=new Button("Update");
			       b2.setSize(100, 20);
			       b2.setLocation(40,150);
			       p3.add(b2);
			       b2.addActionListener
			       (
					   new ActionListener()
					   {
						public void actionPerformed(ActionEvent ev)
						   {
							 //AId=t1.getSelectedItem().toString();
		    				    AId=t2.getText();
        						Aname=t7.getText();
		    				    address=t3.getText();
		    				    city=t4.getText();
		    				    mobile=t5.getText();
		    				    email=t6.getText();
							 
							    if(fetchOne(AId)==false)
						     	 {
								   JOptionPane.showMessageDialog(null,AId+" is not authenticated user");
							     }
							    else
								   doUpdate();     		  
						   }
					   }
				  );       
			       //------------------
			 b3=new Button("Delete");
			       b3.setSize(100, 20);
			       b3.setLocation(40,250);
			       b3.addActionListener
			       (
					   new ActionListener()
					   {
						public void actionPerformed(ActionEvent ev)
						   {
							//AId=t1.getSelectedItem().toString();
						    AId=t2.getText();
							Aname=t7.getText();
	    				    address=t3.getText();
	    				    city=t4.getText();
	    				    mobile=t5.getText();
	    				    email=t6.getText();							 
							    if(fetchOne(AId)==false)
						     	 {
								   JOptionPane.showMessageDialog(null,AId+" is not authenticated user");
							     }
							    else
								   doDelete();     		  
						   }
					   }
				  );
			       p3.add(b3);
			       //------------------
			       b4=new Button("new");
			       b4.setSize(100, 20);
			       b4.setLocation(40,350);
			       b4.addActionListener
			       (
					   new ActionListener()
					   {
						public void actionPerformed(ActionEvent ev)
						   {
							t1.setSelectedIndex(0);     		  
							t2.setText("");     		  
							t3.setText("");     		  
							t4.setText("");     		  
							t5.setText("");     		  
							t6.setText("");     		  
							t7.setText("");     		  
						   }
					   }
				  );       
			       p3.add(b4);
			       
			       //------------------
			       b6=new Button("Exit");
			       b6.setSize(100, 20);
			       b6.setLocation(40,450);
			       b6.addActionListener
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
			       p3.add(b6);
			       //------------------
			       
			   	}
      boolean fetchOne(String AId)
 	    {
 		  try{
 			pst=(PreparedStatement)con.prepareStatement("SELECT * FROM agents where AId=?");
 	         pst.setString(1,AId);
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
      boolean fetchGetOne(String AId)
  	{
  		try{
  			pst=(PreparedStatement)con.prepareStatement("select * from agents where AId=?");
  	         pst.setString(1,AId);
  	        ResultSet rs=pst.executeQuery();
  	        flag=false; 
  	        while(rs.next())
  	         {
  	        	  flag=true;
  	        	  t2.setText(rs.getString("AId"));
  	        	  t7.setText(rs.getString("AName"));
  	        	  t3.setText(rs.getString("Address"));
  	        	  t4.setText(rs.getString("City"));
  	        	  t5.setText(rs.getString("Mobile"));
   	        	  t6.setText(rs.getString("EmailId"));

  	         }
  		  }
  		catch(Exception e){e.printStackTrace();}
  	   return flag;
  	}
  	void doSave()
  	{
  		try{
  		      pst=(PreparedStatement)con.prepareStatement("Insert into agents values(?,?,?,?,?,?)");  
  	          pst.setString(1,AId);
  	          pst.setString(2,Aname);
  	          pst.setString(3,address);
  	          pst.setString(4,city);
  	          pst.setString(5,mobile);
  	          pst.setString(6,email);
  	          int r=pst.executeUpdate();
  	          if(r==1)
  	        	  JOptionPane.showMessageDialog(null,"agent successfully authenticated");
  	          else
  	        	  JOptionPane.showMessageDialog(null,"sorry user not authenticated");
  		    }
  		 catch(Exception e){e.printStackTrace();}

  	}
  	void doUpdate()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("Update agents set AName=?,Address=?,City=?,Mobile=?,EmailId=? where AId=?"); 
	          pst.setString(6,AId);
	          pst.setString(1,Aname);
	          pst.setString(2,address);
	          pst.setString(3,city);
	          pst.setString(4,mobile);
	          pst.setString(5,email);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"User form updated");
	          else
	        	  JOptionPane.showMessageDialog(null,"invalid user id");
		    }
		 catch(Exception e){e.printStackTrace();}

	}
	void doDelete()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("delete from agents where AId=?"); 
	          pst.setString(1,AId);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"User is removed");
	          else
	        	  JOptionPane.showMessageDialog(null,"invalid user id");
		    }
		 catch(Exception e){e.printStackTrace();}

	}
	void fetche()
	{

		 try{
	 			pst=(PreparedStatement)con.prepareStatement("select AId from agents");
	 	         
	 	        ResultSet rs=pst.executeQuery();
	 	         
	 	        while(rs.next())
	 	         {
	 	        	 
	 	        	  t1.addItem(rs.getString("AId"));
	 	        	 
	 	         }
	 		  }
	 		catch(Exception e){e.printStackTrace();}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
public class Agent extends AgentAdmin {

	public static void main(String[] args) {
               new AgentAdmin();

	}

}
