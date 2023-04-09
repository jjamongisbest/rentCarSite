package controller;

import controller.action.DeleteBoardAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.RegistAction;
import controller.action.WriteBoardAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("regist"))
			action = new RegistAction();
		else if (command.equals("login"))
			action = new LoginAction();
		else if (command.equals("logout"))
			action = new LogoutAction();
		else if(command.equals("deleteboard"))
			action = new DeleteBoardAction();
		else if(command.equals("writeboard"))
			action = new WriteBoardAction();

		return action;
	}
}
