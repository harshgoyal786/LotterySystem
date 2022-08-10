import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.JRootPane;
import javax.swing.JTextField;
class prize extends JFrame implements ActionListener 
{
	Connection con; 
	JPanel p1,p2,p3;
	JLabel l1,l2,l3,l4;
	Button b1,b2,b3,b4,b5,b6,l;
	JTextField t1;
	JComboBox t2,t3,s;
	int position,no;
	boolean flag;
	PreparedStatement pst;
	String []nop={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
  	String []prizes={"Hyundai Verna","Maruti Suzuki Swift","Hyundai i10","Ogeneral AC","Refrigerator","Washing Machine","Sony LED"};
	String prize;
	prize()
	  {
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		try{
			     Class.forName("com.mysql.jdbc.Driver");
			     con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/Lottery","root","sanjeev");
		         //JOptionPane.showMessageDialog(null,"Connecting..");
			}
			catch(Exception exp){exp.printStackTrace();}
		  Container c=getContentPane();
			c.setLayout(null);
			p1=new JPanel();
			p1.setLayout(null);
			c.add(p1);
			//---------------------------------
			p2=new JPanel();
			p2.setLayout(null);
			p2.setBorder(BorderFactory.createTitledBorder(""));
	     	p2.setBounds(200,100, 800, 400);
			c.add(p2);
			//--------------------------------
			p3=new JPanel();
			p3.setLayout(null);
			p3.setBorder(BorderFactory.createTitledBorder("Choose"));
	     	p3.setBounds(200,550, 800, 150);
			c.add(p3);
			//--------------------------------
			l4=new JLabel("ADD PRIZES");
			l4.setSize(200,40);
			l4.setLocation(500,40);
			l4.setFont(new Font("Arial",Font.HANGING_BASELINE,30));
			c.add(l4);
	     	//------------------------
			l1=new JLabel("Position");
			l1.setSize(100,40);
			l1.setLocation(40,70);
			p2.add(l1);
			//-------------------
			l2=new JLabel("No of Prizes");
			l2.setSize(100,40);
			l2.setLocation(40,165);
			p2.add(l2);
			//-------------------
			l3=new JLabel("Prizes");
			l3.setSize(110,40);
			l3.setLocation(40,265);
			p2.add(l3);
			//--------------------
			t1=new JTextField();
			t1.setSize(200,20);
			t1.setLocation(250,70);
			p2.add(t1);
			//--------------------
			t2=new JComboBox(nop);
			t2.setSize(200,20);
			t2.setLocation(250,170);
			t2.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e) {
						
							
						}
						 					
					}
					);
			p2.add(t2);
			//-------------------
			t3=new JComboBox(prizes);
			t3.setSize(200,20);
			t3.setLocation(250,270);
			t3.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e) {
						          /*    position=Integer.parseInt(t1.getText());
						              if(fetchGetOne(position)==false)
						            	  JOptionPane.showMessageDialog(null,"Invalid position");
							*/
						}
						 					
					}
					);
			p2.add(t3);
			//-------------------
			s=new JComboBox();
			s.setSize(200,20);
			s.setLocation(500,70);
			fetche();
			s.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e) {
							       position=Integer.parseInt(s.getSelectedItem().toString());
							       
							
							       if(fetchGetOne(position)==false)
									 {
										   JOptionPane.showMessageDialog(null,"the id with name "+position+" does not exist");
									 }
				 			
						}
						 					
					}
					);
			p2.add(s);
			//-------------------
			setSize(500,500);
			setVisible(true);
			
			c.setBackground(Color.LIGHT_GRAY);
	 b1=new Button("Save");
     b1.setSize(100, 20);
     b1.setLocation(40,40);
     b1.addActionListener
         (
  		   new ActionListener()
  		   {
  			public void actionPerformed(ActionEvent ev)
  			   {
  				   position=Integer.parseInt(t1.getText());
				   no=Integer.parseInt(t2.getSelectedItem().toString());
				   prize=t3.getSelectedItem().toString();
  				      if(fetchOne(position)==true)
  				 {
  					   JOptionPane.showMessageDialog(null,position+" already authenticated!");
  				 }
  				 else
  					 doSave();     		  
  			   }
  		   }
  	  );       
     p3.add(b1);
     //------------------------------------------------
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
				   position=Integer.parseInt(t1.getText());
				   no=Integer.parseInt(t2.getSelectedItem().toString());
				   prize=t3.getSelectedItem().toString();
				   if(fetchOne(position)==false)
			     	 {
					   JOptionPane.showMessageDialog(null,"Invalid position");
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
				    position=Integer.parseInt(t1.getText());
				    no=Integer.parseInt(t2.getSelectedItem().toString());
				    prize=t3.getSelectedItem().toString();
				    
				    /*if(fetchOne(uid)==false)
			     	 {
					   JOptionPane.showMessageDialog(null,uid+" is not authenticated user");
				     }
				    else*/
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
				t2.setSelectedIndex(0);
				t3.setSelectedIndex(0);
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
				    position=Integer.parseInt(t1.getText());
				    no=Integer.parseInt(t2.getSelectedItem().toString());
				    prize=t3.getSelectedItem().toString();
				    
				    
				 if(fetchGetOne(position)==false)
				 {
					   JOptionPane.showMessageDialog(null,"the id with name "+position+" does not exist");
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
	@Override
	public void actionPerformed(ActionEvent e) {
				
	}
	//------------------------------
	boolean fetchOne(int pos)
	{
		try{
			pst=(PreparedStatement)con.prepareStatement("select * from prizes where Positions=?");
	         pst.setInt(1,pos);
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
	//------------------------
	boolean fetchGetOne(int pos)
	{ 
		try{
			pst=(PreparedStatement)con.prepareStatement("select * from prizes where Positions=?");
	         pst.setInt(1,pos);
	        ResultSet rs=pst.executeQuery();
	        flag=false; 
	        while(rs.next())
	         {
	        	  flag=true;
	        	  t1.setText(String.valueOf(rs.getInt("Positions")));
	        	  t2.setSelectedItem(rs.getString("Numbers"));
	              t3.setSelectedItem(rs.getString("prize"));
	         }
		  }
		catch(Exception e){e.printStackTrace();}
	   return flag;
	}
	void doDelete()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("delete from prizes where Positions=?"); 
	          pst.setInt(1,position);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"User is removed");
	          else
	        	  JOptionPane.showMessageDialog(null,"invalid user id");
		    }
		 catch(Exception e){e.printStackTrace();}

	}

	void doSave()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("insert into prizes values(?,?,?)");  
	          pst.setInt(1,position);
	          pst.setInt(2,no);
	          pst.setString(3,prize);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"prize successfully added");
	          
		    }
		 catch(Exception e){e.printStackTrace();}

	}
	void doUpdate()
	{
		try{
		      pst=(PreparedStatement)con.prepareStatement("Update prizes set Numbers=?,Prize=? where Positions=?"); 
	         pst.setInt(3,position);
	         pst.setInt(1,no);
	         pst.setString(2,prize);
	          int r=pst.executeUpdate();
	          if(r==1)
	        	  JOptionPane.showMessageDialog(null,"User form updated");
	          else
	        	  JOptionPane.showMessageDialog(null,"invalid user id");
		    }
		 catch(Exception e){e.printStackTrace();}

	}
	void fetche()
	{

		 try{
	 			pst=(PreparedStatement)con.prepareStatement("select Positions from prizes");
	 	         //pst.setString(1,);
	 	        ResultSet rs=pst.executeQuery();
	 	        //flag=false; 
	 	        while(rs.next())
	 	         {
	 	        	 
	 	        	  s.addItem(rs.getString("Positions"));
	 	        	 
	 	         }
	 		  }
	 		catch(Exception e){e.printStackTrace();}
	}
	 
}
public class AddPrizes extends prize  {
	public static void main(String[] args) {
		new prize(); 

	}

}
