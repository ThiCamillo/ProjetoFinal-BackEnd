package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class Banco {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // MYSQL versão 8
	// private static final String DRIVER = "com.mysql.jdbc.Driver"; //MYSQL versão
	// 5
	private static final String BANCODADOS = "dbteste";
	private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + BANCODADOS
			+ "?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	public static Connection getConnection() {
		try {
			Connection conn = null;
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONEXAO, USER, PASSWORD);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver não foi encontrada.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
	
	
//	private static final String NAME_DATASOURCE = "SenacDS";
//	
//	public static Connection getConnection(){
//		try {
//			Context initContext = new InitialContext();
//			Context envContext = (Context) initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource) envContext.lookup(NAME_DATASOURCE);
//			Connection conn = ds.getConnection();
//			return conn; 
//		} catch (Exception e) {
//			System.out.println("Erro ao obter a Connection.");
//			System.out.println("Erro: " + e.getMessage());
//			return null;
//		}
//	}

	
	//private static final String Driver = "com.mysql.cj.jdbc.Driver";
	
	public static void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexão.");
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public static Statement getStatement(Connection conn){
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
		
	public static void closeStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement.");
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public static PreparedStatement getPreparedStatement(Connection conn, String sql){
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
	
	public static PreparedStatement getPreparedStatementWithPk(Connection conn, String sql){
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}

	public static void closePreparedStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement.");
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public static void closeResultSet(ResultSet result){
		try {
			if(result != null){
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
