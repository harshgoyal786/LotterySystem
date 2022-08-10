import javax.swing.*;


import java.awt.*;
//import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mysql.jdbc.*;
class project extends JFrame implements ActionListener 
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
	ImageIcon ico;
	//String s[];
	ArrayList<String> v=new ArrayList<String>();
	String []sqq={"what are your hobbies","what is ur school name","what is your father's occupation","what is ur college name"};
	project()
	 {
		 
		setUndecorated(true);
			getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
		try{
		     Class.forName("com.mysql.jdbc.Driver");
		     con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/project","root","sanjeev");
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
		l4=new JLabel("ADD USERS");
		l4.setSize(150,40);
		l4.setLocation(500,40);
		l4.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
		c.add(l4);
     	
		//------------------------
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createTitledBorder("Authentication form"));
     	p2.setBounds(200,100, 800, 300);
		c.add(p2);
		
		//--------------------------------
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createTitledBorder("Choose"));
     	p3.setBounds(200,450, 800, 200);
		c.add(p3);
     	setSize(800,800);
		setVisible(true);
		c.setBackground(Color.gray);		p3.setBackground(Color.LIGHT_GRAY);		p2.setBackground(Color.LIGHT_GRAY);
		//----------------------
		l1=new JLabel("User ID");
		l1.setSize(100,40);
		l1.setLocation(40,40);
		p2.add(l1);
		//-------------------
		l1=new JLabel("Pasword");
		l1.setSize(100,40);
		l1.setLocation(40,80);
		p2.add(l1);
		//-------------------
		l1=new JLabel("Security Question");
		l1.setSize(110,40);
		l1.setLocation(40,128);
		p2.add(l1);
		//-------------------
		l1=new JLabel("Answer");
		l1.setSize(100,40);
		l1.setLocation(40,176);
		p2.add(l1);
		//-------------------
		l1=new JLabel("Date Of Joining");
		l1.setSize(100,40);
		l1.setLocation(40,226);
		p2.add(l1);
		//-------------------
		t1=new JTextField();
		t1.setSize(200,20);
		t1.setLocation(200,50);
		p2.add(t1);
		//--------------------
		t2=new JPasswordField();
		t2.setSize(200,20);
		t2.setLocation(200,90);
		p2.add(t2);
		//--------------------
		t3=new JTextField();
		t3.setSize(200,20);
		t3.setLocation(200,140);
		p2.add(t3);
		//--------------------
		t4=new JTextField();
		t4.setSize(200,20);
		t4.setLocation(200,190);
		p2.add(t4);
		//--------------------
		t5=new JTextField();
		t5.setSize(200,20);
		t5.setLocation(200,240);
		p2.add(t5);
		//--------------------
 		j=new JComboBox();
		j.setSize(150,20);
		j.setLocation(500,50);
		fetchoneeee();
		j.addActionListener(
				new ActionListener()
				{
					  public void actionPerformed(ActionEvent ev)
					    {
						      int indx= j.getSelectedIndex();
						      uid=v.get(indx);
						      
						      if(fetchGetOne(uid)==false)
								 {
									   JOptionPane.showMessageDialog(null,"the id with name"+uid+"does not exist");
								 }
					    }
				}
				);
		p2.add(j);
		
		//----------------------------------
		k=new JComboBox(sqq);
		k.setSize(150,20);
		k.setLocation(500,140);
		k.addActionListener(
				new ActionListener()
				{
					  public void actionPerformed(ActionEvent ev)
					    {
						  int indx=k.getSelectedIndex();
			              t3.setText(sqq[indx]);			    
					    }
				}
			);
		p2.add(k);
		
		//----------------------------------
       b1=new Button("Save");
       b1.setSize(100, 20);
       b1.setLocation(40,40);
       b1.addActionListener
           (
    		   new ActionListener()
    		   {
    			public void actionPerformed(ActionEvent ev)
    			   {
    				    uid=t1.getText();
    				    char []pw=t2.getPassword();
    				    pwd=new String(pw);
    				    sq=t3.getText();
    				    ans=t4.getText();
    				    doj=t5.getText();
    				 if(fetchOne(uid)==true)
    				 {
    					   JOptionPane.showMessageDialog(null,uid+" already authenticated!");
    				 }
    				 else
    					 doSave();     		  
    			   }
    		   }
    	  );       
       p3.add(b1);
       y=new Button(" Goto Lottery");
       y.setSize(100, 20);
       y.setLocation(1100,580);
       y.addActionListener
           (
    		   new ActionListener()
    		   {
    			public void actionPerformed(ActionEvent ev)
    			   {
    				lotterysystem lss=new lotterysystem();
    			   }
    		   }
    	  );       
       c.add(y);
       y.setBackground(Color.white);	
       //--------------------------
       
       
       //------------------
       b7=new Button("All Users");
       b7.setSize(100, 20);
       b7.setLocation(1100,250);
       b7.addActionListener
           (
    		   new ActionListener()
    		   {
    			public void actionPerformed(ActionEvent ev)
    			   {
    				userauth sss=new userauth();		  
    			   }
    		   }
    	  );       
       c.add(b7);  b7.setBackground(Color.white);
      
       //----------------
       b8=new Button("All Users");
       b8.setSize(100, 20);
       b8.setLocation(1100,250);
       b8.addActionListener
           (
    		   new ActionListener()
    		   {
    			public void actionPerformed(ActionEvent ev)
    			   {
    				lotterysystem ls=new lotterysystem();		  
    			   }
    		   }
    	  );       
       c.add(b8);
       //----------------
       b2=new Button("Update");
       b2.setSize(100, 20);
       b2.setLocation(250,40);
       p3.add(b2);	
       b2.addActionListener
       (
		   new ActionListener()
		   {
			public void actionPerformed(ActionEvent ev)
			   {
				    uid=t1.getText();
				    char []pw=t2.getPassword();
				    pwd=new String(pw);
				    sq=t3.getText();
				    ans=t4.getText();
				    doj=t5.getText();
				 
				    if(fetchOne(uid)==false)
			     	 {
					   JOptionPane.showMessageDialog(null,uid+" is not authenticated user");
				     }
				    else
					   doUpdate();     		  
			   }
		   }
	  );       
       //------------------
 b3=new Button("Delete");
       b3.setSize(100, 20);
       b3.setLocation(450,40);
       b3.addActionListener
       (
		   new ActionListener()
		   {
			public void actionPerformed(ActionEvent ev)
			   {
				    uid=t1.getText();
				    char []pw=t2.getPassword();
				    pwd=new String(pw);
				    sq=t3.getText();
				    ans=t4.getText();
				    doj=t5.getText();
				 
				    if(fetchOne(uid)==false)
			     	 {
					   JOptionPane.showMessageDialog(null,uid+" is not authenticated user");
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
       b4.setLocation(40,100);
       b4.addActionListener
       (
		   new ActionListener()
		   {
			public void actionPerformed(ActionEvent ev)
			   {
				t1.setText("");     		  
				t2.setText("");     		  
				t3.setText("");     		  
				t4.setText("");     		  
				t5.setText("");     		  
			   }
		   }
	  );       
       p3.add(b4);
       
       //------------------
       b5=new Button("Search");
       b5.setSize(100, 20);
       b5.setLocation(250,100);
       b5.addActionListener
       (
		   new ActionListener()
		   {
			public void actionPerformed(ActionEvent ev)
			   {
				    uid=t1.getText();
				    char []pw=t2.getPassword();
				    pwd=new String(pw);
				    sq=t3.getText();
				    ans=t4.getText();
				    doj=t5.getText();
				 if(fetchGetOne(uid)==false)
				 {
					   JOptionPane.showMessageDialog(null,"the id with name"+uid+"does not exist");
				 }
		     		  
			   }
		   }
	  );       
       p3.add(b5);
       //------------------
       b6=new Button("Exit");
       b6.setSize(100, 20);
       b6.setLocation(450,100);
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
	boolean fetchOne(String uid)
	{
		try{
			pst=(PreparedStatement)con.prepareStatement("select * from users where UID=?");
	         pst.setString(1,uid);
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
	boolean fetchGetOne(String uid)
	{
		try{
			pst=(PreparedStatement)con.prepareStatement("select * from users where UID=?");
	         pst.setString(1,uid);
	        ResultSet rs=pst.executeQuery();
	        flag=false; 
	        while(rs.next())
	         {
	        	  flag=true;
	        	  t1.setText(rs.getString("UID"));
	        	  t2.setText(rs.getString("PWD"));
	        	  t3.setText(rs.getString("SQ"));
	        	  t4.setText(rs.getString("ANS"));
	        	  t5.setText(rs.getString("DOJ"));
	         }
		  }
		catch(Exception e){e.printStackTrace();}
	   return flag;
	}

	void doSave()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("insert into users values(?,?,?,?,?)");  
	          pst.setString(1,uid);
	          pst.setString(2,pwd);
	          pst.setString(3,sq);
	          pst.setString(4,ans);
	          pst.setString(5,doj);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"User successfully authenticated");
	          else
	        	  JOptionPane.showMessageDialog(null,"sorry user not authenticated");
		    }
		 catch(Exception e){e.printStackTrace();}

	}
	void doUpdate()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("Update users set PWD=?,SQ=?,ANS=?,DOJ=? where UID=?"); 
	          pst.setString(5,uid);
	          pst.setString(1,pwd);
	          pst.setString(2,sq);
	          pst.setString(3,ans);
	          pst.setString(4,doj);
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
		      pst=(PreparedStatement)con.prepareStatement("delete from users where UID=?"); 
	          pst.setString(1,uid);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"User is removed");
	          else
	        	  JOptionPane.showMessageDialog(null,"invalid user id");
		    }
		 catch(Exception e){e.printStackTrace();}

	}
	public void actionPerformed(ActionEvent evv){}
	//--------------------------------------------
	void fetchoneeee()
	{
		  try{
			  pst=(PreparedStatement)con.prepareStatement("select UID from users"); 
			  ResultSet rs=pst.executeQuery();
			 
		      while(rs.next())
		      {
		    	 // System.out.println(rs.getString("UID"));
		    	  j.addItem(rs.getString("UID"));
		    	  v.add(rs.getString("UID"));
		      }
		  }
		  catch(Exception e){e.printStackTrace();}

	}
}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
class loginn extends JFrame implements ActionListener
{
	 JLabel uid,pwd;
	 JPanel f1,f2;
	 JTextField s1;
    JPasswordField s2;
	 Button b,g,l,y;
	 String v1,v2;
	 Connection con; 
	 PreparedStatement pst;
	 boolean flag;
	 loginn()
	  {
		 setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		 try{
		     Class.forName("com.mysql.jdbc.Driver");
		     con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/project","root","sanjeev");
	        // JOptionPane.showMessageDialog(null,"Sanjeev welcomes you..");
		}
		catch(Exception exp){exp.printStackTrace();}
		
			Container c=getContentPane();
		
		    c.setLayout(null);
	    	f1=new JPanel();
	    	f1.setLayout(null);
	    	c.add(f1); 		
	    	//------------------
	    	f2=new JPanel();
			f2.setLayout(null);
			f2.setBorder(BorderFactory.createTitledBorder("Login form"));
	     	f2.setBounds(200,100, 800, 400);
			c.add(f2);
			//------------------
			uid=new JLabel("User ID");
	    	uid.setSize(100,20);
	    	uid.setLocation(40,45);
	    	f2.add(uid);
	   	//--------------------------
	    	pwd=new JLabel("Password");
	    	pwd.setSize(100,20);
	    	pwd.setLocation(40,160);
	    	f2.add(pwd);
	    	//----------------------
	    	s1=new JTextField();
			s1.setSize(300,20);
			s1.setLocation(150,40);
			f2.add(s1);
			//--------------------
			c.setBackground(Color.GRAY);		f1.setBackground(Color.cyan);		f2.setBackground(Color.lightGray);
			s2=new JPasswordField();
			s2.setSize(300,20);
			s2.setLocation(150,160);
			f2.add(s2);
			//--------------------
		/*	l=new Button(" ADD USERS");
		       l.setSize(100, 20);
		       l.setLocation(1100,550);
		       l.addActionListener
		           (
		    		   new ActionListener()
		    		   {
		    			public void actionPerformed(ActionEvent ev)
		    			   {
		    				char []pass=s2.getPassword();
					            String spass=new String(pass);
					          if((s1.getText()).equals("ADMIN") && spass.equals("ADMIN"))
				           {  project p=new  project();
				           }
					          else
					          {}  		  
		    			   }
		    		   }
		    	  );       
		       c.add(l);*/
		//-------------------------
		      
	    	b=new Button("Log In");
	    	b.setSize(100, 40);
	        b.setLocation(400,250);
	       b.addActionListener
	            (
	     		   new ActionListener()
	     		   {
	     			public void actionPerformed(ActionEvent ev)
	     			   {
	     				    v1=s1.getText();
	     				    char []pw=s2.getPassword();
	     				    v2=new String(pw);
	     				    
	     				 if(fetchGetOne(v1)==true)
	     				    {
	     					  if(fetchGetOnee(v2)==true)
	     				 
	     				         {
	     					       JOptionPane.showMessageDialog(null,v1+" successfully logged in");
	     					            char []pass=s2.getPassword();
	     					            String spass=new String(pass);
	     					           String aa=s1.getText();
	     					         // System.out.println(aa); 
	     					         //System.out.println(spass); 
	     					         if(aa.equals("ADMIN"))
	     					        	  {
	     					        	   if(spass.equals("ADMIN"))
		    				                 { 
	     					        		   new  project();
		    				                 }	
	     					        	  } 
	     					          else
	     					          {
	     					        	 lotterysystem sll=new lotterysystem();
	     					          }
	     				         } 
	     					 else
	     					 {
		     					 JOptionPane.showMessageDialog(null,"user id or password is wrong"); 
	     					 } 
	     				    }
	     				 else
	     					 JOptionPane.showMessageDialog(null,"user id or password is wrong");
	     			   }
	     		   }
	     	  );       
	        f2.add(b);
//---------------------------
	        g=new Button("Forgot Password");
	    	g.setSize(100, 40);
	        g.setLocation(600,250);
	       g.addActionListener
	            (
	     		   new ActionListener()
	     		   {
	     			public void actionPerformed(ActionEvent ev)
	     			   {
	     				new forgotpassworod();	   
	     		   }}
	     	  );       
	        f2.add(g);
//---------------------------
	        
			setSize(500,500);
	    	setVisible(true);
	  }
		//catch(Exception e){e.printStackTrace();}
	 boolean fetchGetOne(String uid)
		{
			try{
				pst=(PreparedStatement)con.prepareStatement("select * from users where UID=?");
		         pst.setString(1,uid);
		         //pst.setString(2,pwd);
       	        ResultSet rs=pst.executeQuery();
		        flag=false; 
		        while(rs.next())
		         {
		        	  flag=true;
		        	  //s1.setText(rs.getString("UID"));
		        	  //s2.setText(rs.getString("PWD"));
		        	  /*t3.setText(rs.getString("SQ"));
		        	  t4.setText(rs.getString("ANS"));
		        	  t5.setText(rs.getString("DOJ"));*/
		         }
			  }
			catch(Exception e){e.printStackTrace();}
		   return flag;
		}

