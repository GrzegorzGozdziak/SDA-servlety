package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class PathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> names = Arrays.asList("Szymon", "Greg", "Vit", "Michal", "Magda", "Ewa");

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.write("<h1>Hello " + req.getParameter("name") + "</h1>");

        String requestURI = req.getRequestURI();
        String value = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        writer.write("<h3>value after last /" + value + "</h3>");

        String valueBefore = requestURI.substring(requestURI.lastIndexOf("/") - 4);
        writer.write("<h3> value before last /" + valueBefore + "</h3>");

        Integer values = new Integer(value);

        writer.write("<ul>");
//        names.forEach(e -> writer.write("<li>" + e +" <button>delete</button></li>"));

        names.stream()
                .limit(values)
                .forEach(e -> writer.write("<li>" + e +" <button>delete</button></li>"));

        writer.write("</ul>");

    }
}
