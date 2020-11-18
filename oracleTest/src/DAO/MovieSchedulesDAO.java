package DAO;

import java.sql.*;
import java.util.*;
import DTO.*;

public class MovieSchedulesDAO extends DAO<MovieSchedulesDTO> {

	private MovieSchedulesDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static MovieSchedulesDAO dao;

	public static MovieSchedulesDAO getInstance() {
		if(dao == null)
			dao = new MovieSchedulesDAO();
		return dao;
	}

	@Override
	public boolean insert(MovieSchedulesDTO dto) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO SCHEDULES(SCH_NUM,MOV_NUM,SH_NUM,SCH_START_TIME,"
					+ "SCH_END_TIME) VALUES(SCH_NUM_SEQ.NEXTVAL,?,?,?,?)";
			pstm = conn.prepareStatement(SQL);
	
			pstm.setInt(1, dto.getMovNum());
			pstm.setInt(2, dto.getScrHallNum());
			pstm.setTimestamp(3, UtilDAO.time(dto.getSchStartTime()));
			pstm.setTimestamp(4, UtilDAO.time(dto.getSchEndTime()));
			
			pstm.executeUpdate();
			
			check = true;
		 }catch(SQLException sqle) {
	            System.out.println("INSERT문에서 예외 발생");
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
	public boolean update(MovieSchedulesDTO dto) {
		boolean check = false;
		
		try {
			String sql = "UPDATE SCHEDULES SET MOV_NUM = ?, SH_NUM = ?, SCH_START_TIME = ?"
					+ " WHERE SCH_NUM = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, dto.getScrHallNum());
			pstm.setTimestamp(2, UtilDAO.time(dto.getSchStartTime()));
			pstm.setTimestamp(3, UtilDAO.time(dto.getSchEndTime()));
			pstm.setInt(4, dto.getMovNum());
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
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }            
        }
		return check;
	}
	@Override
	public boolean delete(MovieSchedulesDTO dto) {
		boolean check = false;
		try {
			String SQL = "DELETE SCHEDULES WHERE SCH_NUM = ?";
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, dto.getSchNum());
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
	public ArrayList<MovieSchedulesDTO> selectAll(){
		
		ArrayList<MovieSchedulesDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM SCHEDULES";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<MovieSchedulesDTO>();
			
			while(rs.next()) {
				MovieSchedulesDTO movScheDTO = new MovieSchedulesDTO();
            	movScheDTO.setSchNum(rs.getInt("SCH_NUM"));
            	movScheDTO.setMovNum(rs.getInt("MOV_NUM"));
            	movScheDTO.setScrHallNum(rs.getInt("SH_NUM"));
            	movScheDTO.setSchStartTime(UtilDAO.time(rs.getTimestamp("SCH_START_TIME")));
            	movScheDTO.setSchEndTime(UtilDAO.time(rs.getTimestamp("SCH_END_TIME")));
            
//            	
            	list.add(movScheDTO);
            }
			
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
	
	public AccountsDTO select(String depositor) {
		return null;
	}	
}