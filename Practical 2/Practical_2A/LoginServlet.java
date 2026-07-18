import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");

        String uname = request.getParameter("txtId");
        String upass = request.getParameter("txtPass");

        if (uname.equals("Himani") && upass.equals("pass")) {

            RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
            rd.forward(request, response);

        } else {

            out.println("<h1>Login Failed</h1>");

            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }

        out.println("</body>");
        out.println("</html>");
    }
}
