package com.ASH.service;

import com.ASH.dao.checkInDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdCheckIn.do")
public class checkinUpdServlet extends HttpServlet {
    public checkinUpdServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        checkInDao checkinDao = new checkInDao();
        String name = request.getParameter("name");
        String in= request.getParameter("checkin_date");
        java.sql.Date checkin_date = java.sql.Date.valueOf(in);
        String out= request.getParameter("checkout_date");
        java.sql.Date checkout_date = java.sql.Date.valueOf(out);
        String time = request.getParameter("time");
        Boolean flag=checkinDao.update(name,checkin_date,checkout_date,time);
        if (flag == true)
            request.getSession().setAttribute("msg", "修改成功");
        else
            request.getSession().setAttribute("msg", "修改失败");
        response.sendRedirect("pages/forms/checkin_update.jsp");
    }

}
