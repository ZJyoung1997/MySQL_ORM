package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import util.ConfigUtil;

public class DBConnect {
	
	private ConfigUtil configUtil = null;
	
	private Connection conn = null;
	private PreparedStatement prst = null;
	private ResultSet res = null;
	
	private String url;
	private String user;
	private String password;
	
	public DBConnect() {
		configUtil = new ConfigUtil();
		
		try {
			Class.forName(configUtil.getValue("datasource.driver"));
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.err.println("��DBConnect��MySQL���ݿ���������ʧ��");
		}
		
		url = configUtil.getValue("datasource.url");
		user = configUtil.getValue("datasource.user");
		password = configUtil.getValue("datasource.password");
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("��DBConnect�����ݿ�����ʧ��");
		}
	}

	public Connection getConn() {
		return conn;
	}

	public PreparedStatement getPrst() {
		return prst;
	}

	public ResultSet getRes() {
		return res;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			System.err.println("��DBConnect��Connection�ر��쳣");
		}
		try {
			prst.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			System.err.println("��DBConnect��PreparedStatement�ر��쳣");
		}
		try {
			res.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			System.err.println("��DBConnect��ResultSet�ر��쳣");
		}
	}
}
