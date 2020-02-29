package com.ASH.service;

import com.ASH.dao.meetingReserveDao;
import com.ASH.entity.MeetingReserve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
返回所有会议室预定信息
 */
@WebServlet("/SelAllMeetingReserve.do")
public class meetingReserveSelServlet extends HttpServlet {
    public meetingReserveSelServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        meetingReserveDao meetingReserveDao=new meetingReserveDao();
        ArrayList<MeetingReserve> arrayList=meetingReserveDao.selectAll();
        request.getSession().setAttribute("allMeetingReserves",arrayList);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("pages/forms/meetingReserve_select.jsp");
    }
}
