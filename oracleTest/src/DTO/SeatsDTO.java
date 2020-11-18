package DTO;

// �¼� ���̺� DTO
public class SeatsDTO {
	private int seatNum;			// �¼� ��ȣ
	private String sTspecialNote;	// �¼� Ư�̻���(���Ƽ�, ����μ�, ...)
	private int scrHallNum;			// �󿵰� ��ȣ
	private String seatName;		// �¼� �̸� (A12, J5, B17, ...)
	
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
