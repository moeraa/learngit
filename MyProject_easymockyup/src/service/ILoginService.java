package service;

        import bean.Manager;

/**
 * Created by jw_tute on 2016/6/5.
 */
public interface ILoginService {
    public Manager login(String username, String password);
}
