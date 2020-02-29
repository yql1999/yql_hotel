package com.ASH.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inLogin.do")
public class inLoginServlet extends HttpServlet {
    public inLoginServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=(String)request.getParameter("password");
        String identity=request.getParameter("identity");
        response.setCharacterEncoding("utf-8");

        if(username.equals("admin")&&password.equals("admin")){
            //String building=new CustodianDao().SelectCus(Id).getBuilding();
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("password",password);
            response.sendRedirect("pages/admin/personnel_add.jsp");
        }
        else{
            request.getSession().setAttribute("msg","登录失败！");
            response.sendRedirect("pages/admin/login.jsp");
        }
    }
}
