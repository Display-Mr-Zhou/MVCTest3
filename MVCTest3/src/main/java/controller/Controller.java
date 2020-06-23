package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2020/3/4 0004 11:38
 * @description
 */
public class Controller extends HttpServlet {
    private Map<String,Action> actionMap=new HashMap<String,Action>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        Enumeration enumeration=config.getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String paramName=(String)enumeration.nextElement();
            String paramValue=config.getInitParameter(paramName);
            Action action= null;
            try {
                Class clz=Class.forName(paramValue);
                action = (Action)clz.newInstance();
                actionMap.put(paramName,action);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String reqPath=request.getRequestURI();
        reqPath=reqPath.substring(reqPath.lastIndexOf("/")+1,reqPath.length()-7);
        Action action=this.actionMap.get(reqPath);
        String path=action.execute(request,response);
        request.getRequestDispatcher(path).forward(request,response);

    }
}
