package book.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import book.Book;
import book.BookRequestDTO;
import util.DBManager;

public class BookDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BookDAO() {
	}

	private static BookDAO instance = new BookDAO();

	public static BookDAO getInstance() {
		return instance;
	}

	public void createBook(BookRequestDTO dto) {
		Book book = new Book(dto);

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "INSERT INTO book VALUES (?,?,?,?,?,?,?)";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
//				 rent_car int(5) NOT NULL,
//				  rent_user varchar(20) NOT NULL,
//				  rent_day int(3) NOT NULL,
//				  rent_time int(20) NOT NULL,
//				  booking_day date NOT NULL,
//				  rent_venue int(5) NOT NULL,
//				  total_price int,
				this.pstmt.setInt(1, book.getRentCar());
				this.pstmt.setString(2, book.getRentUser());
				this.pstmt.setInt(3, book.getRentDay());
				this.pstmt.setInt(4, book.getRentTime());
				this.pstmt.setString(5, book.getBookingDay());
				this.pstmt.setInt(6, book.getRentVenue());
				this.pstmt.setInt(7, book.getTotalPrice());

				this.pstmt.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Book getBookByCarCode(int code) {
		Book book = null;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM book WHERE rent_car=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, code);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String user = this.rs.getString(2);
					int day = this.rs.getInt(3);
					int time = this.rs.getInt(4);
					String date = this.rs.getString(5);
					int venueCode = this.rs.getInt(6);
					int price = this.rs.getInt(7);

					book = new Book(code, user, day, time, date, venueCode, price);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}

		}

		return book;
	}

}
