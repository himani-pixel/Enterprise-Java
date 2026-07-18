import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ServReg"})
public class ServReg extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String connectionURL = "jdbc:mysql://localhost:3306/db";
            Connection connection = null;

            String uid = request.getParameter("uid");
            String fname = request.getParameter("fname");
            String sname = request.getParameter("sname");
            String pwd = request.getParameter("pwd");
            String pwd1 = request.getParameter("pwd1");
            String town = request.getParameter("town");
            String country = request.getParameter("country");
            String zip = request.getParameter("zip");

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        connectionURL,
                        "root",
                        "mysql_2026"
                );

                String sql = "INSERT INTO user_register VALUES(?,?,?,?,?,?,?,?)";

                PreparedStatement pst = connection.prepareStatement(sql);

                pst.setString(1, uid);
                pst.setString(2, fname);
                pst.setString(3, sname);
                pst.setString(4, pwd);
                pst.setString(5, pwd1);
                pst.setString(6, town);
                pst.setString(7, country);
                pst.setString(8, zip);

                int numRowsChanged = pst.executeUpdate();

                out.println("<h2>Welcome : " + fname + "</h2>");
                out.println("<p>Rows Inserted : " + numRowsChanged + "</p>");

                pst.close();

            } catch (ClassNotFoundException e) {

                out.println("Couldn't Load Database Driver : " + e.getMessage());

            } catch (SQLException e) {

                out.println("SQL Exception Caught : " + e.getMessage());

            } catch (Exception e) {

                out.println(e);

            } finally {

                try {

                    if (connection != null) {
                        connection.close();
                    }

                } catch (SQLException ignored) {

                    out.println(ignored);

                }
            }
        }
    }
}
