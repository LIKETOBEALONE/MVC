package Service.impl;

import Dao.Student;
import Dao.impl.StudentDaoImpl;
import Service.IStudentService;

import java.util.List;

//业务逻辑层：逻辑性的增删改查;(增：查+增)
public class StudentServiceImpl implements IStudentService {
    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

    public Student queryStudentBySid(int Sid) {
        return studentDaoImpl.queryStudentBySid(Sid);
    }

    public List<Student> queryAllStudents() {
        return studentDaoImpl.queryAllStudent();
    }

    public boolean updateStudentBySid(int Sid, Student student) {
        if (studentDaoImpl.isExist(Sid)) {
            return studentDaoImpl.UpdateStudentBySid(Sid, student);
        } else {
            return false;
        }
    }

    public boolean deleteStudentBySid(int Sid) {
        if (studentDaoImpl.isExist(Sid)) {
            return studentDaoImpl.deleteStudentBySid(Sid);
        } else {
            return false;
        }
    }

    public boolean addStudent(Student student) {
        if (!studentDaoImpl.isExist(student.getSid())) {
            studentDaoImpl.addStudent(student);
            return true;
        } else {
            System.out.println("此人已存在");
            return false;
        }
    }
}
