package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemp?useUnicode=true&characterEncoding=utf8","root","root");
             statement=connection.createStatement();
            String sql="insert into dept(dname,loc) values('信息部门9','xi昂杠');";
             statement.executeUpdate(sql);
             System.out.println("数据插入成功！");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
