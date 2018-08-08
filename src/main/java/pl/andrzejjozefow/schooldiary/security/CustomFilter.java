package pl.andrzejjozefow.schooldiary.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Component
@Slf4j
public class CustomFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Init::called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter::called");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Principal userPrincipal = request.getUserPrincipal();
        log.info("userPrinciple::" + userPrincipal);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("Destroy::called");

    }

}
