package com.ys.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangshe on 2016/9/8.
 */
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("key");
        req.getSession().setAttribute("mysession","这里我放了一些session范围的值");
        System.out.printf("运行到这里了"+str);
        req.getRequestDispatcher("./WEB-INF/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * 在web.xml中的配置
     *   <servlet>
     <servlet-name>MyTest</servlet-name>
     <servlet-class>com.ys.demo.servlet.Test</servlet-class>
     </servlet>
     <servlet-mapping>
     <servlet-name>MyTest</servlet-name>
     <url-pattern>/test</url-pattern>
     </servlet-mapping>-->
     */
}
