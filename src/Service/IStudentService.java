package Service;

import Dao.Student;

import java.util.List;

public interface IStudentService {
    public Student queryStudentBySid(int Sid);

    public List<Student> queryAllStudents();

    public boolean deleteStudentBySid(int Sid);

    public boolean updateStudentBySid(int Sid, Student student);

    public boolean addStudent(Student student);
}

