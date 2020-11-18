package DTO;

// °í°´ Å×ÀÌºí DTO
public class ClientsDTO {
	private String cliId;			// °í°´ ID
	private String cliPassword;		// °í°´ ºñ¹Ð¹øÈ£
	private String cliName;			// °í°´ ÀÌ¸§
	private String cliCallNum;		// °í°´ ÀüÈ­¹øÈ£
	private String cliRRN;			// °í°´ ÁÖ¹Î¹øÈ£(RRN)
	private String cliEmail;		// °í°´ ÀÌ¸ÞÀÏ
	
	public ClientsDTO() {
		super();
	}
	
	public ClientsDTO(String cliId, String cliPassword, String cliName, String cliCallNum, String cliRRN,
			String cliEmail) {
		super();
		this.cliId = cliId;
		this.cliPassword = cliPassword;
		this.cliName = cliName;
		this.cliCallNum = cliCallNum;
		this.cliRRN = cliRRN;
		this.cliEmail = cliEmail;
	}
	
	public String getCliId() {
		return cliId;
	}
	
	public void setCliId(String cliId) {
		this.cliId = cliId;
	}
	
	public String getCliPassword() {
		return cliPassword;
	}
	
	public void setCliPassword(String cliPassword) {
		this.cliPassword = cliPassword;
	}
	
	public String getCliName() {
		return cliName;
	}
	
	public void setCliName(String cliName) {
		this.cliName = cliName;
	}
	
	public String getCliCallNum() {
		return cliCallNum;
	}
	
	public void setCliCallNum(String cliCallNum) {
		this.cliCallNum = cliCallNum;
	}
	
	public String getCliRRN() {
		return cliRRN;
	}
	
	public void setCliRRN(String cliRRN) {
		this.cliRRN = cliRRN;
	}
	
	public String getCliEmail() {
		return cliEmail;
	}
	
	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}
}
