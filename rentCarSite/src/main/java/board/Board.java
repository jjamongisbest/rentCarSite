package board;

public class Board {

	private int code;
	private String title;
	private String main;
	private String modifiedDate; // 수정
	private String registerDate; // 등록
	private String writer;

	public Board(int code, String title, String main, String modifiedDate, String registerDate, String writer) {
		this.code = code;
		this.title = title;
		this.main = main;
		this.modifiedDate = modifiedDate;
		this.registerDate = registerDate;
		this.writer = writer;
	}
	
	public Board(BoardRequestDTO dto) {
		this.code = dto.getCode();
		this.title = dto.getTitle();
		this.main = dto.getMain();
		this.modifiedDate = dto.getModifiedDate();
		this.registerDate = dto.getRegisterDate();
		this.writer = dto.getWriter();
	}

	public int getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getMain() {
		return main;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public String getWriter() {
		return writer;
	}


}
