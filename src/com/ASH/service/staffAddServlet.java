package com.ASH.service;

import com.ASH.dao.staffDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddStaff.do")
public class staffAddServlet extends HttpServlet {
    public staffAddServlet() {
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
        String document_type = request.getParameter("document_type");
        String document_number = request.getParameter("document_number");
        String gender = request.getParameter("gender");
        String job = request.getParameter("job");
        Boolean flag=staffDao.add(name, document_type, document_number, gender, job);
        if (flag == true)
            request.getSession().setAttribute("msg", "添加成功");
        else
            request.getSession().setAttribute("msg", "添加失败");
        response.sendRedirect("pages/forms/personnel_add.jsp");
    }

}
