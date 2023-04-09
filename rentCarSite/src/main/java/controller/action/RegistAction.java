package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.UserRequestDTO;
import user.controller.UserDAO;

public class RegistAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// user_id, name, phone, password, sign_date, email
		String userId = request.getParameter("user_id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String signdate = request.getParameter("sign_date");
		String email = request.getParameter("email");

		UserRequestDTO userDto = new UserRequestDTO(userId, name, phone, password, signdate, email);

		UserDAO userDao = UserDAO.getInstance();
		userDao.createUser(userDto);

		response.sendRedirect("/");
	}

}
