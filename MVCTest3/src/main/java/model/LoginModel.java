package model;

/**
 * @author Administrator
 * @date 2020/3/4 0004 11:33
 * @description
 */
public class LoginModel {

    public boolean isExistUser(String username,String password){
        //通过JDBCdao去访问数据库
        if("jack".equals(username)&&"123456".equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
