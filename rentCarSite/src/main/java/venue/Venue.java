package venue;

import venue.controller.VenueDAO;

public class Venue {

	private int venueCode;
	private String venueName;
	
	public Venue(int code, String name) {
		this.venueCode = code;
		this.venueName = name;
	}
	
	public Venue(VenueRequestDTO dto) {
		this.venueCode = dto.getVenueCode();
		this.venueName = dto.getVenueName();
	}

	public int getVenueCode() {
		return venueCode;
	}

	public String getVenueName() {
		return venueName;
	}
	
}
