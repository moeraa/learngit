package servlet;

import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jw_tute on 2016/6/19.
 */
public class UsernameVaServlet extends HttpServlet {
        private IUserService iu=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html;charset=utf-8");
                request.setCharacterEncoding("utf-8");
                String username=request.getParameter("username");
                PrintWriter pw=response.getWriter();
                System.out.println(username);
                if(username==null){
                    pw.write("请输入用户名！");
                }else {
                    String result = iu.vaUser(username);
                    if ("success".equals(result)) {
                        pw.write("用户名可用");
                    } else if ("failed".equals(result)) {
                        pw.write("用户名已经被注册，请换个用户名！");
                    }
                }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request,response);
    }
}
