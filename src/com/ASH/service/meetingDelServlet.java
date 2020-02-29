package com.ASH.service;

import com.ASH.dao.meetingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelMeeting.do")
public class meetingDelServlet extends HttpServlet {
    public meetingDelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String meeting_number = request.getParameter("meeting_number");
        meetingDao meetingDao = new meetingDao();
        response.setCharacterEncoding("utf-8");
        Boolean flag=meetingDao.del(meeting_number);
        if (flag == true)
            request.getSession().setAttribute("msg", "删除成功");
        else
            request.getSession().setAttribute("msg", "删除失败");
        response.sendRedirect("pages/forms/meeting_delete.jsp");
    }

}
