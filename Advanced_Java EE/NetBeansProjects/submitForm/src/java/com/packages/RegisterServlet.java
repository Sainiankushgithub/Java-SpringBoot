package com.packages;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h2>Welcome to register servlet</h2>");
        
        String name=request.getParameter("user_name");
        String password=request.getParameter("user_password");
        String email=request.getParameter("user_email");
        String gender =request.getParameter("user_gender");
        String course=request.getParameter("user_course");
        String cond=request.getParameter("condition");
        
        
        
        if(cond!=null){
            if(cond.equals("checked")){
                out.println("<h2> Name : " +name+ "</h2>");
                out.println("<h2> Password : " +password+ "</h2>");
                out.println("<h2> Email : " +email+ "</h2>");
                out.println("<h2> Gender : " +gender+ "</h2>");
                out.println("<h2> Course : " +course+ "</h2>");
                
                RequestDispatcher rd=request.getRequestDispatcher("success");
                rd.forward(request, response);
            }
            else{
                out.println("<h2>You have not accepted the terms and conditions</h2>");
            }
        }
        else{
                out.println("<h2>You have not accepted the terms and conditions</h2>");
                RequestDispatcher rd=request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }
    }
}
