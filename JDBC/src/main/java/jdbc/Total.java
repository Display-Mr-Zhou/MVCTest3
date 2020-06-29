package jdbc;

import java.sql.*;

public class Total {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemp?useUnicode=true&characterEncoding=utf8","root","root");
            statement=connection.createStatement();
            String sql="select count(*) from dept";
            ResultSet resultSet=statement.executeQuery(sql);
            int total=0;
            while(resultSet.next()){
                total=resultSet.getInt(1);
            }
            System.out.println("一共有"+total+"条数据");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
