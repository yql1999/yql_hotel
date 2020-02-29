package com.ASH.service;

import com.ASH.dao.checkInDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCheckIn.do")
public class checkinAddServlet extends HttpServlet {
    public checkinAddServlet() {
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
        String document_type = request.getParameter("document_type");
        String document_number = request.getParameter("document_number");
        String gender = request.getParameter("gender");
        String in= request.getParameter("checkin_date");
        java.sql.Date checkin_date = java.sql.Date.valueOf(in);
        String out= request.getParameter("checkout_date");
        java.sql.Date checkout_date = java.sql.Date.valueOf(out);
        String time = request.getParameter("time");
        String phone_number = request.getParameter("phone_number");
        Boolean flag=checkinDao.add(name, document_type, document_number, gender,
                checkin_date, checkout_date, time, phone_number);
        if (flag == true)
            request.getSession().setAttribute("msg", "添加成功");
        else
            request.getSession().setAttribute("msg", "添加失败");
        response.sendRedirect("pages/forms/checkin_add.jsp");
    }

}
