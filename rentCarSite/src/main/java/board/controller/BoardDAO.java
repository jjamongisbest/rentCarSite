package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.Board;
import board.BoardRequestDTO;
import util.DBManager;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// CREATE
	public void createBoard(BoardRequestDTO dto) {
		Board board = new Board(dto);

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "INSERT INTO board VALUES(?,?,?,?,?,?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, board.getCode());
				this.pstmt.setString(2, board.getTitle());
				this.pstmt.setString(3, board.getMain());
				this.pstmt.setString(4, board.getModifiedDate());
				this.pstmt.setString(5, board.getRegisterDate());
				this.pstmt.setString(6, board.getWriter());

				this.pstmt.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
	}

	// READ
	public ArrayList<Board> getBoardAll() {
		ArrayList<Board> list = new ArrayList<>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM board ORDER BY code";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int code = this.rs.getInt(1);
					String title = this.rs.getString(2);
					String main = this.rs.getString(3);
					String modifiedDate = this.rs.getString(4);
					String registeredDate = this.rs.getString(5);
					String writer = this.rs.getString(6);

					Board board = new Board(code, title, main, modifiedDate, registeredDate, writer);
					list.add(board);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return list;
	}

	public Board getBoardByCode(int code) {
		Board board = null;
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM board WHERE code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, code);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String title = this.rs.getString(2);
					String main = this.rs.getString(3);
					String modifiedDate = this.rs.getString(4);
					String registerDate = this.rs.getString(5);
					String writer = this.rs.getString(6);

					board = new Board(code, title, main, modifiedDate, registerDate, writer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}

		}
		return board;
	}
	
	public int getMaxCode() {
		int code = 1;
		
		this.conn = DBManager.getConnection();
		if(this.conn != null){
			String sql = "SELECT MAX(code) FROM board";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				this.rs.next();
				
				code = this.rs.getInt(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return code;
	}

}
