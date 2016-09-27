package util;

import com.sun.deploy.config.Config;
import com.sun.java.util.jar.pack.*;

import java.sql.*;


/**
 * Created by jw_tute on 2016/6/8.
 */
public class JDBCUtil1 {
            private static final String DRIVER="com.mysql.jdbc.Driver";
            private static final String URL="jdbc:mysql://localhost:3306/myweb";
            private static final String USER="root";
            private static final String PWD="123456";
            private static JDBCUtil1 instance =new JDBCUtil1();

        private JDBCUtil1(){

        }
        public static JDBCUtil1 getInstance(){
            return instance;
        }

        static{
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
                System.out.println("数据库驱动加载失败");
            }
        }

    public Connection getCon(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return con;
    }

    public void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            } else if (stmt != null) {
                stmt.close();
            } else if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
