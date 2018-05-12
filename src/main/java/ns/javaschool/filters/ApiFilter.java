package ns.javaschool.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ApiFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = (String) req.getSession().getAttribute("token");
        boolean apiAuthorized = token != null && token.equals(req.getHeader("Authorization"));
        if (apiAuthorized || "/login".equals(req.getPathInfo())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getOutputStream().print("UNAUTHORIZED");
        }
    }

    public void destroy() {

    }
}
