package Chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Functions {

	   public static Vector<String>  getValues(String value,String mid) throws SQLException
	   {
		   Vector<String> vector=new Vector<>();
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","rat");
		   String query="select e.username from "+value+" e join "+value+" m on e.manager_id=m.employee_id where e.post='employee' and m.employee_id =? ";
		   try
		   {
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setString(1, mid);
			  ResultSet res=ps.executeQuery();
			  while(res.next())
			  {
				  vector.add(res.getString(1));
			  }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   
		   return vector;
		   
		   
		   
	   }
	   public void DisplayJTable(JTable table,String tab) 
	   {
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","rat");
			String query1="select * from "+tab+" ";
			   PreparedStatement ps=conn.prepareStatement(query1);
			   ResultSet res=ps.executeQuery();
			   DefaultTableModel model=(DefaultTableModel)table.getModel();
				Object[] row;
			   while(res.next()) 
			   {
				   	row= new Object[16];
				   	row[0]=res.getString(1);
					row[1]=res.getString(2);
					row[2]=res.getString(3);
					row[3]=res.getString(4);
					row[4]=res.getString(5);
					row[5]=res.getString(6);
					row[6]=res.getString(7);
					row[7]=res.getString(8);
					row[8]=res.getString(9);
					row[9]=res.getString(10);
					row[10]=res.getString(11);
					row[11]=res.getString(12);
					row[12]=res.getString(13);
					row[13]=res.getString(14);
					row[14]=res.getString(15);
					row[15]=res.getString(16);
					model.addRow(row);}
			   
			   ps.close();conn.close();
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	   }
}
