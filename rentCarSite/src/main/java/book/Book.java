package book;

public class Book {

	// rent_car, rent_user, rent_day, rent_time, booking_day, rent_venue, total_price

	
	private int rentCar;
	private String rentUser;
	private int rentDay;
	private int rentTime;
	private String bookingDay;
	private int rentVenue;
	private int totalPrice;
	
	public Book(int carCode, String user, int day, int time, String bookingDay, int venueCode, int total) {
		this.rentCar = carCode;
		this.rentUser = user;
		this.rentDay = day;
		this.rentTime = time;
		this.bookingDay = bookingDay;
		this.rentVenue = venueCode;
		this.totalPrice = total;
	}
	
	public Book(BookRequestDTO dto) {
		this.rentCar = dto.getRentCar();
		this.rentUser = dto.getRentUser();
		this.rentDay = dto.getRentDay();
		this.rentTime = dto.getRentTime();
		this.bookingDay = dto.getBookingDay();
		this.rentVenue = dto.getRentVenue();
		this.totalPrice = dto.getTotalPrice();
	}
	
	public int getRentCar() {
		return rentCar;
	}

	public String getRentUser() {
		return rentUser;
	}

	public int getRentDay() {
		return rentDay;
	}

	public int getRentTime() {
		return rentTime;
	}

	public String getBookingDay() {
		return bookingDay;
	}

	public int getRentVenue() {
		return rentVenue;
	}

	public int getTotalPrice() {
		return totalPrice;
	}


	
	
	
}
