package DAO;

import DTO.*;

public class test {
	public static void main(String [] args) {
		
		System.out.println("����1");
		
		ReservationsDAO dao = ReservationsDAO.getInstance();
		ReservationsDAO dao2 = ReservationsDAO.getInstance();
		
		System.out.println("33");
		ReservationsDTO rdto = new ReservationsDTO();
		ReservationDetailsDTO ddto = new ReservationDetailsDTO();
		
		
		rdto.setSchNum(1);//(//FK�־);
		rdto.setCliId("fk");//FK
		rdto.setResNumOfSeat(3);
		rdto.setPrice(27000);
		
		
		//�ð��� java timestamp��
		// �����ؼ� ������		
		
		//ddto.setNum(resNum);
		ddto.setSeatNum(2);
		
		
		System.out.println("����");
		dao.insertReservation(rdto,ddto);
		System.out.println("��");
		
		dao2.selectAll();
		
		
	}
}
