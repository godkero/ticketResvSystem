package DAO;

import DTO.*;
import java.sql.*;
import java.util.*;

public class RatingsDAO extends DAO<RatingsDTO> {
	

	private RatingsDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static RatingsDAO dao;

	public static RatingsDAO getInstance() {
		if(dao == null)
			dao = new RatingsDAO();
		return dao;
	}

	@Override
	public boolean insert(RatingsDTO dto) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO RATINGS(RAT_NUM, WRTITE_DATE, STAR_RATE, CONTENT, WRITER_ID, MOV_NUM) VALUES(RAT_NUM_SEQ.NEXTVAL,?,?,?,?,?)";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setTimestamp(1, UtilDAO.NowTime());
			pstm.setInt(2, dto.getStarRating());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getWriterId());
			pstm.setInt(5, dto.getMovNum());
			
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
	            }catch(Exception ecpt){
	                throw new RuntimeException(ecpt.getMessage());
	            }            
	        }
		
		return check;
	}
	
	@Override
	public boolean update(RatingsDTO dto) {
		boolean check = false;
		
		try {
			String sql = "UPDATE RATINGS SET WRT_DATE = ?, STAR_RATE = ?, CONTENT = ?, WRITER_ID = ?, MOV_NUM = ? WHERE RAT_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setTimestamp(1, UtilDAO.time(dto.getWriteDate()));
			pstm.setInt(2, dto.getStarRating());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getWriterId());
			pstm.setInt(5, dto.getMovNum());
			pstm.setInt(6, dto.getRatingNum());
			
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
	public boolean delete(RatingsDTO dto) {
		boolean check = false;
		try {
			String SQL = "DELETE RATINGS WHERE RAT_NUM = ?";
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, dto.getRatingNum());
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
            }catch(Exception ecpt){
                throw new RuntimeException(ecpt.getMessage());
            }            
        }
		return check;
	}
	@Override
	public ArrayList<RatingsDTO> selectAll(){
		
		ArrayList<RatingsDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM RATINGS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<RatingsDTO>();
			
			do {
				RatingsDTO rDTO = new RatingsDTO();
				rDTO.setRatingNum(rs.getInt("RAT_NUM"));
				rDTO.setWriteDate(UtilDAO.time(rs.getTimestamp("WRT_DATE")));
				rDTO.setStarRating(rs.getInt("STAR_RATE"));
				rDTO.setContent(rs.getString("CONTENT"));
				rDTO.settWriterId(rs.getString("WRITER_ID"));
				rDTO.setMovNum(rs.getInt("MOV_NUM"));
				
				list.add(rDTO);
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
            }catch(Exception ecpt){
                throw new RuntimeException(ecpt.getMessage());
            }            
        } 
		return list;
	}
	
	public ArrayList<RatingsDTO> selectRatingNum() {
		ArrayList<RatingsDTO> list = null; 
		
		try{
			String SQL = "SELECT RAT_NUM FROM RATINGS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<RatingsDTO>();
			
			do {
				RatingsDTO rDTO = new RatingsDTO();
				rDTO.setRatingNum(rs.getInt("RAT_NUM"));
				
				list.add(rDTO);
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
            }catch(Exception ecpt){
                throw new RuntimeException(ecpt.getMessage());
            }            
        } 
		return list;
	}	
}
