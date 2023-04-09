package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardRequestDTO;
import board.controller.BoardDAO;
import controller.Action;

public class WriteBoardAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String codeParam = request.getParameter("code");
		int code = 1;

		if (codeParam != null) {
			code = Integer.parseInt(codeParam);
			String title = request.getParameter("title");
			String main = request.getParameter("main");
			String modifiedDate = request.getParameter("register_date");
			String registerDate = request.getParameter("register_date");
			String writer = request.getParameter("writer");

			BoardRequestDTO dto = new BoardRequestDTO(code, title, main, modifiedDate, registerDate, writer);

			BoardDAO dao = BoardDAO.getInstance();
			dao.createBoard(dto);

			response.sendRedirect("boardlist");
		}

	}

}
