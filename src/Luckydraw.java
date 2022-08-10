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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.*;
class draw extends JFrame implements  ActionListener
{
	Connection con; 
	Button b1,b2,b3,b4,b5,b6,l;
	JPasswordField t2;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JPanel p1,p2,p3;
	JTextField t1,t3,t4,t5;
	int position,no;
	PreparedStatement pst;
	boolean flag;
	JComboBox j,k;
	String lotteryno;
	String a,b,ccc,d,e,f,g; 
	ArrayList<String> ln=new ArrayList<String>();
	Vector v=new Vector();
	draw()
   {
		setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
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
		l4=new JLabel("LUCKY DRAW");
		l4.setSize(150,40);
		l4.setLocation(500,40);
		l4.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
		c.add(l4);
     	//------------------------
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createTitledBorder("CHOOSE POSITION"));
     	p2.setBounds(200,100, 800, 300);
		c.add(p2);
		
		//--------------------------------
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createTitledBorder("RESULT"));
     	p3.setBounds(200,450, 800, 200);
		c.add(p3);
		//---------------------------------
     	setSize(800,800);
		setVisible(true);
		//-------------------------------
		l1=new JLabel("Position");
		l1.setSize(100,40);
		l1.setLocation(200,40);
		p2.add(l1);
		//-------------------
		l2=new JLabel("No Of Prizes");
		l2.setSize(100,40);
		l2.setLocation(200,150);
		p2.add(l2);
		//-------------------
		j=new JComboBox();
		j.setSize(250,20);
		j.setLocation(300,50);
		fetche();
		j.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						       position=Integer.parseInt((j.getSelectedItem().toString()));
						       
						
						       if(fetchGetOne(position)==false)
								 {
									   JOptionPane.showMessageDialog(null,"the id with name "+position+" does not exist");
								 }
			 			
					}
					 					
				}
				);
		
		p2.add(j);
		//---------------
		k=new JComboBox();
		k.setSize(250,20);
		k.setLocation(225,80);
		p3.add(k);
		//---------------
		t1=new JTextField();
		t1.setSize(250,20);
		t1.setLocation(300,160);
		p2.add(t1);
	//----------------------------
		 c.setBackground(Color.gray);
	       p2.setBackground(Color.LIGHT_GRAY);
	       p3.setBackground(Color.LIGHT_GRAY);
	       
		fetchee();
		//JOptionPane.showMessageDialog(null,ln.size()+" entries are added");
		b1=new Button("DRAW");
	     b1.setSize(100, 20);
	     b1.setLocation(250,250);
	     b1.addActionListener
	     (
			   new ActionListener()
			   {
				public void actionPerformed(ActionEvent ev)
				   {
					  k.removeAllItems();
					 Collections.shuffle(ln,new Random());
					 int ind=Integer.parseInt(t1.getText());
					 for(int i=0;i<ind;i++)
					{
						 v.add(ln.get(0));
						 k.addItem(ln.get(0));
						 ln.remove(0);
					}
				   }
			   }
		  );       
	     p2.add(b1);
	     //------------------
	     b2=new Button("DUMP DATA");
	     b2.setSize(100, 20);
	     b2.setLocation(500,80);
	     b2.addActionListener
	     (
			   new ActionListener()
			   {
				public void actionPerformed(ActionEvent ev)
				   {
					 
					for(int i=0;i<v.size();i++)
					{
						
						lotteryno=v.get(i).toString();
						 
						 try{
								pst=(PreparedStatement)con.prepareStatement("select * from lottery where LotteryNo=?");
						         pst.setString(1,lotteryno);
						        ResultSet rs=pst.executeQuery();
						        //flag=false; 
						        while(rs.next())
						         {
						        	//flag=true; 
						        	  a=rs.getString("LotteryNo");
						        	  b=rs.getString("AgentId");
						        	  ccc=rs.getString("CustomerName");
						        	  d=rs.getString("CustomerAddress");
						        	  e=rs.getString("City");
						        	  f=rs.getString("Mobile");
						        	  g=rs.getString("EmailId");
						        	 
						         }
						        
							  }
							catch(Exception exp){exp.printStackTrace();}
						
						 try{
						      pst=(PreparedStatement)con.prepareStatement("insert into winners values(?,?,?,?,?,?,?,?)");  
					          pst.setInt(1,position);
					          pst.setString(2,a);
					          pst.setString(3,b);
					          pst.setString(4,ccc);
					          pst.setString(5,d);
					          pst.setString(6,e);
					          pst.setString(7,f);
					          pst.setString(8,g);
					          int r=pst.executeUpdate();
					          if(r==1)
					        	  JOptionPane.showMessageDialog(null,"*************** winner with lottery no "+a+" winner successfully added***********");
					          
						    }
						 catch(Exception eee){eee.printStackTrace();}
					}
					 
				   }
			   }
		  );       
	     p3.add(b2);
	     //------------------

   }

@Override
public void actionPerformed(ActionEvent e) {
	
	
}
boolean fetchGetAgents(String lot)
{
	try{
		pst=(PreparedStatement)con.prepareStatement("select * from lottery where LotteryNo=?");
         pst.setString(1,lot);
        ResultSet rs=pst.executeQuery();
        flag=false; 
        while(rs.next())
         {
        	flag=true; 
        	  ln.add(rs.getString("LotteryNo"));
        	 
         }
        
	  }
	catch(Exception e){e.printStackTrace();}
  return flag;
}
	  

void fetchee()
{
	try{
			pst=(PreparedStatement)con.prepareStatement("select LotteryNo from lottery");
	         //pst.setString(1,);
	        ResultSet rs=pst.executeQuery();
	        //flag=false; 
	        while(rs.next())
	         {
	        	 
	        	  ln.add(rs.getString("LotteryNo"));
	        	 
	         }
	        
		  }
		catch(Exception e){e.printStackTrace();}
}
boolean fetchGetOne(int position)
	{
		try{
			pst=(PreparedStatement)con.prepareStatement("select * from prizes where Positions=?");
	         pst.setInt(1,position);
	        ResultSet rs=pst.executeQuery();
	        flag=false; 
	        while(rs.next())
	         {
	        	  flag=true;
	        	  t1.setText(String.valueOf(rs.getInt("Numbers")));
	        	  

	         }
		  }
		catch(Exception e){e.printStackTrace();}
	   return flag;
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
 	        	 
 	        	  j.addItem(rs.getString("Positions"));
 	        	// t1.setText(String.valueOf(rs.getInt("Numbers")));
 	        	 
 	         }
 		  }
 		catch(Exception e){e.printStackTrace();}
  }


}
public class Luckydraw extends draw {

	public static void main(String[] args) {
         new draw();
 
	}

}


