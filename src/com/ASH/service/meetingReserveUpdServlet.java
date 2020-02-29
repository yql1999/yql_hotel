package com.ASH.service;

import com.ASH.dao.meetingReserveDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdMeetingReserve.do")
public class meetingReserveUpdServlet extends HttpServlet {
    public meetingReserveUpdServlet() {
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
        String name = request.getParameter("name");
        Long meeting_id = Long.parseLong(request.getParameter("meeting_id"));
        Long time_period =  Long.parseLong(request.getParameter("time_period"));
        Boolean flag=meetingReserveDao.update(meeting_id, name, time_period);
        if (flag == true)
            request.getSession().setAttribute("msg", "修改成功");
        else
            request.getSession().setAttribute("msg", "修改失败");
        response.sendRedirect("pages/forms/meetingReserve_update.jsp");
    }

}
