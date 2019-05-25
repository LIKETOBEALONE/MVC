package Dao;


import java.util.List;

public interface IStudentDao {
    public boolean isExist(int Sid);

    public boolean addStudent(Student student);


    public boolean deleteStudentBySid(int Sid);


    public boolean UpdateStudentBySid(int Sid, Student student);

    public Student queryStudentBySid(int Sid);

    public List<Student> queryAllStudent();
}
