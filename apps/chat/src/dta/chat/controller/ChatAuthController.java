package dta.chat.controller;

@FunctionalInterface
public interface ChatAuthController {
	void authenticate(String login);
}
