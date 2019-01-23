package com.imefuture.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossDomainFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        /*
//         * 导入包：import javax.servlet.http.HttpServletResponse;
//         * 接口参数中定义：HttpServletResponse response
//         */
        HttpServletResponse response = (HttpServletResponse) resp;
//// 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
//        response.setHeader("Access-Control-Allow-Origin", "http://www.domain1.com");
//
//// 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//// 提示OPTIONS预检时，后端需要设置的两个常用自定义头
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
//        chain.doFilter(req, resp);
        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type, authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) {

    }

}
