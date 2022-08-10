
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.table.*;
class sshowInTabble extends JFrame
{	
Connection con;
PreparedStatement pstmt;
ResultSet rs;
	sshowInTabble()
	{setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Lottery","root","sanjeev");
		 fillTable();
		}
		catch(Exception ex){ex.printStackTrace();}
		
	}
   void fillTable() throws Exception
      {	   
	   String sql = "Select * from winners";
	    pstmt = con.prepareStatement(sql);
	    rs = pstmt.executeQuery();
	   ResultSetMetaData md = rs.getMetaData();
	   
	   Vector columnNames = new Vector();
	   Vector data = new Vector();

	   int columns = md.getColumnCount();
	   for (int i = 1; i <= columns; i++) {
	   columnNames.addElement( md.getColumnName(i) );
	   }
	   while (rs.next())
	   {
	   Vector row = new Vector(columns);
	   for (int i = 1; i <= columns; i++){
	   row.addElement( rs.getObject(i) );
	   }
	   data.addElement( row );
	   }
	   rs.close();
	   pstmt.close();
	   
	   
	   JTable table = new JTable(data, columnNames);
	
	   JScrollPane scrollPane = new JScrollPane( table );
	   table.setBackground(Color.GREEN);
	   table.setSelectionBackground(Color.red);
	  
	   Container c=getContentPane();
	  // c.setLayout(null);
	   JPanel pnl=new JPanel();
	   pnl.setLayout(null);
	   
	   c.add(pnl);
	//   c.setBackground(Color.DARK_GRAY);
	   pnl.add( scrollPane );
	   
	   scrollPane.setBounds(100, 200, 800, 300);
	   setSize(600,400);
	   setVisible(true);
	  JLabel l1=new JLabel("WINNERS");
		l1.setSize(200,40);
		l1.setLocation(500,40);
		l1.setFont(new Font("Arial",Font.HANGING_BASELINE,15));
		//c.add(l1);
		//-------------------
      }
}

public class winners extends sshowInTabble
{
	public static void main(String args[])
{
	new sshowInTabble();
}
}

  

