package service.impl;

import bean.User;
import dao.IUserDao;
import dao.impl.UserDaoImpl;
import service.IUserService;

/**
 * Created by jw_tute on 2016/6/19.
 */
public class UserService implements IUserService {
            private IUserDao ud=new UserDaoImpl();
    @Override
    public String vaUser(String username) {
        User u=ud.vaUser(username);
        String result="";
        if (u==null){
            result="success";
        }else{
            result="failed";
        }
        return result;
    }
}
