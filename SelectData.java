package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SelectData")
public class SelectData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SelectData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			
		out.println("<!DOCTYPE html>");
		out.println("<h1>List of Mobile Details</h1>");
		out.println("<body style=background-color:orange;>");
		
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jeevi","root",
					"gvdesh");
			String sql="select * from jeevi";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			out.println("<table border='3'>");
			while(rs.next()){
				out.println("<tr> <td>" +rs.getString(1)+ "</td> <td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td> <td>"+rs.getFloat(4)+"</td> <td>"+rs.getString(5)+ "</td> <tr>");
					}
			out.println("</table>");
			con.close();
		}catch(Exception e){
			out.println("Error "+e);
		}
		
		out.println("</html>");
		
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
