package service.impl;

import bean.Manager;
import dao.ILoginDao;
import dao.impl.LoginDaoImpl;
import service.ILoginService;

/**
 * Created by jw_tute on 2016/6/8.
 */
public class LoginService implements ILoginService {
    private ILoginDao ld=new LoginDaoImpl();

    @Override
    public Manager login(String username, String password) {
        return ld.login(username,password);
    }
}
