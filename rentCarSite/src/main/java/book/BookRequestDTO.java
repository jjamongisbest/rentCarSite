package book;

public class BookRequestDTO {

	private int rentCar;
	private String rentUser;
	private int rentDay;
	private int rentTime;
	private String bookingDay;
	private int rentVenue;
	private int totalPrice;
	
	public BookRequestDTO(int carCode, String user, int day, int time, String bookingDay, int venueCode, int total) {
		this.rentCar = carCode;
		this.rentUser = user;
		this.rentDay = day;
		this.rentTime = time;
		this.bookingDay = bookingDay;
		this.rentVenue = venueCode;
		this.totalPrice = total;
	}

	public int getRentCar() {
		return rentCar;
	}

	public void setRentCar(int rentCar) {
		this.rentCar = rentCar;
	}

	public String getRentUser() {
		return rentUser;
	}

	public void setRentUser(String rentUser) {
		this.rentUser = rentUser;
	}

	public int getRentDay() {
		return rentDay;
	}

	public void setRentDay(int rentDay) {
		this.rentDay = rentDay;
	}

	public int getRentTime() {
		return rentTime;
	}

	public void setRentTime(int rentTime) {
		this.rentTime = rentTime;
	}

	public String getBookingDay() {
		return bookingDay;
	}

	public void setBookingDay(String bookingDay) {
		this.bookingDay = bookingDay;
	}

	public int getRentVenue() {
		return rentVenue;
	}

	public void setRentVenue(int rentVenue) {
		this.rentVenue = rentVenue;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
