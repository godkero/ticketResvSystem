package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.time.*;
import java.sql.*;

public class UtilDAO {
	
	//connetion 객체 불러오기
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String user = "TEST3";
			String pw = "123";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	}
	
	//설정 날짜에 따른 날짜 변환 메소드
	public static Date date(LocalDate setDate){
		Date date = Date.valueOf(setDate);
		return date;		
	}
	public static LocalDate date(Date date) {
		LocalDate ld = date.toLocalDate();
		return ld;
	}
	
	//설정 시간에 따른 시간 변환 메소드
	public static Timestamp time(LocalDateTime setDateTime) {
		Timestamp ts = Timestamp.valueOf(setDateTime);
		return ts;
	}
	
	public static LocalDateTime time(Timestamp time) {
		LocalDateTime ldt = time.toLocalDateTime();
		return ldt;
	}

	//현재 시간 데이터베이스에 삽입 메소드
	public static Date nowDate(){
		 
		LocalDate now = LocalDate.now();
	    Date sqlDate=  Date.valueOf(now);
		return sqlDate;
	}
	//현재 날짜 데이터베이스에 삽입 메소드
	public static Timestamp NowTime(){

		LocalDateTime now = LocalDateTime.now();
		Timestamp sqlDateTime = Timestamp.valueOf(now);
		return sqlDateTime;
	}
}
