package DAO;

import DTO.*;
import java.sql.*;
import java.util.*;

public class ReservationDetailsDAO extends DAO<ReservationDetailsDTO> {
	
	private ReservationDetailsDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static ReservationDetailsDAO dao;

	public ReservationDetailsDAO getInstance() {
		if(dao == null)
			dao = new ReservationDetailsDAO();
		return dao;
	}
	
	
	@Override
	public boolean insert(ReservationDetailsDTO dto) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO RES_DETAILS(RES_DT_NUM,SEAT_NUM,RES_NUM) VALUES(RES_DT_NUM_SEQ.NEXTVAL,?,?)";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, dto.getSeatNum());
			pstm.setInt(2, dto.getResNum());
			
			pstm.executeUpdate();
			
			check = true;
		 }catch(SQLException sqle) {
	            System.out.println("INSERT문에서 예외 발생");
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
	public boolean update(ReservationDetailsDTO dto) {
		boolean check = false;
		
		try {
			String sql = "UPDATE RES_DETAILS SET SEAT_NUM = ?, RES_NUM = ? WHERE RES_DT_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, dto.getSeatNum());
			pstm.setInt(2, dto.getResNum());
			pstm.setInt(3, dto.getResDtNum());
			pstm.executeUpdate();
			
			check = true;
		}catch(SQLException sqle) {
            System.out.println("UPDATE문에서 예외 발생");
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
	public boolean delete(ReservationDetailsDTO dto) {
		boolean check = false;
		try {
			String SQL = "DELETE RES_DETAILS WHERE RES_DT_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, dto.getResDtNum());
			pstm.executeUpdate();
			check = true;
			
		}catch(SQLException sqle) {
            System.out.println("DELETE문에서 예외 발생");
            sqle.printStackTrace();
            check = false;
			
		}finally{            
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
	public ArrayList<ReservationDetailsDTO> selectAll(){
		
		ArrayList<ReservationDetailsDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM RES_DETAILS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<ReservationDetailsDTO>();
			
			do {
				ReservationDetailsDTO rdDTO = new ReservationDetailsDTO();
				rdDTO.setResDtNum(rs.getInt("RES_DT_NUM"));
				rdDTO.setSeatNum(rs.getInt("SEAT_NUM"));
				rdDTO.setResNum(rs.getInt("RES_NUM"));
				list.add(rdDTO);
            }while(rs.next());
		}catch (SQLException sqle) {
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();            
        }finally{            
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
	
	public ArrayList<ReservationDetailsDTO> selectResDtNum() {
		ArrayList<ReservationDetailsDTO> list = null; 
		
		try{
			String SQL = "SELECT SEAT_NUM FROM RES_DETAILS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<ReservationDetailsDTO>();
			
			do {
				ReservationDetailsDTO rdDTO = new ReservationDetailsDTO();
				rdDTO.setResDtNum(rs.getInt("RES_DT_NUM"));
				list.add(rdDTO);
            }while(rs.next());
		}catch (SQLException sqle) {
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();            
        }finally{            
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