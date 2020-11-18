package DTO;

import java.time.*;

// ����� ���̺� DTO
public class ManagersDTO {
	private String manId;			// ������ ID
	private LocalDate hiredDate;	// �Ի���
	private LocalDate resignedDate;	// �����
	private String manName;			// ������ �̸�
	private String manPassword;		// ������ ��й�ȣ
	
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
