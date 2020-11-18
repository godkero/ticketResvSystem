package DTO;

import java.time.*;

// ��ȭ ������ ���̺� DTO
public class MovieSchedulesDTO {
	private int schNum;					// ��ȭ ������ ��ȣ
	private int movNum;					// ��ȭ ��ȣ
	private int scrHallNum;				// �󿵰� ��ȣ
	private LocalDateTime schStartTime; // �� ���� �ð�
	private LocalDateTime schEndTime; 	// �� ���� �ð�
	
	public MovieSchedulesDTO() {
		super();
	}
	
	public MovieSchedulesDTO(int schNum, int movNum, int scrHallNum, LocalDateTime schStartTime, LocalDateTime schEndTime) {
		super();
		this.schNum = schNum;
		this.movNum = movNum;
		this.scrHallNum = scrHallNum;
		this.schStartTime = schStartTime;
		this.schEndTime = schEndTime;
	}

	public int getSchNum() {
		return schNum;
	}

	public void setSchNum(int schNum) {
		this.schNum = schNum;
	}

	public int getMovNum() {
		return movNum;
	}

	public void setMovNum(int movNum) {
		this.movNum = movNum;
	}

	public int getScrHallNum() {
		return scrHallNum;
	}

	public void setScrHallNum(int scrHallNum) {
		this.scrHallNum = scrHallNum;
	}

	public LocalDateTime getSchStartTime() {
		return schStartTime;
	}

	public void setSchStartTime(LocalDateTime schStartTime) {
		this.schStartTime = schStartTime;
	}

	public LocalDateTime getSchEndTime() {
		return schEndTime;
	}

	public void setSchEndTime(LocalDateTime schEndTime) {
		this.schEndTime = schEndTime;
	}
}
