package controller;

import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.RegistAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("regist"))
			action = new RegistAction();
//		else if(command.equals("update"))
//			action = new UpdateAction();
		else if(command.equals("login"))
			action = new LoginAction();
		else if(command.equals("logout"))
			action = new LogoutAction();
		
		return action;
	}
}
