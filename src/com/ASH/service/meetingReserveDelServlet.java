package com.ASH.service;

import com.ASH.dao.meetingReserveDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelMeetingReserve.do")
public class meetingReserveDelServlet extends HttpServlet {
    public meetingReserveDelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        meetingReserveDao meetingReserveDao = new meetingReserveDao();
        response.setCharacterEncoding("utf-8");
        Boolean flag=meetingReserveDao.del(name);
        if (flag == true)
            request.getSession().setAttribute("msg", "删除成功");
        else
            request.getSession().setAttribute("msg", "删除失败");
        response.sendRedirect("pages/forms/meetingReserve_delete.jsp");
    }

}
