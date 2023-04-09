package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;
import vehicle.Vehicle;

public class VehicleDAO {
//	INSERT INTO car (car_code, car_name, hour_price, seat)

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private VehicleDAO() {
	}

	private static VehicleDAO instance = new VehicleDAO();

	public static VehicleDAO getInstance() {
		return instance;
	}

	public ArrayList<Vehicle> getCarAll() {

		ArrayList<Vehicle> list = new ArrayList<Vehicle>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM car";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int code = this.rs.getInt(1);
					String name = this.rs.getString(2);
					int price = this.rs.getInt(3);
					int seat = this.rs.getInt(4);

					Vehicle vehicle = new Vehicle(code, name, price, seat);
					list.add(vehicle);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return list;
	}

	public Vehicle getCarByCode(int code) {
		Vehicle ve = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {

			String sql = "SELECT * FROM car WHERE car_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, code);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String carName = this.rs.getString(2);
					int price = this.rs.getInt(3);
					int seat = this.rs.getInt(4);

					ve = new Vehicle(code, carName, price, seat);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return ve;
	}

	public String getCodeByCarName(String name) {
		String code = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {

			String sql = "SELECT car_code FROM car WHERE car_name=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				code = String.valueOf(this.rs.getInt(1));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return code;
	}

}
