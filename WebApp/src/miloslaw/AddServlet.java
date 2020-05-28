package miloslaw;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String lname = req.getParameter("lname");
		String fname = req.getParameter("fname");
		String email = req.getParameter("email");	
		
		
		
		try {
			//Get a connection to database
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "sa", "5004ppdp");
			
			Statement myStmt = myConn.createStatement();
			
			String sql = "insert into employees " + " (last_name, first_name, email)" + "values ('"+lname+"', '"+fname+"', '"+email+"')";
			
			myStmt.executeUpdate(sql);
			
			myConn.close();
			
			res.sendRedirect(req.getContextPath());  
		
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
	}
	
	
      
}




