//public class CountPage {
//}

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "WhatNumberServlet", urlPatterns = "/count-page")
public class CountPage extends HttpServlet {

    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userClear = req.getParameter("clear");


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if(userClear != null){
            count = 1;
        } else {
            count++;
        }

        out.println("<h1>The count is :" + count + "</h1>");
    }
}