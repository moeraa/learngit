package servlet;

import bean.Manager;
import service.ILoginService;
import service.impl.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jw_tute on 2016/6/4.
 */
public class LoginServlet extends HttpServlet {
    private ILoginService ls=new LoginService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Manager manager=null;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("fgfgg");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //System.out.println(request.getRequestURL());
        manager=ls.login(username,password);
        System.out.println(manager.getUsername());
        System.out.println(manager.getPassword());
        if(username.equals(manager.getUsername())&&password.equals(manager.getPassword())){
            request.setAttribute("username",username);
            HttpSession hs=request.getSession();
            hs.setAttribute("username",username);
            request.getRequestDispatcher("index.html").forward(request, response);
        }else{
            PrintWriter pw=response.getWriter();
            pw.print("用户名或密码错误");
            pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
