package DAO;

import java.util.ArrayList;
import java.sql.*;
import DTO.*;

public class ReservationsDAO extends DAO<ReservationsDTO> {

	private ReservationsDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB ����̹� �ε� ���� :");
			e.printStackTrace();
		}	
	}

	private static ReservationsDAO dao;

	public static ReservationsDAO getInstance() {
		if(dao == null)
			dao = new ReservationsDAO();
		return dao;
	}

	//���Ż��� �� �¼� ��������//
	public boolean insertReservation(ReservationsDTO rdto,ReservationDetailsDTO ddto) {
		
		boolean check = false;
		int resNum = 0;
		
		try{	
				String SQL = "INSERT INTO RESERVATIONS(RES_NUM,CLI_ID,SCH_NUM,";
				SQL+= "RECIPT_DATE,PRICE,RES_NUM_OF_SEAT)";
				SQL+= " VALUES(RESERVATIONS_SEQ.NEXTVAL,?,?,?,?)";
		
				conn = UtilDAO.getConnection();
				conn.setAutoCommit(false);
			   
				pstm = conn.prepareStatement(SQL);
			   

				pstm.setString(1, rdto.getCliId());
				pstm.setInt(2, rdto.getSchNum());
				//���� ����ɶ� ���� �ð�///////////////////////////////////
				pstm.setTimestamp(3, UtilDAO.NowTime());
				pstm.setInt(4, rdto.getPrice());
				pstm.setInt(5, rdto.getResNumOfSeat());
				
				pstm.executeUpdate();
				
				System.out.println("�¼� insert �Ϸ�");
				
				rs = pstm.getGeneratedKeys();
				
				if(rs.next()) {
					resNum = rs.getInt(1);
				}
				if(resNum == 0) {
					System.out.println("pk �������� �� ����");
					throw new SQLException();
				}
				System.out.println("PK �������� �Ϸ�");
				
				
				
				
				String SQL2 = "INSERT INTO RES_DETAILS(RES_DT_NUM,SEAT_NUM,RES_NUM) VALUES(RES_DT_NUM_SEQ.NEXTVAL,?,?)";
				
				pstm = conn.prepareStatement(SQL2);

				pstm.setInt(1, ddto.getSeatNum());
				pstm.setInt(2, resNum);
				
				pstm.executeUpdate();

				System.out.println("�¼� detatil insert �Ϸ�");
			   
			    pstm.executeUpdate(SQL2);
			   //commit
			   conn.commit();
			   check = true;
			}catch(SQLException se){
			   check = false;
				se.printStackTrace();
				if(conn != null) {
				   try{
					   System.out.println("sql�� ����");
					   conn.rollback();
					   System.out.println("�ѹ� ����");
				   	}catch(SQLException sel) {
					   sel.printStackTrace();
				   	}
				}	
			}finally{            
	            try{
	            	conn.setAutoCommit(true);
	                if ( rs != null ){rs.close();}   
	                if ( stmt != null ){stmt.close();}   
	                if ( conn != null ){conn.close(); }
	                if ( pstm != null ){pstm.close(); }
	            }catch(Exception ecpt){
	                throw new RuntimeException(ecpt.getMessage());
	            }            
	        }
		return check;
	}
	
	@Override
	//���� ����
	public boolean insert(ReservationsDTO e) {

		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO RESERVATIONS(RES_NUM,CLI_ID,SCH_NUM,";
					SQL+= "RECIPT_DATE,PRICE,RES_NUM_OF_SEAT)";
					SQL+= " VALUES(RESERVATIONS_SEQ.NEXTVAL,?,?,?,?)";
			
			conn = UtilDAO.getConnection();
							
			pstm = conn.prepareStatement(SQL);
			
			pstm.setString(1, e.getCliId());
			pstm.setInt(2, e.getSchNum());
			//���� ����ɶ� ���� �ð�///////////////////////////////////
			pstm.setTimestamp(3, UtilDAO.NowTime());
			pstm.setInt(4, e.getPrice());
			pstm.setInt(5, e.getResNumOfSeat());
			
			pstm.executeUpdate();
			
			check = true;
		 }catch(SQLException sqle) {
	            System.out.println("INSERT������ ���� �߻�");
	            sqle.printStackTrace();
	            check = false;
		 }finally{            
	            try{
	                if ( rs != null ){rs.close();}   
	                if ( stmt != null ){stmt.close();}   
	                if ( conn != null ){conn.close(); }
	                if ( pstm != null ){pstm.close(); }
	            }catch(Exception ecpt){
	                throw new RuntimeException(ecpt.getMessage());
	            }            
	        }
		
		return check;
	}
	
	

	//ȯ�� �Ǿ��� ��, ��¥ ������Ʈ 
	@Override
	public boolean update(ReservationsDTO e) {
		
		boolean check = false;
		
		try {
			String sql = "UPDATE RESERVATIONS SET REFUND_DATE = ? WHERE RES_NUM = ?   ";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			//ȯ�� �Ǵ°� Ȯ�εǸ� �� �� �ð����� ������Ʈ
			pstm.setTimestamp(1, UtilDAO.time(e.getRefundDate()));
			pstm.setInt(2, e.getResNum());
			pstm.executeUpdate();
			check = true;
		}catch(SQLException sqle) {
            System.out.println("UPDATE������ ���� �߻�");
            sqle.printStackTrace();
            check = false;
		}finally{            
            try{
                if ( rs != null ){rs.close();}   
                if ( stmt != null ){stmt.close();}   
                if ( conn != null ){conn.close(); }
                if ( pstm != null ){pstm.close(); }
            }catch(Exception ecpt){
                throw new RuntimeException(ecpt.getMessage());
            }            
        }
		return check;
	}
	//�¼� ��� �� �� ,pl/sql�� ������ ����
	public boolean updateCancel(ReservationsDTO e) {
		
		boolean check = false;
		
		try {
			String sql = "UPDATE RESERVATIONS SET Cancel = ? WHERE RES_NUM = ?   ";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			// ���� ��� ����� �ٷ� ���� �ð�
			pstm.setTimestamp(1, UtilDAO.NowTime());
			pstm.setInt(2, e.getResNum());
			pstm.executeUpdate();
			check = true;
		}catch(SQLException sqle) {
            System.out.println("INSERT������ ���� �߻�");
            sqle.printStackTrace();
            check = false;
		}
		return check;
	}

	//���� ���� ����
	@Override
	public boolean delete(ReservationsDTO e) {
		boolean check = false;
		try {
			String SQL = "DELETE RESERVATIONS WHERE RES_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1,e.getResNum());
			
			pstm.executeUpdate();
			check = true;
			
		}catch(SQLException sqle) {
            System.out.println("DELETE������ ���� �߻�");
            sqle.printStackTrace();
            check = false;
			
		}finally{            
            try{
                if ( rs != null ){rs.close();}   
                if ( stmt != null ){stmt.close();}   
                if ( conn != null ){conn.close(); }
                if ( pstm != null ){pstm.close(); }
            }catch(Exception ecpt){
                throw new RuntimeException(ecpt.getMessage());
            }            
        }
		return check;
	}

	//��ü ���� ���� ��ȸ
	@Override
	public Object selectAll() {
		ArrayList<ReservationsDTO> list = null; 
		
		
		try{
			String SQL = "SELECT * FROM RESERVATIONS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<ReservationsDTO>();
			
			while(rs.next()){
				ReservationsDTO reservationsDTO = new ReservationsDTO();
				reservationsDTO.setResNum(rs.getInt("RES_NUM"));
				reservationsDTO.setCliId(rs.getString("CLI_ID"));
				reservationsDTO.setSchNum(rs.getInt("SCH_NUM"));
				reservationsDTO.setCancelDate((UtilDAO.time(rs.getTimestamp("CANCEL_DATE"))));
				reservationsDTO.setRefundDate(UtilDAO.time(rs.getTimestamp("REFUND_DATE")));
				reservationsDTO.setReceiptDate(UtilDAO.time(rs.getTimestamp("RECEIPT_DATE")));
				reservationsDTO.setPrice(rs.getInt("PRICE"));
				reservationsDTO.setResNumOfSeat(rs.getInt("RES_NUM_OF_SEAT"));
            	list.add(reservationsDTO);
            };
			
		}catch (SQLException sqle) {
            System.out.println("SELECT������ ���� �߻�");
            sqle.printStackTrace();            
        } 
		return list;
	}
	//���� ���� ���� ���� ���� ��ȸ
	public Object select(String cliId) {
		ArrayList<ReservationsDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM RESERVATIONS WHERE CLI_ID = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1,cliId);
			
			rs = pstm.executeQuery();
			
			list = new ArrayList<ReservationsDTO>();
			
			while(rs.next()){
				ReservationsDTO reservationsDTO = new ReservationsDTO();
				reservationsDTO.setResNum(rs.getInt("RES_NUM"));
				reservationsDTO.setCliId(rs.getString("CLI_ID"));
				reservationsDTO.setSchNum(rs.getInt("SCH_NUM"));
				reservationsDTO.setCancelDate((UtilDAO.time(rs.getTimestamp("CANCEL_DATE"))));
				reservationsDTO.setRefundDate(UtilDAO.time(rs.getTimestamp("REFUND_DATE")));
				reservationsDTO.setReceiptDate(UtilDAO.time(rs.getTimestamp("RECEIPT_DATE")));
				reservationsDTO.setPrice(rs.getInt("PRICE"));
				reservationsDTO.setResNumOfSeat(rs.getInt("RES_NUM_OF_SEAT"));
            	list.add(reservationsDTO);
            };
			
		}catch (SQLException sqle) {
            System.out.println("SELECT������ ���� �߻�");
            sqle.printStackTrace();            
        } finally{            
            try{
                if ( rs != null ){rs.close();}   
                if ( stmt != null ){stmt.close();}   
                if ( conn != null ){conn.close(); }
                if ( pstm != null ){pstm.close(); }
            }catch(Exception ecpt){
                throw new RuntimeException(ecpt.getMessage());
            }            
        }
		return list;
	}

}
