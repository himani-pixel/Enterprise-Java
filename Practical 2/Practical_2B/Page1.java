import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Page1"})
public class Page1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Page1</title>");
        out.println("</head>");
        out.println("<body bgcolor='lightblue'>");

        String uname = request.getParameter("txtName");

        out.println("<h1>Welcome " + uname + "</h1>");

        Cookie ck1 = new Cookie("Username", uname);
        Cookie ck2 = new Cookie("visit", "1");

        response.addCookie(ck1);
        response.addCookie(ck2);

        out.println("<h2><a href='Page2'>Click to Visit Page 2</a></h2>");

        out.println("</body>");
        out.println("</html>");
    }
}
