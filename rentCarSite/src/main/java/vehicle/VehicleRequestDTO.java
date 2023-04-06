package vehicle;

public class VehicleRequestDTO {

	private int car_code;
	private String car_name;
	private int hour_price;
	private int seat;
	
	public VehicleRequestDTO (int code, String name, int price, int seat) {
		this.car_code = code;
		this.car_name = name;
		this.hour_price = price;
		this.seat = seat;
	}

	public int getCar_code() {
		return car_code;
	}

	public void setCar_code(int car_code) {
		this.car_code = car_code;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public int getHour_price() {
		return hour_price;
	}

	public void setHour_price(int hour_price) {
		this.hour_price = hour_price;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
