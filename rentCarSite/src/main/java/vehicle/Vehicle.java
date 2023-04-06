package vehicle;

import vehicle.controller.VehicleDAO;

public class Vehicle {

//	INSERT INTO car (car_code, car_name, hour_price, seat)

	private int car_code;
	private String car_name;
	private int hour_price;
	private int seat;
	
	public Vehicle (int code, String name, int price, int seat) {
		this.car_code = code;
		this.car_name = name;
		this.hour_price = price;
		this.seat = seat;
	}
	
	public Vehicle(VehicleRequestDTO vr) {
		this.car_code = vr.getCar_code();
		this.car_name = vr.getCar_name();
		this.hour_price = vr.getHour_price();
		this.seat = vr.getSeat();
	}
	
	
	public int getCar_code() {
		return car_code;
	}

	public String getCar_name() {
		return car_name;
	}

	public int getHour_price() {
		return hour_price;
	}

	public int getSeat() {
		return seat;
	}

	
}
