package com.ASH.service;

import com.ASH.dao.meetingReserveDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddMeetingReserve.do")
public class meetingReserveAddServlet extends HttpServlet {
    public meetingReserveAddServlet() {
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
        meetingReserveDao meetingReserveDao = new meetingReserveDao();
        Long meeting_id =  Long.parseLong(request.getParameter("meeting_id"));
        String name = request.getParameter("name");
        Long time_period =  Long.parseLong(request.getParameter("time_period"));
        String phone_number = request.getParameter("phone_number");
        Boolean flag=meetingReserveDao.add(meeting_id, name, phone_number, time_period);
        if (flag == true)
            request.getSession().setAttribute("msg", "添加成功");
        else
            request.getSession().setAttribute("msg", "添加失败");
        response.sendRedirect("pages/forms/meetingReserve_add.jsp");
    }

}
