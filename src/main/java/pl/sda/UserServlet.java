package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> userList = Arrays.asList(
                new Users("Piotr", "Alejski"),
                new Users("Adam", "Alejski"),
                new Users("Olaf", "Alejski"));

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.write("<ul>");

        userList.forEach(e -> writer.write("<li>" + e.getFirstName() + " " + e.getLastName() + "</li>"));

        writer.write("</ul>");


    }
}
