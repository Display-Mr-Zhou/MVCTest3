package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2020/3/4 0004 11:30
 * @description
 */
public interface Action {
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
