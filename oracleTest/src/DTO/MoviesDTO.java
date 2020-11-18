package DTO;

import java.time.*;
import java.sql.Blob;
import java.math.BigDecimal;

// 영화 테이블 DTO
public class MoviesDTO {
	private int movNum;					// 영화 번호
	private String movName;				// 영화 이름
	private String actorInfo;			// 배우 정보	// 배우 간의 구분은 '/' 
	private String director;			// 감독
	private String story;				// 줄거리
	private LocalDate openDate; 		// 개봉일
	private int ageLimit;				// 나이제한
	private Blob poster; 				// 영화 포스터
	private int movRunTime;				// 영화 상영시간(단위 : 분)
	private BigDecimal totalAudiences;	// 영화 총 관객수(= 누적 관객수)
	
	public MoviesDTO() {
		super();
	}

	public MoviesDTO(int movNum, String movName, String actorInfo, String director, String story, LocalDate openDate,
			int ageLimit, Blob poster, int movRunTime, BigDecimal totalAudiences) {
		super();
		this.movNum = movNum;
		this.movName = movName;
		this.actorInfo = actorInfo;
		this.director = director;
		this.story = story;
		this.openDate = openDate;
		this.ageLimit = ageLimit;
		this.poster = poster;
		this.movRunTime = movRunTime;
		this.totalAudiences = totalAudiences;
	}

	public int getMovNum() {
		return movNum;
	}

	public void setMovNum(int movNum) {
		this.movNum = movNum;
	}

	public String getMovName() {
		return movName;
	}

	public void setMovName(String movName) {
		this.movName = movName;
	}

	public String getActorInfo() {
		return actorInfo;
	}

	public void setActorInfo(String actorInfo) {
		this.actorInfo = actorInfo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public LocalDate getReleaseDay() {
		return openDate;
	}

	public void setReleaseDay(LocalDate openDate) {
		this.openDate = openDate;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public Blob getPoster() {
		return poster;
	}

	public void setPoster(Blob poster) {
		this.poster = poster;
	}

	public int getMovRunTime() {
		return movRunTime;
	}

	public void setMovRunTime(int movRunTime) {
		this.movRunTime = movRunTime;
	}

	public BigDecimal getTotalAudiences() {
		return totalAudiences;
	}

	public void setTotalAudiences(BigDecimal totalAudiences) {
		this.totalAudiences = totalAudiences;
	}
}
