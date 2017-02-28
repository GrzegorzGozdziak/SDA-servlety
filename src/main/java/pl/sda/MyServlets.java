package pl.sda;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class MyServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> names = Arrays.asList("Szymon", "Greg", "Vit", "Michal", "Magda", "Ewa");

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        writer.write("<h1>Hello " + req.getParameter("name") + "</h1>");

        String counter = req.getParameter("counter");
        Integer count = new Integer(counter);


        writer.write("<ul>");
//        names.forEach(e -> writer.write("<li>" + e +" <button>delete</button></li>"));

        names.stream()
            .limit(count)
            .forEach(e -> writer.write("<li>" + e +" <button>delete</button></li>"));

        writer.write("</ul>");

        writer.write("<h2>Your request URI is: ");
        writer.write(req.getRequestURI());
        writer.write("</h2>");
    }
}
