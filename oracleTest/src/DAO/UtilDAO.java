package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.time.*;
import java.sql.*;

public class UtilDAO {
	
	//connetion ��ü �ҷ�����
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String user = "TEST3";
			String pw = "123";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database�� ����Ǿ����ϴ�.\n");

		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	}
	
	//���� ��¥�� ���� ��¥ ��ȯ �޼ҵ�
	public static Date date(LocalDate setDate){
		Date date = Date.valueOf(setDate);
		return date;		
	}
	public static LocalDate date(Date date) {
		LocalDate ld = date.toLocalDate();
		return ld;
	}
	
	//���� �ð��� ���� �ð� ��ȯ �޼ҵ�
	public static Timestamp time(LocalDateTime setDateTime) {
		Timestamp ts = Timestamp.valueOf(setDateTime);
		return ts;
	}
	
	public static LocalDateTime time(Timestamp time) {
		LocalDateTime ldt = time.toLocalDateTime();
		return ldt;
	}

	//���� �ð� �����ͺ��̽��� ���� �޼ҵ�
	public static Date nowDate(){
		 
		LocalDate now = LocalDate.now();
	    Date sqlDate=  Date.valueOf(now);
		return sqlDate;
	}
	//���� ��¥ �����ͺ��̽��� ���� �޼ҵ�
	public static Timestamp NowTime(){

		LocalDateTime now = LocalDateTime.now();
		Timestamp sqlDateTime = Timestamp.valueOf(now);
		return sqlDateTime;
	}
}
