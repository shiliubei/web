package filters;

import models.User;

import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/*"})
public class AnonimusFilter
        implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        User user = (User) request.getSession().getAttribute("user");

        if (session == null || session.getAttribute("user") == null) {
           if (request.getRequestURL().toString().contains("login")) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect("/login");
            }
        } else {
            if (request.getRequestURL().toString().contains("login")) {
                if (user.getRole().equals("admin")) {
                    response.sendRedirect("/admin/UsersList");
                }
                if (user.getRole().equals("user")) {
                    response.sendRedirect("/user");
                }
            } else{
                filterChain.doFilter(request, response);
            }

        }
    }


    @Override
    public void destroy() {

    }
}
