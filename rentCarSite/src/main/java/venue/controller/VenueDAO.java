package venue.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;
import venue.Venue;

public class VenueDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private VenueDAO() {
	}

	private static VenueDAO instance = new VenueDAO();

	public static VenueDAO getInstance() {
		return instance;
	}

	public ArrayList<Venue> getVenueAll() {
		ArrayList<Venue> list = new ArrayList<Venue>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM venue ORDER BY venue_code";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int code = this.rs.getInt(1);
					String name = this.rs.getString(2);

					Venue vn = new Venue(code, name);
					list.add(vn);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return list;
	}

	public Venue getVenueByCode(int code) {
		Venue ve = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM venue WHERE venue_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, code);
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					String name = this.rs.getString(2);

					ve = new Venue(code, name);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return ve;
	}

}
