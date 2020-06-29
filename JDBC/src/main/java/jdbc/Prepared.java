package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prepared {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemp?useUnicode=true&characterEncoding=utf8","root","root");
            String sql="insert into dept values(null,?,?)";
            //根据sql语句创建preparedStatement
            preparedStatement=connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,"羽毛部门");
            preparedStatement.setString(2,"江西");
            //执行
            preparedStatement.execute();
            System.out.println("插入成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
