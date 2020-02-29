package com.ASH.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
    public LoginServlet(){
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
        String identity=request.getParameter("identity");//1前台管理员 2总管理员
        if(identity.equals("前台管理员"))
            identity="1";
        else if(identity.equals("总管理员"))
            identity="2";
        else {
            request.getSession().setAttribute("msg","请选择身份！");
            response.setCharacterEncoding("utf-8");
            response.sendRedirect("index.jsp");
        }

        //CustodianDao custodianDao=new CustodianDao();
        boolean flag=true;//custodianDao.Login(Id,Pass,Identity);

        response.setCharacterEncoding("utf-8");
        if(flag){
            //String building=new CustodianDao().SelectCus(Id).getBuilding();
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("identity",identity);
            if(identity.equals("1")) {
                if (password.equals("123") && username.equals("user01") || password.equals("admin") && username.equals("admin"))
                    response.sendRedirect("head.jsp");
            }
            else {
                if (password.equals("admin") && username.equals("admin"))
                    response.sendRedirect("pages/admin/personnel_add.jsp");
            }
        }
        else{
            request.getSession().setAttribute("msg","登录失败！");
            response.sendRedirect("main.jsp");
        }
    }
}
