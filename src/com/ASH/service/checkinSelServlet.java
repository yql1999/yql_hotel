package com.ASH.service;

import com.ASH.dao.checkInDao;
import com.ASH.dao.roomConsumeDao;
import com.ASH.dao.userReserveDao;
import com.ASH.entity.CheckIn;
import com.ASH.entity.RoomConsume;
import com.ASH.entity.UserReserve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
返回所有预定信息
 */
@WebServlet("/SelAllCheckIn.do")
public class checkinSelServlet extends HttpServlet {
    public checkinSelServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        checkInDao checkInDao=new checkInDao();
        ArrayList<CheckIn> arrayList=checkInDao.getAll();
        request.getSession().setAttribute("allCheckIns",arrayList);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("pages/forms/checkin_select.jsp");
    }
}
