package fr.pizzeria.admin.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	private static final String SESSION_COUNT = "sessionCount";

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		Integer compteur = (Integer) context.getAttribute(SESSION_COUNT);
		if (compteur != null) {
			context.setAttribute(SESSION_COUNT, compteur + 1);
		} else {
			context.setAttribute(SESSION_COUNT, 1);
		}
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		Integer compteur = (Integer) context.getAttribute(SESSION_COUNT);
		context.setAttribute(SESSION_COUNT, compteur - 1);
	}

}
