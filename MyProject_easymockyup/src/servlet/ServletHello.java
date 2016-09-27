package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jw_tute on 2016/6/4.
 */
public class ServletHello extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//                    String username=request.getParameter("username");
//                    String password=request.getParameter("password");
//                    System.out.println(username);
//                    String url="mytest.html";
//                    String url1="WEB-INF/inf_test.html";
////                    PrintWriter pw=response.getWriter();
////                    pw.print(username);
////                    pw.close();
//                    //response.sendRedirect("");
//                    response.sendRedirect(url1);
//                        //request.getRequestDispatcher(url1).forward(request,response);
        String welcome="welcome ajax";
        System.out.println(welcome);
        response.getWriter().write(welcome);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request,response);
    }
}
