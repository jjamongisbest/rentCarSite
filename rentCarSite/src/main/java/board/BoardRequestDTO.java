package board;

public class BoardRequestDTO {

	private int code;
	private String title;
	private String main;
	private String modifiedDate; // 수정
	private String registerDate; // 등록
	private String writer;
	
	public BoardRequestDTO(int code, String title, String main, String modifiedDate, String registerDate, String writer) {
		this.code = code;
		this.title = title;
		this.main = main;
		this.modifiedDate = modifiedDate;
		this.registerDate = registerDate;
		this.writer = writer;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
