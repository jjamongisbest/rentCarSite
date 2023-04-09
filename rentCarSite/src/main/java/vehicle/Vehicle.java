package vehicle;

import vehicle.controller.VehicleDAO;

public class Vehicle {

//	INSERT INTO car (car_code, car_name, hour_price, seat)

	private int car_code;
	private String car_name;
	private int hour_price;
	private int seat;
	private String image;
	
	public Vehicle (int code, String name, int price, int seat) {
		this.car_code = code;
		this.car_name = name;
		this.hour_price = price;
		this.seat = seat;
	}
	
	public Vehicle(VehicleRequestDTO vr) {
		this.car_code = vr.getCarCode();
		this.car_name = vr.getCarName();
		this.hour_price = vr.getHourPrice();
		this.seat = vr.getSeat();
	}
	
	
	public int getCarCode() {
		return this.car_code;
	}

	public String getCarName() {
		return this.car_name;
	}

	public int getHourPrice() {
		return this.hour_price;
	}

	public int getSeat() {
		return this.seat;
	}
	
	public String getImage() {
		return this.image;
	}

	
}
