package jdbc;

import java.sql.*;

public class User {
    public static void main(String[] args) {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf8","root","root");
            statement=connection.createStatement();
            String name="dashen";
            String password="thisispassword";
            String sql="select * from user where name='"+name+"'and password='"+password+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                System.out.println("登录成功！");
            }else {
                System.out.println("登录失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
