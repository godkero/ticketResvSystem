package DTO;

import java.math.BigDecimal;
import java.time.*;

// °èÁÂ Å×ÀÌºí DTO
public class AccountsDTO {
	private int accNum;				// °èÁÂ ¹øÈ£
	private LocalDate createDate;	// °èÁÂ °³¼³ÀÏ
	private String bank;			// ÀºÇà
	private BigDecimal balance;		// ÀÜ°í
	private String cliId;		// °í°´ ID
	private String manId;
	
	public AccountsDTO() {
		super();
	}

	public AccountsDTO(int accNum, LocalDate createDate, String bank, BigDecimal balance, String cliId,String manId) {
		super();
		this.accNum = accNum;
		this.createDate = createDate;
		this.bank = bank;
		this.balance = balance;
		this.cliId = cliId;
		this.manId = manId;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCliId() {
		return cliId;
	}

	public void setCliId(String cliId) {
		this.cliId = cliId;
	}
	
	public String getmanId() {
		return manId;
	}

	public void setmanId(String manId) {
		this.manId = manId;
	}
}