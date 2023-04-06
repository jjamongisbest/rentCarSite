package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import user.User;
import user.controller.UserDAO;

public class LoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println("id : "  + id);

		UserDAO userDao = UserDAO.getInstance();
		User user = userDao.getUserById(id);

		if (id == null || id.isEmpty()) {
			// 아이디가 입력되지 않은 경우
			request.setAttribute("message", "아이디를 입력해주세요.");
			request.getRequestDispatcher("login").forward(request, response);
		} else if (user != null && password.equals(user.getPassword())) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("log", user.getUser_id());
			response.sendRedirect("/");
		} else {
			// 로그인 실패
			request.setAttribute("message", "회원 정보가 올바르지 않습니다.");
			request.getRequestDispatcher("login").forward(request, response);

		}

	}

}
