package com.ASH.service;

import com.ASH.dao.checkInDao;
import com.ASH.dao.roomConsumeDao;
import com.ASH.dao.roomDao;
import com.ASH.dao.userReserveDao;
import com.ASH.entity.CheckIn;
import com.ASH.entity.Room;
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
返回所有房间信息
 */
@WebServlet("/SelAllRoom.do")
public class roomSelServlet extends HttpServlet {
    public roomSelServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        roomDao roomDao=new roomDao();
        ArrayList<Room> arrayList=roomDao.selectAll();
        request.getSession().setAttribute("allRooms",arrayList);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("pages/forms/room_select.jsp");
    }
}
