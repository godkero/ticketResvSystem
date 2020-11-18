package DTO;

import java.time.*;

// ���� ���̺� DTO
public class ReservationsDTO {
	private int resNum;					// ���� ��ȣ
	private String cliId;				// �� ID
	private int schNum;					// ��ȭ ������ ��ȣ
	private LocalDateTime cancelDate;	// �����
	private LocalDateTime refundDate;	// ȯ����
	private LocalDateTime receiptDate;	// ������
	private int price;					// ����
	private int resNumOfSeat;			// ������ �¼� ��
	
	public ReservationsDTO() {
		super();
	}

	public ReservationsDTO(int resNum, String cliId, int schNum, LocalDateTime cancelDate, LocalDateTime refundDate, LocalDateTime receiptDate,
			int price, int resNumOfSeat) {
		super();
		this.resNum = resNum;
		this.cliId = cliId;
		this.schNum = schNum;
		this.cancelDate = cancelDate;
		this.refundDate = refundDate;
		this.receiptDate = receiptDate;
		this.price = price;
		this.resNumOfSeat = resNumOfSeat;
	}

	public int getResNum() {
		return resNum;
	}

	public void setResNum(int resNum) {
		this.resNum = resNum;
	}

	public String getCliId() {
		return cliId;
	}

	public void setCliId(String cliId) {
		this.cliId = cliId;
	}

	public int getSchNum() {
		return schNum;
	}

	public void setSchNum(int schNum) {
		this.schNum = schNum;
	}

	public LocalDateTime getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(LocalDateTime cancelDate) {
		this.cancelDate = cancelDate;
	}

	public LocalDateTime getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(LocalDateTime refundDate) {
		this.refundDate = refundDate;
	}

	public LocalDateTime getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDateTime receiptDate) {
		this.receiptDate = receiptDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getResNumOfSeat() {
		return resNumOfSeat;
	}

	public void setResNumOfSeat(int resNumOfSeat) {
		this.resNumOfSeat = resNumOfSeat;
	}
}