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
import java.io.PrintWriter;

@WebServlet(name = "AddStudentServlet", urlPatterns = {"/AddStudentServlet"})
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        Student student = new Student(id, name, age, address);
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.addStudent(student);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        /*if (result) {
            // out.println("增加成功 ！");

        } else {
            //out.println("增加失败 ! ");

        }*/
        if (!result) {
            request.setAttribute("error", "error");
        } else {
            request.setAttribute("error", "without");
        }
//        response.sendRedirect("QueryAllStudentServlet");
        request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
