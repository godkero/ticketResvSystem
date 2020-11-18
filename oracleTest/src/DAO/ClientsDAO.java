package DAO;

import java.sql.*;
import java.util.*;
import DTO.*;

public class ClientsDAO extends DAO<ClientsDTO> {
	private ClientsDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static ClientsDAO dao;

	public static ClientsDAO getInstance() {
		if(dao == null)
			dao = new ClientsDAO();
		return dao;
	}
	//고객 정보 입력
	@Override
	public boolean insert(ClientsDTO e) {
		
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO CLENTS(CLI_ID,CLI_PASSWORD,CLI_NAME,CLI_CALLNUM,CLI_RRN,CLT_EMAIL) VALUES(?,?,?,?,?,?)";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setString(1, e.getCliId());
			pstm.setString(2, e.getCliPassword());
			pstm.setString(3, e.getCliName());
			pstm.setString(4, e.getCliCallNum());
			pstm.setString(5,e.getCliRRN());
			pstm.setString(6, e.getCliEmail());
			
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
	//개인정보 수정 텝
	//update data such as name,phone_num,identification_num, email
	@Override
	public boolean update(ClientsDTO e) {
		boolean check = false;
		
		try {
			String sql = "UPDATE CLIENTS SET CLI_NAME = ?,CLI_CALLNUM = ?";
				   sql+=" CLI_RRN = ? CLI_EMAIL = ? WHERE CLE_ID = ?   ";
			
			conn = UtilDAO.getConnection();	   
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, e.getCliName());
			pstm.setString(2, e.getCliCallNum());
			pstm.setString(3, e.getCliRRN());
			pstm.setString(4, e.getCliEmail());
			pstm.setString(5, e.getCliId());
			pstm.executeUpdate();
			check = true;
		}catch(SQLException sqle) {
            System.out.println("INSERT문에서 예외 발생");
            sqle.printStackTrace();
            check = false;
		}
		return check;
	}
	//비밀번호 수정
	//update only password
	public boolean updatePassword(ClientsDTO e) {
		
		boolean check = false;
		
		try {
			String sql = "UPDATE CLIENTS SET CLI_PASSWORD = ? WHERE CLE_ID = ?   ";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, e.getCliPassword());
			pstm.setString(2, e.getCliId());
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

	//고객 정보 삭제 회원 탈퇴
	@Override
	public boolean delete(ClientsDTO e) {
		boolean check = false;
		try {
			String SQL = "DELETE CLENTS WHERE CLI_ID = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
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

	//전체 고객 정보 조회
	@Override
	public Object selectAll() {
		
		ArrayList<ClientsDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM CLENTS";
		
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<ClientsDTO>();
			
			while(rs.next()){
				ClientsDTO ClientsDTO = new ClientsDTO();
				ClientsDTO.setCliId(rs.getString("CLI_ID"));
				ClientsDTO.setCliPassword(rs.getString("CLI_PASSWORD"));
				ClientsDTO.setCliName(rs.getString("CLI_NAME"));
				ClientsDTO.setCliCallNum(rs.getString("CLI_CALLNUN"));
				ClientsDTO.setCliRRN(rs.getString("CLI_RRN"));
				ClientsDTO.setCliEmail(rs.getString("CLI_EMAIL"));
            	list.add(ClientsDTO);
            };
			
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
	
	//고객 개개인 정보 조희
	public ClientsDTO select(int cliId) {
		
		ClientsDTO clientsDTO = new ClientsDTO();
		
		try{
			
			String SQL = "SELECT * FROM CLENTS WHERE CLI_ID = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, cliId);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				ClientsDTO ClientsDTO = new ClientsDTO();
				ClientsDTO.setCliId(rs.getString("CLI_ID"));
				ClientsDTO.setCliPassword(rs.getString("CLI_PASSWORD"));
				ClientsDTO.setCliName(rs.getString("CLI_NAME"));
				ClientsDTO.setCliCallNum(rs.getString("CLI_CALLNUN"));
				ClientsDTO.setCliRRN(rs.getString("CLI_RRN"));
				ClientsDTO.setCliEmail(rs.getString("CLI_EMAIL"));
	  			//ClientsDTO.setManPassword(rs.getString("CLI_PASSWORD"));
		}
		
	}catch(SQLException sqle) {
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
	return clientsDTO;
	}
}
