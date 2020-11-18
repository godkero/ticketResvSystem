package DTO;

// ���� �� ���̺� DTO
public class ReservationDetailsDTO {
	private int resDtNum;	// ���� �� ��ȣ
	private int seatNum;	// �¼� ��ȣ
	private int resNum;		// ���� ��ȣ
	
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
