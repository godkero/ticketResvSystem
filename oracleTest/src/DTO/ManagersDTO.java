package DTO;

import java.time.*;

// 담당자 테이블 DTO
public class ManagersDTO {
	private String manId;			// 관리자 ID
	private LocalDate hiredDate;	// 입사일
	private LocalDate resignedDate;	// 퇴사일
	private String manName;			// 관리자 이름
	private String manPassword;		// 관리자 비밀번호
	
	public ManagersDTO() {
		super();
	}
	
	public ManagersDTO(String manId, LocalDate hiredDate, LocalDate resignedDate, String manName, String manPassword) {
		super();
		this.manId = manId;
		this.hiredDate = hiredDate;
		this.resignedDate = resignedDate;
		this.manName = manName;
		this.manPassword = manPassword;
	}

	public String getManId() {
		return manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}

	public LocalDate getDateHired() {
		return hiredDate;
	}

	public void setDateHired(LocalDate hiredDate) {
		this.hiredDate = hiredDate;
	}

	public LocalDate getDateResigned() {
		return resignedDate;
	}

	public void setDateResigned(LocalDate resignedDate) {
		this.resignedDate = resignedDate;
	}

	public String getManName() {
		return manName;
	}

	public void setManName(String manName) {
		this.manName = manName;
	}

	public String getManPassword() {
		return manPassword;
	}

	public void setManPassword(String manPassword) {
		this.manPassword = manPassword;
	}
}
