package DTO;

// 예약 상세 테이블 DTO
public class ReservationDetailsDTO {
	private int resDtNum;	// 예약 상세 번호
	private int seatNum;	// 좌석 번호
	private int resNum;		// 예약 번호
	
	public ReservationDetailsDTO() {
		super();
	}

	public ReservationDetailsDTO(int resDtNum, int seatNum, int resNum) {
		super();
		this.resDtNum = resDtNum;
		this.seatNum = seatNum;
		this.resNum = resNum;
	}

	public int getResDtNum() {
		return resDtNum;
	}

	public void setResDtNum(int resDtNum) {
		this.resDtNum = resDtNum;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getResNum() {
		return resNum;
	}

	public void setResNum(int resNum) {
		this.resNum = resNum;
	}
}
