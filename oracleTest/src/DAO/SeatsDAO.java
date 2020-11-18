package DAO;

import DTO.*;
import java.sql.*;
import java.util.*;

public class SeatsDAO extends DAO<SeatsDTO> {
	

	private SeatsDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static SeatsDAO dao;

	public static SeatsDAO getInstance() {
		if(dao == null)
			dao = new SeatsDAO();
		return dao;
	}

	@Override
	public boolean insert(SeatsDTO dto) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO SEATS(SEAT_NUM,SEAT_SPECIAL_NOTE,SH_NUM,SEAT_NAME) VALUES(SEAT_NUM_SEQ.NEXTVAL,?,?,?)";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, dto.getsTspecialNote());
			pstm.setInt(2, dto.getScrHallNum());
			pstm.setString(3, dto.getSeatName());
			
			pstm.executeUpdate();
			
			check = true;
		 }catch(SQLException sqle) {
	            System.out.println("INSERT문에서 오류 발생");
	            sqle.printStackTrace();
	            check = false;
		 } finally{            
	            try{
	                if ( rs != null ){rs.close();}   
	                if ( stmt != null ){stmt.close();}   
	                if ( conn != null ){conn.close(); }
	                if ( pstm != null ){pstm.close(); }
	            }catch(Exception e){
	                throw new RuntimeException(e.getMessage());
	            }            
	        }
		
		return check;
	}
	@Override
	public boolean update(SeatsDTO dto) {
		boolean check = false;
		
		try {
			String sql = "UPDATE SEATS SET SEAT_SPECIAL_NOTE = ?, SH_NUM = ?, SEAT_NAME = ? WHERE SEAT_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, dto.getsTspecialNote());
			pstm.setInt(2, dto.getScrHallNum());
			pstm.setString(3, dto.getSeatName());
			pstm.setInt(4, dto.getSeatNum());
			pstm.executeUpdate();
			check = true;
		}catch(SQLException sqle) {
            System.out.println("UPDATE문에서 오류 발생");
            sqle.printStackTrace();
            check = false;
		} finally{            
            try{
                if ( rs != null ){rs.close();}   
                if ( stmt != null ){stmt.close();}   
                if ( conn != null ){conn.close(); }
                if ( pstm != null ){pstm.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }            
        }
		return check;
	}
	@Override
	public boolean delete(SeatsDTO dto) {
		boolean check = false;
		try {
			String SQL = "DELETE SEATS WHERE SEAT_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, dto.getSeatNum());
			pstm.executeUpdate();
			check = true;
			
		}catch(SQLException sqle) {
            System.out.println("DELETE문에서 오류 발생");
            sqle.printStackTrace();
            check = false;
			
		} finally{            
            try{
                if ( rs != null ){rs.close();}   
                if ( stmt != null ){stmt.close();}   
                if ( conn != null ){conn.close(); }
                if ( pstm != null ){pstm.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }            
        }
		return check;
	}
	@Override
	public ArrayList<SeatsDTO> selectAll(){
		
		ArrayList<SeatsDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM SEATS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<SeatsDTO>();
			
			do {
				SeatsDTO seatDTO = new SeatsDTO();
				seatDTO.setSeatNum(rs.getInt("SEAT_NUM"));
				seatDTO.setsTspecialNote(rs.getString("SEAT_SPECIAL_NOTE"));
				seatDTO.setScrHallNum(rs.getInt("SH_NUM"));
				seatDTO.setSeatName(rs.getString("SEAT_NAME"));
				list.add(seatDTO);
            }while(rs.next());
		}catch (SQLException sqle) {
            System.out.println("SELECT ALL문에서 오류 발생"); 
            sqle.printStackTrace();            
        } finally{            
            try{
                if ( rs != null ){rs.close();}   
                if ( stmt != null ){stmt.close();}   
                if ( conn != null ){conn.close(); }
                if ( pstm != null ){pstm.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }            
        } 
		return list;
	}
	
	public ArrayList<SeatsDTO> selectSeatNum() {
		ArrayList<SeatsDTO> list = null; 
		
		try{
			String SQL = "SELECT SEAT_NUM FROM SEATS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<SeatsDTO>();
			
			do {
				SeatsDTO seatDTO = new SeatsDTO();
				seatDTO.setSeatNum(rs.getInt("SEAT_NUM"));
				list.add(seatDTO);
            }while(rs.next());
		}catch (SQLException sqle) {
            System.out.println("SELECT SEATNUM문에서 오류 발생");
            sqle.printStackTrace();            
        } finally{            
            try{
                if ( rs != null ){rs.close();}   
                if ( stmt != null ){stmt.close();}   
                if ( conn != null ){conn.close(); }
                if ( pstm != null ){pstm.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }            
        }
		return list;
	}	
}