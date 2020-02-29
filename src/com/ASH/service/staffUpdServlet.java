package com.ASH.service;

import com.ASH.dao.staffDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdStaff.do")
public class staffUpdServlet extends HttpServlet {
    public staffUpdServlet() {
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
        staffDao staffDao = new staffDao();
        String name = request.getParameter("name");
        String job = request.getParameter("job");
        Boolean flag=staffDao.update(name,job);
        if (flag == true)
            request.getSession().setAttribute("msg", "修改成功");
        else
            request.getSession().setAttribute("msg", "修改失败");
        response.sendRedirect("pages/forms/staff_update.jsp");
    }

}
