package DTO;

// 좌석 테이블 DTO
public class SeatsDTO {
	private int seatNum;			// 좌석 번호
	private String sTspecialNote;	// 좌석 특이사항(유아석, 장애인석, ...)
	private int scrHallNum;			// 상영관 번호
	private String seatName;		// 좌석 이름 (A12, J5, B17, ...)
	
	public SeatsDTO() {
		super();
	}

	public SeatsDTO(int seatNum, String sTspecialNote, int scrHallNum, String seatName) {
		super();
		this.seatNum = seatNum;
		this.sTspecialNote = sTspecialNote;
		this.scrHallNum = scrHallNum;
		this.seatName = seatName;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public String getsTspecialNote() {
		return sTspecialNote;
	}

	public void setsTspecialNote(String sTspecialNote) {
		this.sTspecialNote = sTspecialNote;
	}

	public int getScrHallNum() {
		return scrHallNum;
	}

	public void setScrHallNum(int scrHallNum) {
		this.scrHallNum = scrHallNum;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
}
