import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "WhatNumberServlet", urlPatterns = "/what-num")
public class WhatNumberServlet extends HttpServlet {

    private int count;

    public void init(){
        count = 0;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String reset = req.getParameter("reset");
        resp.setContentType("text/html");
        count++;
        PrintWriter out = resp.getWriter();

        if(reset == "yes"){
            out.printf("<h1>User number was %s</h1>", count);
        } else {
            out.println("<h1>You're no fun!</h1>");
        }
    }
}
