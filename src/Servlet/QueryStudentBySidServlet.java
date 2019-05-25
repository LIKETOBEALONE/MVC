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

@WebServlet(name = "QueryStudentBySidServlet", urlPatterns = {"/QueryStudentBySidServlet"})
public class QueryStudentBySidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(request.getParameter("sid"));
        IStudentService studentService = new StudentServiceImpl();
        Student student = studentService.queryStudentBySid(sid);
        System.out.println(student);
        request.setAttribute("student", student);
        request.getRequestDispatcher("StudentInfo.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
