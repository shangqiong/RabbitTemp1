package com.security_1.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {
    public static String renderString(HttpServletResponse response, String string){
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(string);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
