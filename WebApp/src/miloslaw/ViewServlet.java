package miloslaw;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html><body>");
		
		
		try {
			//Get a connection to database
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "sa", "5004ppdp");
			//Create statement
			Statement myStmt = myConn.createStatement();
			//Execute sql query
			ResultSet rs = myStmt.executeQuery("select * from employees");
			//Process the result set
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>Id</th><th>Last Name</th><th>First name</th><th>Email</th><th>Delete</th></tr>");
			while (rs.next()) {
				String n = rs.getString("id");
				String ln = rs.getString("last_name");
				String fn = rs.getString("first_name");
				String em = rs.getString("email");
				out.println("<tr><td>" + n + "</td><td>" + ln + "</td><td>" + fn + "</td><td>" + em + "</td><td><a href='DeleteServlet?id="+n+"'>delete</a></td></tr>");
			}
		out.println("</table>");
		out.println("<a href='addForm.html'>Add employee</a><br/>");
		out.println("</html></body>");
		myConn.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
