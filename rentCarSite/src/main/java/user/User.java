package user;

import user.controller.UserDAO;

public class User {
	// getter only
	
	// users table 참조
	private String user_id;
	private String name;
	private String phone;
	private String password;
	private String sign_date;
	private String email;
	
	public User(String id, String name, String phone, String password, String date, String email) {
		this.user_id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.sign_date = date;
		this.email = email;
	}
	
	public User(UserRequestDTO userDto) {
		
		this.user_id = userDto.getUser_id();
		this.name = userDto.getName();
		this.phone = userDto.getPhone();
		this.password = userDto.getPassword();
		this.sign_date = userDto.getSign_date();
		this.email = userDto.getEmail();
	}

	public String getUser_id() {
		return user_id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public String getSign_date() {
		return sign_date;
	}

	public String getEmail() {
		return email;
	}
		
		
}
