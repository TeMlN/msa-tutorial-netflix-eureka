package com.example.MSAAPIGateWay.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class PreZuulFilter extends ZuulFilter {

    @Override
    public String filterType() { // 필터의 타입 Pre, route, post, error 중 정의
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {  // 필터의 실행 순서 정의
        return PRE_DECORATION_FILTER_ORDER - 1; // 4
    }

    @Override
    public boolean shouldFilter() { // 필터의 실행 여부 정의 default = false
        return true;
    }

    @Override
    public Object run() throws ZuulException { // 필터가 수행할 로직 정의
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        if (!request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }

        return null;
    }
}
