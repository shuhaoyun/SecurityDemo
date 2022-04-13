package com.ysh.Filter;

import lombok.NoArgsConstructor;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;



public class AllException11 extends ExceptionTranslationFilter {




    public AllException11(AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationEntryPoint);
    }

    public AllException11(AuthenticationEntryPoint authenticationEntryPoint, RequestCache requestCache) {
        super(authenticationEntryPoint, requestCache);
    }
}
