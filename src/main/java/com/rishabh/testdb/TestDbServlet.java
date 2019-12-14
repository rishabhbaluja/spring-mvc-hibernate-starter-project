package com.rishabh.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDb")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "springStudent";
		String password = "springStudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		try{
			PrintWriter out = response.getWriter();
			out.println("Connecting to database" + jdbcUrl);
			Class.forName(driver); 
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			out.println("Connection Successfull !!");
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
