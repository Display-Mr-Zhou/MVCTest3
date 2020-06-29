package jdbc;


import java.sql.*;

public class Retrieve {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemp?useUnicode=true&characterEncoding=utf8","root","root");
                statement=connection.createStatement();
                String sql="select * from dept";
                ResultSet resultSet=statement.executeQuery(sql);
                while (resultSet.next()){
                    int donn=resultSet.getInt("donn");
                    String dname=resultSet.getString("dname");
                    String loc=resultSet.getString("loc");
                    System.out.println("id=:"+donn+"name=:"+dname+"location=:"+loc);
                    System.out.println("成功！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
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
