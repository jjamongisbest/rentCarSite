package venue;

public class VenueRequestDTO {

	private int venueCode;
	private String venueName;

	public VenueRequestDTO(int code, String name) {
		this.venueCode = code;
		this.venueName = name;
	}

	public int getVenueCode() {
		return venueCode;
	}

	public void setVenueCode(int venueCode) {
		this.venueCode = venueCode;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

}
