package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prepared2 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemp?useUnicode=true&characterEncoding=utf8","root","root");
            String sql="insert into dept values(null,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<4;i++){
                preparedStatement.setString(1,"兵乓球部门");
                preparedStatement.setString(2,"浙江");
                preparedStatement.execute();
            }
            System.out.println("插入成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
