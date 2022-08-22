package com.zee.zee5app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.zee.zee5app.exceptions.UNableToGenerateIdException;

@Component
public class DBUtils {
	
//	public static void main(String[] args) {
//		DBUtils dbUtils = DBUtils.getInstance();
//		Properties properties =  dbUtils.loadPropeerties();
//		System.out.println(properties);
//	}
	

//	private DBUtils() {
//		// TODO Auto-generated constructor stub
//	}
//
//	private static DBUtils dbUtils;
//
//	public static DBUtils getInstance() {
//		// userRepo object
//
//		if (dbUtils == null) {
//			dbUtils = new DBUtils();
//
//		}
//
//		return dbUtils;
//	}
	
	public Connection getConnection() {
		
		Properties properties = loadPropeerties();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println("nahi mila");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	because it can read the line and assign key and value
	private Properties	 loadPropeerties() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
//			System.out.println("llll->"+DBUtils.class.getClassLoader().getResourceAsStream("application.properties"));
			inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
			System.out.println(inputStream!=null);
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
//		properties.load();
		return properties;
	}
	
	
	public String useridGenerator(String firstname , String lastname) throws UNableToGenerateIdException {
//		retrieve the value from databse(useridgenerator)
//		take first char from first name and lastname then 
//		increament the number (retreived from db)
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id =0 ;
		int updatedresult =0;
		String newId = null;
		String query = "select userid from useridgenerator";
		String updatequery = "update useridgenerator set userid=?";
		connection = this.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id  = resultSet.getInt(1);
			
			++id;
			System.out.println("id = "+id);
			int no_digit = Integer.toString(id).length();
			String no_zeros = "";
			for(int i=0;i<10-no_digit;i++) {
				no_zeros=no_zeros+0;
			}
			newId = firstname.charAt(0)+""+lastname.charAt(0)+""+no_zeros+id;
			System.out.println(newId);
			preparedStatement = connection.prepareStatement(updatequery);
			preparedStatement.setInt(1	, id);
			updatedresult = preparedStatement.executeUpdate();
			if(updatedresult==0) {
				throw new UNableToGenerateIdException("unable to generate id");
			}
			return newId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UNableToGenerateIdException("unable to generate id"+e.getMessage());
		}finally {
			this.closeConnection(connection);
		}
		
		return null;
			
	}
	
	public String movieIdGenerator(String moviname) throws UNableToGenerateIdException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id =0 ;
		int updatedresult =0;
		String newId = null;
		String query = "select userid from useridgenerator";
		String updatequery = "update useridgenerator set userid=?";
		connection = this.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id  = resultSet.getInt(1);
			
			++id;
			System.out.println("id = "+id);
			int no_digit = Integer.toString(id).length();
			String no_zeros = "";
			for(int i=0;i<10-no_digit;i++) {
				no_zeros=no_zeros+""+0;
			}
			newId = moviname.charAt(0)+""+moviname.charAt(1)+""+no_zeros+id;
			System.out.println(newId);
			preparedStatement = connection.prepareStatement(updatequery);
			preparedStatement.setInt(1	, id);
			updatedresult = preparedStatement.executeUpdate();
			if(updatedresult==0) {
				throw new UNableToGenerateIdException("unable to generate id");
			}
			return newId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UNableToGenerateIdException("unable to generate id"+e.getMessage());
		}finally {
			this.closeConnection(connection);
		}
		
		return null;
	}
	
	
	
	
//	public static void main(String[] args) {
//		String result = null;
//		try {
//			result = DBUtils.getInstance().movieIdGenerator("kuldeep");
//		} catch (UNableToGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(result);
//	}
	
	

}
