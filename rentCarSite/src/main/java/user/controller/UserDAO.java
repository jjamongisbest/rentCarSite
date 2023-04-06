package user.controller;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import user.User;
import user.UserRequestDTO;
import util.DBManager;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	public void createUser(UserRequestDTO userDto) {
		User user = new User(userDto);

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";

			try {

				// (user_id, name, phone, password, sign_date, email)
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, user.getUser_id());
				this.pstmt.setString(2, user.getName());
				this.pstmt.setString(3, user.getPhone());
				this.pstmt.setString(4, user.getPassword());
				this.pstmt.setString(5, user.getSign_date());
				this.pstmt.setString(6, user.getEmail());

				this.pstmt.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public User getUserById(String id) {
		User user = null;
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM users WHERE user_id = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String name = this.rs.getString(2);
					String phone = this.rs.getString(3);
					String password = this.rs.getString(4);
					String sign_date = this.rs.getString(5);
					String email = this.rs.getString(6);

					user = new User(id, name, phone, password, sign_date, email);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return user;
	}

	// user_id, name, phone, password, sign_date, email
	public ArrayList<User> getUserAll() {
		ArrayList<User> list = new ArrayList<>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM users";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String userid = this.rs.getString(1);
					String name = this.rs.getString(2);
					String phone = this.rs.getString(3);
					String password = this.rs.getString(4);
					String signdate = this.rs.getString(5);
					String email = this.rs.getString(6);

					User user = new User(userid, name, phone, password, signdate, email);
					list.add(user);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return list;
	}
}
