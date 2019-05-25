package StudentUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//数据库帮助类
public class DBUtil {

    private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Students";
    private static final String USERNAME = "Tiger";
    private static final String PASSWORD = "12345";
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;


    public static boolean executeUpdate(String sql, Object[] params) {

        try {


            int count = getPreparedStatement(sql, params).executeUpdate();


            return count > 0;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            closeAll(null, preparedStatement, connection);
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }

    public static PreparedStatement getPreparedStatement(String sql, Object[] params) throws SQLException, ClassNotFoundException {
        preparedStatement = getConnection().prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);

            }
        }
        return preparedStatement;
    }

    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql, Object[] params) {
        List student = new ArrayList();

        try {


            resultSet = getPreparedStatement(sql, params).executeQuery();


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
            closeAll(resultSet, preparedStatement, connection);
        }

        return resultSet;
    }


}