	 boolean fetchGetOnee(String pwd)
		{
			try{
				pst=(PreparedStatement)con.prepareStatement("select * from users where PWD=?");
		         //pst.setString(1,uid);
		         pst.setString(1,pwd);
    	        ResultSet rs=pst.executeQuery();
		        flag=false; 
		        while(rs.next())
		         {
		        	  flag=true;
		        	  //s1.setText(rs.getString("UID"));
		        	  //s2.setText(rs.getString("PWD"));
		        	  /*t3.setText(rs.getString("SQ"));
		        	  t4.setText(rs.getString("ANS"));
		        	  t5.setText(rs.getString("DOJ"));*/
		         }
			  }
			catch(Exception e){e.printStackTrace();}
		   return flag;
		}



	 public void actionPerformed(ActionEvent ev)
	 {}
}
class forgotpassworod extends JFrame 
{
	JLabel uid,sq,ans,pwd;
	 JPanel f1,f2,f3;
	 JTextField s1,s2,s3,s4;
   
	 Button b,g;
	 String v1,v2,v3,v4;
	 Connection con; 
	 PreparedStatement pst;
	 boolean flag;
     forgotpassworod()
	  {
		 try{
		     Class.forName("com.mysql.jdbc.Driver");
		     con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/project","root","sanjeev");
	         System.out.println("connected........");
		     //JOptionPane.showMessageDialog(null,"Sanjeev welcomes you..");
		}
		catch(Exception exp){exp.printStackTrace();}
		
		 Container c=getContentPane();
		    c.setLayout(null);
	    	f1=new JPanel();
	    	f1.setLayout(null);
	    	c.add(f1); 		
	    	//------------------
	    	f3=new JPanel();
			f3.setLayout(null);
			f3.setBorder(BorderFactory.createTitledBorder("Trouble Logging IN"));
	     	f3.setBounds(200,500, 800, 200);
			c.add(f3);
			//---------------------
	    	f2=new JPanel();
			f2.setLayout(null);
			f2.setBorder(BorderFactory.createTitledBorder("Login form"));
	     	f2.setBounds(200,100, 800, 400);
			c.add(f2);
			//------------------
			uid=new JLabel("User ID");
	    	uid.setSize(100,20);
	    	uid.setLocation(40,45);
	    	f2.add(uid);
	   	//--------------------------
	      	sq=new JLabel("Security Question");
	    	sq.setSize(120,20);
	    	sq.setLocation(40,160);
	    	f2.add(sq);
	    	//----------------------
	    	ans=new JLabel("Answer");
	    	ans.setSize(100,20);
	    	ans.setLocation(40,290);
	    	f2.add(ans);
	    	//----------------------

	    	s1=new JTextField();
			s1.setSize(300,20);
			s1.setLocation(200,40);
			f2.add(s1);
			//--------------------
			s2=new JTextField();
			s2.setSize(300,20);
			s2.setLocation(200,150);
			f2.add(s2);
			//--------------------
			s3=new JTextField();
			s3.setSize(300,20);
			s3.setLocation(200,280);
			f2.add(s3);
			//--------------------
			pwd=new JLabel("Password");
	    	pwd.setSize(100,20);
	    	pwd.setLocation(40,40);
	    	f3.add(pwd);
	    	//----------------------
	    	s4=new JTextField();
			s4.setSize(300,20);
			s4.setLocation(150,40);
			f3.add(s4);
			//------------------
			c.setBackground(Color.gray);		f3.setBackground(Color.LIGHT_GRAY);		f2.setBackground(Color.lightGray);
			 b=new Button("OK");
		     b.setSize(70, 40);
		     b.setLocation(500,350);
		     b.addActionListener
	            (
	     		   new ActionListener()
	     		   {
	     			public void actionPerformed(ActionEvent ev)
	     			   {
	     			           v1=s1.getText();	
	     			           v2=s2.getText();	
	     			           v3=s3.getText();
	     			           if(fetchGetOneee(v1,v2,v3)==false)
	     			        	   JOptionPane.showMessageDialog(null,"Sorry ths id does not exist");
	     			   }
	     		   }
	     				   
	     	  );       

		     f2.add(b);
		     //-----------------
		     g=new Button("Cancel");
		     g.setSize(70, 40);
		     g.setLocation(600,350);
		     g.addActionListener
	            (
	     		   new ActionListener()
	     		   {
	     			public void actionPerformed(ActionEvent ev)
	     			   {
                          JOptionPane.showConfirmDialog(null,"do u want to exit","warning",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
	     			   }
	     		   }
	     	  );       

		     f2.add(g);
			setSize(500,500);
	    	setVisible(true);

}

     boolean fetchGetOneee(String uid,String sq,String ans)
		{
			try{
				pst=(PreparedStatement)con.prepareStatement("select * from users where UID=?,SQ=?,ANS=?");
		         pst.setString(1,uid);
		         pst.setString(2,sq);
		         pst.setString(3,ans);		         
		    
    	        ResultSet rs=pst.executeQuery();
		        flag=false; 
		        while(rs.next())
		         {
		        	  flag=true;
		        	  s4.setText(rs.getString("PWD"));
		    }
			  }
			catch(Exception e){e.printStackTrace();}
		   return flag;
		}
     }	

public class authentication extends loginn {

	public static void main(String[] args) {
		//new project();
		new loginn();
     
	}

}
