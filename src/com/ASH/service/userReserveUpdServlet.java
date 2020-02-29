package com.ASH.service;

import com.ASH.dao.userReserveDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdReserve.do")
public class userReserveUpdServlet extends HttpServlet {
    public userReserveUpdServlet() {
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
        userReserveDao userReserveDao = new userReserveDao();
        String name = request.getParameter("name");
        String in= request.getParameter("checkin_date");
        java.sql.Date checkin_date = java.sql.Date.valueOf(in);
        String out= request.getParameter("checkout_date");
        java.sql.Date checkout_date = java.sql.Date.valueOf(out);
        String room_type = request.getParameter("room_type");
        Boolean flag=userReserveDao.update(name,checkin_date,checkout_date,room_type);
        if (flag == true)
            request.getSession().setAttribute("msg", "修改成功");
        else
            request.getSession().setAttribute("msg", "修改失败");
        response.sendRedirect("pages/forms/reserve_update.jsp");
    }

}
