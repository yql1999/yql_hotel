package com.ASH.service;

import com.ASH.dao.checkInDao;
import com.ASH.dao.roomDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdRoom.do")
public class roomUpdServlet extends HttpServlet {
    public roomUpdServlet() {
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
        roomDao roomDao = new roomDao();
        String room_number = request.getParameter("room_number");
        Long type_id =  Long.parseLong(request.getParameter("type_id"));
        String state = request.getParameter("state");
        Boolean flag=roomDao.update(room_number,type_id,state);
        if (flag == true)
            request.getSession().setAttribute("msg", "修改成功");
        else
            request.getSession().setAttribute("msg", "修改失败");
        response.sendRedirect("pages/forms/room_update.jsp");
    }

}
