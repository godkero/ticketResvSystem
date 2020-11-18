package DTO;

// 상영관 테이블 DTO
public class ScreenHallsDTO {
	private int scrHallNum;			// 상영관 번호
	private int numOfSeat;			// 상영관 좌석 수
	private String sHspecialNote;	// 상영관 특이사항(3D, 4DX, 침대석, ...)
	private String theatName;		// 영화관 이름
	private String scrHallName;		// 상영관 이름
	
	public ScreenHallsDTO() {
		super();
	}

	public ScreenHallsDTO(int scrHallNum, int numOfSeat, String sHspecialNote, String theatName, String scrHallName) {
		super();
		this.scrHallNum = scrHallNum;
		this.numOfSeat = numOfSeat;
		this.sHspecialNote = sHspecialNote;
		this.theatName = theatName;
		this.scrHallName = scrHallName;
	}

	public int getScrHallNum() {
		return scrHallNum;
	}

	public void setScrHallNum(int scrHallNum) {
		this.scrHallNum = scrHallNum;
	}

	public int getNumOfSeat() {
		return numOfSeat;
	}

	public void setNumOfSeat(int numOfSeat) {
		this.numOfSeat = numOfSeat;
	}

	public String getsHspecialNotes() {
		return sHspecialNote;
	}

	public void setsHspecialNotes(String sHspecialNote) {
		this.sHspecialNote = sHspecialNote;
	}

	public String getTheatName() {
		return theatName;
	}

	public void setTheatName(String theatName) {
		this.theatName = theatName;
	}

	public String getScrHallName() {
		return scrHallName;
	}

	public void setScrHallName(String scrHallName) {
		this.scrHallName = scrHallName;
	}
}
