package Dao.impl;

import Dao.IStudentDao;
import Dao.Student;
import StudentUtil.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//数据访问层：原子性操作
public class StudentDaoImpl implements IStudentDao {

    @Override
    public boolean isExist(int Sid) {
        return queryStudentBySid(Sid) != null;
    }

    @Override
    public boolean addStudent(Student student) {
        String sql = "insert into Students(sid,sname,sage,saddress) values(?,?,?,?)";
        Object[] params = {student.getSid(), student.getSname(), student.getSage(), student.getSage(), student.getSaddress()};
        return DBUtil.executeUpdate(sql, params);

    }

    @Override
    public boolean deleteStudentBySid(int Sid) {
        String sql = "delete from Students where sid=?";
        Object[] params = {Sid};
        return DBUtil.executeUpdate(sql, params);


    }

    @Override
    public boolean UpdateStudentBySid(int Sid, Student student) {
        String sql = "update Students set sname=?,sage=?,saddress=? where sid=?";
        Object[] params = {student.getSname(), student.getSage(), student.getSaddress(), Sid};
        return DBUtil.executeUpdate(sql, params);

    }

    @Override
    public Student queryStudentBySid(int Sid) {
        PreparedStatement preparedStatement = null;
        Student student = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from Students where sid=?";
            Object[] params = {student.getSid()};
            resultSet = DBUtil.executeQuery(sql, params);

            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student = new Student(id, name, age, address);

            }


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeAll(resultSet, preparedStatement, DBUtil.connection);
        }
        return student;
    }

    @Override
    public List<Student> queryAllStudent() {
        PreparedStatement preparedStatement = null;
        Student student;
        ResultSet resultSet = null;
        List students = new ArrayList();

        try {
            String sql = "select * from Students";
            resultSet = DBUtil.executeQuery(sql, null);

            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student = new Student(id, name, age, address);
                students.add(student);

            }

            return students;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeAll(resultSet, preparedStatement, DBUtil.connection);
        }

    }

 /*   public Student queryStudentBySid(int Sid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String SQL = "select * from Students where sid=?";

            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, Sid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student = new Student(id, name, age, address);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return student;
    }

    public List<Student> queryAllStudent() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String SQL = "select * from Students ";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student = new Student(id, name, age, address);
                students.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }*/

}
