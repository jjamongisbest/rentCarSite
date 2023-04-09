package vehicle;

public class VehicleRequestDTO {

	private int carCode;
	private String carName;
	private int hourPrice;
	private int seat;
	
	public VehicleRequestDTO (int code, String name, int price, int seat) {
		this.carCode = code;
		this.carName = name;
		this.hourPrice = price;
		this.seat = seat;
	}

	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int car_code) {
		this.carCode = car_code;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String car_name) {
		this.carName = car_name;
	}

	public int getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(int hour_price) {
		this.hourPrice = hour_price;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
