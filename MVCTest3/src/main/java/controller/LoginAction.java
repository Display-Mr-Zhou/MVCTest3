package controller;

import model.LoginModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2020/3/4 0004 11:31
 * @description
 */
public class LoginAction implements  Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        //调用Model层的业务逻辑方法index
        LoginModel lm=new LoginModel();
        if(lm.isExistUser(username,password)){
            request.getSession().setAttribute("username",username);
            return "success.jsp";
        }else{
            return "error.jsp";
        }

    }
}
