package dao.impl;

import bean.Manager;
import dao.ILoginDao;
import util.JDBCUtil1;
import util.JdbcUtil;

import java.sql.*;

/**
 * Created by jw_tute on 2016/6/8.
 */
public class LoginDaoImpl implements ILoginDao {
    @Override
    public Manager login(String username, String password) {
        Connection connection= JdbcUtil.getInstance().getConn();
        String sql="select username,password from user where username=? and password=?";
        //String sql="select username,password from manager where username="+username+"and"+ "password="+password;
        PreparedStatement pstmt=null;
        Statement statement=null;
        ResultSet rs=null;
        Manager manager=null;
        try {
            pstmt= connection.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            if (rs.next()){
                manager=new Manager();
                manager.setUsername(rs.getString("username"));
                manager.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.getInstance().free(connection,statement,rs);
        }
        return manager;
    }
}
