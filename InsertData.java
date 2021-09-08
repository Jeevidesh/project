package com.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jeevi","root",
					"gvdesh");
			
			String sql="insert into jeevi values (?,?,?,?,?)";
			String mname=request.getParameter("mname");
			int mid=Integer.parseInt(request.getParameter("mid"));
			String mcity=request.getParameter("mcity");
			float mprice=Float.parseFloat(request.getParameter("mprice"));
			String mcolor=request.getParameter("mcolor");
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setInt(2, mid);
			ps.setString(3, mcity);
			ps.setFloat(4, mprice);
			ps.setString(5, mcolor);
			ps.executeUpdate();
			
			
			con.close();
			response.sendRedirect("index.html");
		}catch(Exception e){
			out.println("Error occured : " +e);
		}
			
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
