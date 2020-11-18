package DAO;

import java.sql.*;
import java.util.*;
import DTO.*;

public class TheatersDAO extends DAO<TheatersDTO> {

	private TheatersDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static TheatersDAO dao;

	public static TheatersDAO getInstance() {
		if(dao == null)
			dao = new TheatersDAO();
		return dao;
	}

	@Override
	public boolean insert(TheatersDTO dto) {
		boolean check = false;
		
		try {
			String SQL = "INSERT INTO THEATERS(THE_NAME,ADDRESS,CLOSED_DATE,THE_INCOME,NUM_OF_EMP) VALUES(?,?,?,?,?)";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setString(1, dto.getTheatName());
			pstm.setString(2, dto.getAddress());
			pstm.setDate(3, UtilDAO.date(dto.getClosedDate()));
			pstm.setBigDecimal(4, dto.getTheatIncome());
			pstm.setInt(5, dto.getNumOfEmployee());
			
			pstm.executeUpdate();
			
			check = true;
		} catch (SQLException sqle) {
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
	public boolean update(TheatersDTO dto) {
		boolean check = false;
		
		try {
			String sql = "UPDATE THEATERS SET ADDRESS = ?, CLOSED_DATE = ?, THE_INCOME = ?, NUM_OF_EMP = ? WHERE THE_NAME = ?";
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, dto.getAddress());
			pstm.setDate(2, UtilDAO.date(dto.getClosedDate()));
			pstm.setBigDecimal(3, dto.getTheatIncome());
			pstm.setInt(4, dto.getNumOfEmployee());
			pstm.setString(5, dto.getTheatName());
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
	public boolean delete(TheatersDTO dto) {
		boolean check = false;
		try {
			String SQL = "DELETE THEATERS WHERE THE_NAME = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setString(1, dto.getTheatName());
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
	public ArrayList<TheatersDTO> selectAll(){
		
		ArrayList<TheatersDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM THEATERS";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<TheatersDTO>();
			
			while(rs.next()) {
				TheatersDTO theatDTO = new TheatersDTO();
            	theatDTO.setTheatName(rs.getString("THE_NAME"));
            	theatDTO.setAddress(rs.getString("ADDRESS"));
            	theatDTO.setClosedDate(UtilDAO.date(rs.getDate("CLOSED_DATE")));
            	theatDTO.setTheatIncome(rs.getBigDecimal("THE_INCOME"));
            	theatDTO.setNumOfEmployee(rs.getInt("NUM_OF_EMP"));
            	list.add(theatDTO);
            }
			
		}catch (SQLException sqle) {
            System.out.println("SELECT ALL문에서 예외 발생");  
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