
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.table.*;
class sTable extends JFrame
{	
Connection con;
PreparedStatement pstmt;
ResultSet rs;
	sTable()
	{ setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","sanjeev");
		 fillTable();
		}
		catch(Exception ex){ex.printStackTrace();}
		
	}
   void fillTable() throws Exception
      {	   
	    String sql = "Select * from users";
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
	   table.setBackground(Color.YELLOW);
	   table.setSelectionBackground(Color.red);
	  
	   Container c=getContentPane();
	   JPanel pnl=new JPanel();
	   pnl.setLayout(null);
	   
	   c.add(pnl);
	   
	   pnl.add( scrollPane );
	   
	   scrollPane.setBounds(100, 100, 800, 200);
	   setSize(600,400);
	   setVisible(true);
      }
}

public class userauth extends sTable
{
	public static void main(String args[])
{
	new sTable();
}
}

  

