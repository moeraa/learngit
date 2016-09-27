package dao.impl;

import bean.Manager;
import bean.User;
import dao.IUserDao;
import util.JdbcUtil;

import java.sql.*;

/**
 * Created by jw_tute on 2016/6/19.
 */
public class UserDaoImpl implements IUserDao{
    @Override
    public User vaUser(String username) {
        Connection connection= JdbcUtil.getInstance().getConn();
        String sql="select username from user where username=?";
        PreparedStatement pstmt=null;
        Statement statement=null;
        ResultSet rs=null;
        User u=null;
        try {
            pstmt= connection.prepareStatement(sql);
            pstmt.setString(1,username);
            rs=pstmt.executeQuery();
            if (rs.next()){
                u=new User();
                u.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.getInstance().free(connection,statement,rs);
        }
        return u;
    }
}
