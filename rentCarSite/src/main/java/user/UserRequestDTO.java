package user;

public class UserRequestDTO {

	// users table 참조
	private String user_id;
	private String name;
	private String phone;
	private String password;
	private String sign_date;
	private String email;

	public UserRequestDTO(String id, String name, String phone, String password, String date, String email) {
		this.user_id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.sign_date = date;
		this.email = email;
	}
	
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSign_date() {
		return sign_date;
	}

	public void setSign_date(String sign_date) {
		this.sign_date = sign_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
