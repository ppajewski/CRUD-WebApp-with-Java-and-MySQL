package miloslaw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        try {
        	//Get a connection to database
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "sa", "5004ppdp");
			Statement myStmt = myConn.createStatement();
			String sql = "delete from employees where id='"+id+"'";
			myStmt.executeUpdate(sql);
			
			
			response.sendRedirect(request.getContextPath()); 
			
			
			
			
			
        
        }catch(Exception exc){
        	exc.printStackTrace();
        }  
    }  
}  
