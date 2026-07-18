import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Page2"})
public class Page2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Page2</title>");
        out.println("</head>");
        out.println("<body bgcolor='lightyellow'>");

        Cookie[] ck = request.getCookies();

        if (ck != null) {

            for (int i = 0; i < ck.length; i++) {

                if (ck[i].getName().equals("visit")) {

                    int count = Integer.parseInt(ck[i].getValue()) + 1;

                    out.println("<h1>Visit No : " + count + "</h1>");

                    ck[i] = new Cookie("visit", String.valueOf(count));
                    response.addCookie(ck[i]);

                } else {

                    out.println("<h2>" + ck[i].getName() + " = " + ck[i].getValue() + "</h2>");
                }
            }

        } else {

            out.println("<h2>No Cookies Found</h2>");
        }

        out.println("<h2><a href='Page3'>Click to Visit Page 3</a></h2>");
        out.println("<h2><a href='Page4'>Click to Visit Page 4</a></h2>");
        out.println("<h2><a href='Page5'>Click to Visit Page 5</a></h2>");

        out.println("</body>");
        out.println("</html>");
    }
}
