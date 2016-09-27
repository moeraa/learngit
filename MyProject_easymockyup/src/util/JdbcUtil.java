package util;

import java.sql.*;

public class JdbcUtil {
    private static final String DIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/myweb";
	private static final String USER = "root";
	private static final String PWD = "123456";
	private static JdbcUtil instance = new JdbcUtil();

	private JdbcUtil() {

    }

	public static JdbcUtil getInstance() {
		return instance;
	}

	// 加载驱动
	static {
		try {
			Class.forName(DIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("数据库驱动加载失败！");
		}
	}

	// 创建连接
	public Connection getConn() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(conn+"连接数据库失败！");
		}
		return conn;
	}

	// 关闭资源
	public void free(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			} else if (stmt != null) {
				stmt.close();
			} else if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}