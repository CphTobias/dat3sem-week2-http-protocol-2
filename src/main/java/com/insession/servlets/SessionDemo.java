package com.insession.servlets;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo", value = "/SessionDemo")
public class SessionDemo extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name != null) {
            request.getSession().setAttribute("name", name);
        } else {
            name = (String) request.getSession().getAttribute("name");
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SessionDemo</title>");
            out.println("</head>");
            out.println("<body>");
            if (name != null) {
                name = (String)request.getSession().getAttribute("name");
                out.println("<p> Welcome " + name  + " !</p>");
            } else {
                out.println("<h2>Please enter your name, and submit</h2>");
                out.println("<form action='SessionDemo'>");
                out.println("<input type='input' name='name'>");
                out.println("<input type='submit'></form>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
