package DAO;

import DTO.*;
import java.sql.*;
import java.util.*;

public class ScreenHallsDAO extends DAO<ScreenHallsDTO> {
	
	
	private ScreenHallsDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static ScreenHallsDAO dao;

	public static ScreenHallsDAO getInstance() {
		if(dao == null)
			dao = new ScreenHallsDAO();
		return dao;
	}
	
	
	@Override
	public boolean insert(ScreenHallsDTO dto) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO SCREEN_HALLS(SH_NUM,SH_NUM_OF_SEAT,SH_SPECIAL_NOTE,THE_NAME,SH_NAME) VALUES(SH_NUM_SEQ.NEXTVAL,?,?,?,?)";
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, dto.getNumOfSeat());
			pstm.setString(2, dto.getsHspecialNotes());
			pstm.setString(3, dto.getTheatName());
			pstm.setString(4, dto.getScrHallName());
			
			pstm.executeUpdate();
			
			check = true;
		 }catch(SQLException sqle) {
	            System.out.println("INSERT문에서 예외 발생");
	            sqle.printStackTrace(); // 자세한 예외 정보를 제공하는 메소드
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
	@Override
	public boolean update(ScreenHallsDTO dto) {
		boolean check = false;
		
		try {
			String sql = "UPDATE SCREEN_HALLS SET SH_NUM_OF_SEAT = ?, SH_SPECIAL_NOTE = ?, THE_NAME = ?, SH_NAME = ? WHERE SH_NUM = ?";
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, dto.getNumOfSeat());
			pstm.setString(2, dto.getsHspecialNotes());
			pstm.setString(3, dto.getTheatName());
			pstm.setString(4, dto.getScrHallName());
			pstm.setInt(5, dto.getScrHallNum());
			pstm.executeUpdate();
			check = true;
		}catch(SQLException sqle) {
            System.out.println("UPDATE문에서 예외 발생");
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
	@Override
	public boolean delete(ScreenHallsDTO dto) {
		boolean check = false;
		try {
			String SQL = "DELETE SCREEN_HALLS WHERE SH_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, dto.getScrHallNum());
			pstm.executeUpdate();
			check = true;
			
		}catch(SQLException sqle) {
            System.out.println("DELETE문에서 예외 발생");
            sqle.printStackTrace();
            check = false;
			
		}
		return check;
	}
	@Override
	public ArrayList<ScreenHallsDTO> selectAll(){
		
		ArrayList<ScreenHallsDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM SCREEN_HALLS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL); 
			
			list = new ArrayList<ScreenHallsDTO>();
			
			do {
				ScreenHallsDTO shDTO = new ScreenHallsDTO();
				shDTO.setScrHallNum(rs.getInt("SH_NUM"));
				shDTO.setNumOfSeat(rs.getInt("SH_NUM_OF_SEAT"));
				shDTO.setsHspecialNotes(rs.getString("SH_SPECIAL_NOTE"));
				shDTO.setTheatName(rs.getString("THE_NAME"));
				shDTO.setScrHallName(rs.getString("SH_NAME"));
				list.add(shDTO);
            }while(rs.next());
		}catch (SQLException sqle) {
            System.out.println("SELECT ALL문에서 예외 발생"); //  // SELECT문도 여러개가 있으니까 SELECT 뒤에 속성 이름을 붙이는게 좋아보임
            sqle.printStackTrace();            
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
		return list;
	}
	
	public ArrayList<ScreenHallsDTO> selectScrHallNum() {
		ArrayList<ScreenHallsDTO> list = null; 
		
		try{
			String SQL = "SELECT SH_NUM FROM SCREEN_HALLS";
		
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<ScreenHallsDTO>();
			
			do {
				ScreenHallsDTO shDTO = new ScreenHallsDTO();
				shDTO.setScrHallNum(rs.getInt("SH_NUM"));
				list.add(shDTO);
            }while(rs.next());
		}catch (SQLException sqle) {
            System.out.println("SELECT ScrHallNUM문에서 예외 발생");
            sqle.printStackTrace();            
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
		return list;
	}	
}
