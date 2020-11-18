package DTO;


import java.time.*;

// 평가 테이블 DTO
public class RatingsDTO {
	private int ratingNum;				// 평가 번호
	private LocalDateTime writeDate;	// 작성일
	private int starRating;				// 별점
	private String content;				// 내용
	private String writerId;			// 작성자 ID
	private int movNum;					// 영화 번호
	
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
