import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String uname = request.getParameter("uname");
            String pass = request.getParameter("pass");

            if (uname.equals("user") && pass.equals("pwd")) {
                out.println("Hello <b>" + uname
                        + "</b> Welcome to Java Servlet");
            } else {
                out.println("Login Failed");
            }
        }
    }
}
