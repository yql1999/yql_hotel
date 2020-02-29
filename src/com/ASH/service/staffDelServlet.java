package com.ASH.service;

import com.ASH.dao.staffDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelStaff.do")
public class staffDelServlet extends HttpServlet {
    public staffDelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        staffDao staffDao = new staffDao();
        response.setCharacterEncoding("utf-8");
        Boolean flag=staffDao.del(name);
        if (flag == true)
            request.getSession().setAttribute("msg", "删除成功");
        else
            request.getSession().setAttribute("msg", "删除失败");
        response.sendRedirect("pages/forms/staff_delete.jsp");
    }

}
