package dao;

import bean.Manager;

/**
 * Created by jw_tute on 2016/6/5.
 */
public interface ILoginDao {
        public Manager login(String username, String password);
        }
