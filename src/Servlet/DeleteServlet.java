package Servlet;

import Service.IStudentService;
import Service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(request.getParameter("sid"));
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.deleteStudentBySid(sid);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        if (result) {
            //response.getWriter().println("删除成功！");
            response.sendRedirect("QueryAllStudentServlet");
        } else {
            response.getWriter().println("删除失败！");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
