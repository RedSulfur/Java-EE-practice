package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by sulfur on 20.03.16.
 */
@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        System.out.println("======================================");
        System.out.println("Visit time: " + new Date());
        System.out.println("Client adress: " + httpServletRequest.getRemoteAddr());
        System.out.println("Client request url: " + httpServletRequest.getRequestURL().toString());
        System.out.println("Client agent: " + httpServletRequest.getHeader("User-Agent"));
        System.out.println("Client came from: " + httpServletRequest.getHeader("referer"));
        System.out.println("======================================");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }


}
