package com.ASH.service;

import com.ASH.dao.meetingDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdMeeting.do")
public class meetingUpdServlet extends HttpServlet {
    public meetingUpdServlet() {
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
        meetingDao meetingDao = new meetingDao();
        String meeting_number = request.getParameter("meeting_number");
        Long type_id =  Long.parseLong(request.getParameter("type_id"));
        Boolean flag=meetingDao.update(meeting_number,type_id);
        if (flag == true)
            request.getSession().setAttribute("msg", "修改成功");
        else
            request.getSession().setAttribute("msg", "修改失败");
        response.sendRedirect("pages/forms/meeting_update.jsp");
    }

}
