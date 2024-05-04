package com.severusnguyen.schoolmangagement.security;

import com.severusnguyen.schoolmangagement.util.JwtUtilHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class CustomJwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtilHelper jwtUtilHelper;

    @Override  //https://www.javainuse.com/spring/boot-jwt
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //System.out.println("Kiểm tra filter");
        String token = getTokenFromHeader(request); //2 lấy được token rồi lên đây
        // test ra token rồi qua jwtHelperFilter viết giải mã

        //giải mã xong bên jwtHelperFilter quay lại đây để custom
        if (token != null){
            if (jwtUtilHelper.verifyToken(token)){ //62-24
                //Tạo chứng thực
                //Tạo Authen rỗng vì role người dùng lưu vào token rồi
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("", "", new ArrayList<>());
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(usernamePasswordAuthenticationToken);
                //Đoạn này cho Spring Security biết request này an toàn cho phép user truy cập vào nội dung web
            }
        }
        //System.out.println("Kiểm tra token " + token);
        filterChain.doFilter(request, response);
    }

    //https://www.javainuse.com/spring/boot-jwt
    private String getTokenFromHeader(HttpServletRequest request){ //1
        String header = request.getHeader("Authorization");
        String token = null;

        if (StringUtils.hasText(header) && header.startsWith("Bearer ")){
            token = header.substring(7);
        }

        return token;

    }
}
