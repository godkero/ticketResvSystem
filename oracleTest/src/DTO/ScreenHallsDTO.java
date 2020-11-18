package DTO;

// �󿵰� ���̺� DTO
public class ScreenHallsDTO {
	private int scrHallNum;			// �󿵰� ��ȣ
	private int numOfSeat;			// �󿵰� �¼� ��
	private String sHspecialNote;	// �󿵰� Ư�̻���(3D, 4DX, ħ�뼮, ...)
	private String theatName;		// ��ȭ�� �̸�
	private String scrHallName;		// �󿵰� �̸�
	
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
