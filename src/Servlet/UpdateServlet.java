package Servlet;

import Dao.Student;
import Service.IStudentService;
import Service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("Utf-8");
        int sid = Integer.parseInt(request.getParameter("sid"));
        //修改后的内容
        String sname = request.getParameter("sname");
        int sage = Integer.parseInt(request.getParameter("sage"));
        String saddress = request.getParameter("saddress");
        //将修改好的内容封装到一个实体类中
        Student student = new Student(sname, sage, saddress);
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.updateStudentBySid(sid, student);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        if (result) {
            //    response.getWriter().println("修改成功！");
            response.sendRedirect("QueryAllStudentServlet");
        } else {
            response.getWriter().println("修改失败！");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
