package com.ASH.service;

import com.ASH.dao.roomConsumeDao;
import com.ASH.entity.RoomConsume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
返回所有消费记录
 */
@WebServlet("/roomConsumeSel.do")
public class roomConsumeServlet extends HttpServlet {
    public roomConsumeServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        roomConsumeDao roomConsumeDao=new roomConsumeDao();
        ArrayList<RoomConsume> arrayList=roomConsumeDao.selectAll();
        request.getSession().setAttribute("roomConsumeArrayList",arrayList);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("pages/forms/consume.jsp");
    }
}