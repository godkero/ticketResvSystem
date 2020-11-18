package DTO;


import java.time.*;

// �� ���̺� DTO
public class RatingsDTO {
	private int ratingNum;				// �� ��ȣ
	private LocalDateTime writeDate;	// �ۼ���
	private int starRating;				// ����
	private String content;				// ����
	private String writerId;			// �ۼ��� ID
	private int movNum;					// ��ȭ ��ȣ
	
	public RatingsDTO() {
		super();
	}

	public RatingsDTO(int ratingNum, LocalDateTime writeDate, int starRating, String content, String writerId, int movNum) {
		super();
		this.ratingNum = ratingNum;
		this.writeDate = writeDate;
		this.starRating = starRating;
		this.content = content;
		this.writerId = writerId;
		this.movNum = movNum;
	}

	public int getRatingNum() {
		return ratingNum;
	}

	public void setRatingNum(int ratingNum) {
		this.ratingNum = ratingNum;
	}

	public LocalDateTime getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriterId() {
		return writerId;
	}

	public void settWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getMovNum() {
		return movNum;
	}

	public void setMovNum(int movNum) {
		this.movNum = movNum;
	}
}
