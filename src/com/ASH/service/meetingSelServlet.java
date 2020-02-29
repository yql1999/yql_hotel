package com.ASH.service;

import com.ASH.dao.meetingDao;
import com.ASH.dao.roomDao;
import com.ASH.entity.Meeting;
import com.ASH.entity.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
返回所有房间信息
 */
@WebServlet("/SelAllMeeting.do")
public class meetingSelServlet extends HttpServlet {
    public meetingSelServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        meetingDao meetingDao=new meetingDao();
        ArrayList<Meeting> arrayList=meetingDao.getAll();
        request.getSession().setAttribute("allMeetings",arrayList);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("pages/forms/meeting_select.jsp");
    }
}
