package DTO;

import java.time.*;
import java.math.BigDecimal;

// 영화관 테이블 DTO
public class TheatersDTO {
	private String theatName;		// 영화관 이름
	private String address;			// 영화관 주소
	private LocalDate closedDate;	// 휴무일
	private BigDecimal theatIncome;	// 영화관 수입
	private int numOfEmployee;		// 영화관 직원 수
	
	public TheatersDTO() {
		super();
	}

	public TheatersDTO(String theatName, String address, LocalDate closedDate, BigDecimal theatIncome, int numOfEmployee) {
		super();
		this.theatName = theatName;
		this.address = address;
		this.closedDate = closedDate;
		this.theatIncome = theatIncome;
		this.numOfEmployee = numOfEmployee;
	}

	public String getTheatName() {
		return theatName;
	}

	public void setTheatName(String theatName) {
		this.theatName = theatName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}

	public BigDecimal getTheatIncome() {
		return theatIncome;
	}

	public void setTheatIncome(BigDecimal theatIncome) {
		this.theatIncome = theatIncome;
	}

	public int getNumOfEmployee() {
		return numOfEmployee;
	}

	public void setNumOfEmployee(int numOfEmployee) {
		this.numOfEmployee = numOfEmployee;
	}
}
