package com.ysh.Filter;

import com.ysh.Mapper.userMapper;
import com.ysh.Pojo.User;
import com.ysh.Utils.JwtUtils;
import com.ysh.Utils.UserDetail;
import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class jwtFilter extends OncePerRequestFilter {
    @Autowired
    private userMapper userMapper1;
    @Autowired
    private AuthenticationEntryPoint EntryPoint;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if(token==null){
            filterChain.doFilter(request,response);
            return;
        }
        int id;

        Claims claims = null;
        try {
            claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            filterChain.doFilter(request,response);
            return;
//            throw new BadCredentialsException("token异常");
        }
        String subject = claims.getSubject();
        id=Integer.parseInt(subject);
        User userById = userMapper1.findUserById(id);
        if(userById.getStatu()==0){
            filterChain.doFilter(request,response);
            return;
//            //throw new AccountExpiredException("请重新登录");
            }
        UserDetail userDetail = new UserDetail();
        userDetail.setUser(userById);
//        if(!userDetail.isAccountNonExpired()){
//            filterChain.doFilter(request,response);
//            return;
//            //throw new AccountExpiredException("请重新登录");
//        }
        UsernamePasswordAuthenticationToken u=new UsernamePasswordAuthenticationToken(userDetail,null, userDetail.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(u);
        filterChain.doFilter(request,response);
    }
}
