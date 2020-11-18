package DAO;

import DTO.*;

public class test {
	public static void main(String [] args) {
		
		System.out.println("시작1");
		
		ReservationsDAO dao = ReservationsDAO.getInstance();
		ReservationsDAO dao2 = ReservationsDAO.getInstance();
		
		System.out.println("33");
		ReservationsDTO rdto = new ReservationsDTO();
		ReservationDetailsDTO ddto = new ReservationDetailsDTO();
		
		
		rdto.setSchNum(1);//(//FK넣어서);
		rdto.setCliId("fk");//FK
		rdto.setResNumOfSeat(3);
		rdto.setPrice(27000);
		
		
		//시간은 java timestamp로
		// 수정해서 쓰세요		
		
		//ddto.setNum(resNum);
		ddto.setSeatNum(2);
		
		
		System.out.println("시작");
		dao.insertReservation(rdto,ddto);
		System.out.println("끝");
		
		dao2.selectAll();
		
		
	}
}
