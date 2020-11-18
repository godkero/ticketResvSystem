package DTO;

import java.time.*;

// 영화 스케줄 테이블 DTO
public class MovieSchedulesDTO {
	private int schNum;					// 영화 스케줄 번호
	private int movNum;					// 영화 번호
	private int scrHallNum;				// 상영관 번호
	private LocalDateTime schStartTime; // 상영 시작 시간
	private LocalDateTime schEndTime; 	// 상영 종료 시간
	
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
