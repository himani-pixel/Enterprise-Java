import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Calculator"})
public class Calculator extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String op = request.getParameter("operator");

        if (op.equals("Addition")) {
            out.println("Addition is: "
                    + (Integer.parseInt(num1) + Integer.parseInt(num2)));

        } else if (op.equals("Subtraction")) {
            out.println("Subtraction is: "
                    + (Integer.parseInt(num1) - Integer.parseInt(num2)));

        } else if (op.equals("Multiplication")) {
            out.println("Multiplication is: "
                    + (Integer.parseInt(num1) * Integer.parseInt(num2)));

        } else {
            out.println("Division is: "
                    + (Integer.parseInt(num1) / Integer.parseInt(num2)));
        }
    }
}
