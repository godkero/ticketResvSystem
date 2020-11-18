package DAO;

import java.sql.*;
import java.util.*;
import DTO.*;

public class MoviesDAO extends DAO<MoviesDTO> {

	private MoviesDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static MoviesDAO dao;

	public static MoviesDAO getInstance() {
		if(dao == null)
			dao = new MoviesDAO();
		return dao;
	}

	@Override
	public boolean insert(MoviesDTO dto) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO MOVIES(MOV_NUM,MOV_NAME,ACTOR_INFO,DIRECTOR,STORY,OPEN_DATE,AGE_LIMIT,POSTER,MOV_RUN_TIME,TOTAL_AUDIENCES) VALUES(MOV_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, dto.getMovName());
			pstm.setString(2, dto.getActorInfo());
			pstm.setString(3, dto.getDirector());
			pstm.setString(4, dto.getStory());
			pstm.setDate(5, UtilDAO.date(dto.getReleaseDay()));
			pstm.setInt(6, dto.getAgeLimit());
			pstm.setBlob(7, dto.getPoster());
			pstm.setInt(8, dto.getMovRunTime());
			pstm.setBigDecimal(9, dto.getTotalAudiences());
			
			pstm.executeUpdate();
			
			check = true;
		 }catch(SQLException sqle) {
	            System.out.println("INSERT臾몄뿉�꽌 �삁�쇅 諛쒖깮");
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
	public boolean update(MoviesDTO dto) {
		boolean check = false;
		
		try {
			String sql = "UPDATE MOVIES SET MOV_NAME = ?, ACTOR_INFO = ?, DIRECTOR = ?, STORY = ?, OPEN_DATE = ?, AGE_LIMIT = ?, POSTER = ?, MOV_RUN_TIME = ?, TOTAL_AUDIENCES = ? WHERE MOV_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, dto.getMovName());
			pstm.setString(2, dto.getActorInfo());
			pstm.setString(3, dto.getDirector());
			pstm.setString(4, dto.getStory());
			pstm.setDate(5, UtilDAO.date(dto.getReleaseDay()));
			pstm.setInt(6, dto.getAgeLimit());
			pstm.setBlob(7, dto.getPoster());
			pstm.setInt(8, dto.getMovRunTime());
			pstm.setBigDecimal(9, dto.getTotalAudiences());
			pstm.setInt(10, dto.getMovNum());
			
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
	public boolean delete(MoviesDTO dto) {
		boolean check = false;
		try {
			String SQL = "DELETE MOVIES WHERE SEAT_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, dto.getMovNum());
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
	public ArrayList<MoviesDTO> selectAll(){
		
		ArrayList<MoviesDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM MOVIES";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<MoviesDTO>();
			
			while(rs.next()) {
				MoviesDTO movDTO = new MoviesDTO();
            	movDTO.setMovNum(rs.getInt("MOV_NUM"));
            	movDTO.setMovName(rs.getString("MOV_NAME"));
            	movDTO.setActorInfo(rs.getString("ACTOR_INFO"));
            	movDTO.setDirector(rs.getString("DIRECTOR"));
            	movDTO.setStory(rs.getString("STORY"));
            	movDTO.setReleaseDay(UtilDAO.date(rs.getDate("OPEN_DATE")));
            	movDTO.setAgeLimit(rs.getInt("AGE_LIMIT"));
            	movDTO.setPoster(rs.getBlob("POSTER"));
            	list.add(movDTO);
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
            }catch(Exception ecpt){
                throw new RuntimeException(ecpt.getMessage());
            }            
        } 
		return list;
	}
	
	public MoviesDTO select(/* What do you want */) {
		return null;
	}	
}