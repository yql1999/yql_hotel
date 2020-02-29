package com.ASH.service;

import com.ASH.dao.visitorDao;
import com.ASH.entity.Visitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
返回所有访客信息
 */
@WebServlet("/SelAllVisitors.do")
public class visitorSelServlet extends HttpServlet {
    public visitorSelServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        visitorDao visitorDao=new visitorDao();
        ArrayList<Visitor> arrayList=visitorDao.selectAll();
        request.getSession().setAttribute("allVisitors",arrayList);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("pages/forms/visitor_select.jsp");
    }
}
