package filters;

import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/user", "/adminAdd", "/adminEditUser", "/login", "/adminUsersList", "/edit"})
public class Filter implements javax.servlet.Filter {
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
            servletRequest.getServletContext().getRequestDispatcher("/login").forward(request, response);
        } else {
            if (user.getRole().equals("admin")) {
                filterChain.doFilter(request, response);
            } else if (user.getRole().equals("user")) {
                if (request.getRequestURL().toString().contains("/user")) {
                    filterChain.doFilter(request, servletResponse);
                } else {
                    servletRequest.getServletContext().getRequestDispatcher("/user").forward(request, response);
                }
            }

        }


    }

    @Override
    public void destroy() {

    }
}
