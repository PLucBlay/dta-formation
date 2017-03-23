package fr.pizzeria.admin.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter(urlPatterns = { "/*" })
public class LoginFilter implements Filter {
	private FilterConfig config = null;
	private Set<String> setAuthorizedAccess = new HashSet<>();

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// empty
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Boolean attributeCo = (Boolean) ((HttpServletRequest) request).getSession().getAttribute("isConnected");
		if (((attributeCo != null) && attributeCo)
				|| (setAuthorizedAccess.contains(((HttpServletRequest) request).getServletPath()))) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = config;
		this.setAuthorizedAccess.add("/login");
		this.setAuthorizedAccess.add("/technique");
		this.setAuthorizedAccess.add("/css/pizzeria.css");
	}

}
