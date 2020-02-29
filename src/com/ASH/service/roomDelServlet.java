package com.ASH.service;

import com.ASH.dao.roomDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelRoom.do")
public class roomDelServlet extends HttpServlet {
    public roomDelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String room_number = request.getParameter("room_number");
        roomDao roomDao = new roomDao();
        response.setCharacterEncoding("utf-8");
        Boolean flag=roomDao.del(room_number);
        if (flag == true)
            request.getSession().setAttribute("msg", "删除成功");
        else
            request.getSession().setAttribute("msg", "删除失败");
        response.sendRedirect("pages/forms/room_delete.jsp");
    }

}
