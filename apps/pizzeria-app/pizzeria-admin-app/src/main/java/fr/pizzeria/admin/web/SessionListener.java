package fr.pizzeria.admin.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		Integer compteur = (Integer) event.getSession().getServletContext().getAttribute("compteur");
		event.getSession().getServletContext().setAttribute("compteur", compteur + 1);
		System.out.println("Nombre de sessions ouvertes = " + (compteur + 1));

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO
	}

}
