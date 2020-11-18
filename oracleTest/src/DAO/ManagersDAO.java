package DAO;

import java.sql.*;
import java.util.*;
import DTO.*;


public class ManagersDAO extends DAO<ManagersDTO> {

	private ManagersDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB ����̹� �ε� ���� :");
			e.printStackTrace();
		}	
	}

	private static ManagersDAO dao;

	public static ManagersDAO getInstance() {
		if(dao == null)
			dao = new ManagersDAO();
		return dao;
	}

	//������ ���� ����
	@Override
	public boolean insert(ManagersDTO e) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO MANAGERS(CLI_ID,CLI_PASSWORD,CLI_NAME,CLI_CALLNUM,CLI_RRN,CLT_EMAIL) VALUES(?,?,NULL,?,?,?)";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setString(1, e.getManId());
			pstm.setDate(2, UtilDAO.date(e.getDateHired()));	 
			pstm.setString(3, e.getManName());
			pstm.setString(4,e.getManPassword());

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

	//������ ����� ����
	@Override
	public boolean update(ManagersDTO e) {
		boolean check = false;
		
		try {
			String sql = "UPDATE MANAGERS SET RES_DATE = ? WHERE MAN_ID = ?   ";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setDate(1, UtilDAO.nowDate());
			pstm.setString(2, e.getManId());
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
	//������ ��й�ȣ ����
	public boolean updatePassword(ManagersDTO e) {
		boolean check = false;
		
		try {
			String sql = "UPDATE MANAGERS SET MAN_PASSWORD = ? WHERE MAN_ID = ?   ";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, e.getManPassword());
			pstm.setString(2, e.getManId());
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
	

	//������ ���� ����
	@Override
	public boolean delete(ManagersDTO e) {
		boolean check = false;
		try {
			String SQL = "DELETE MANAGERS WHERE  = ?";
			pstm = conn.prepareStatement(SQL);
			
			pstm.setString(1,"");
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
	//������ ���� ��ü ����Ʈ ��ȸ
	//��й�ȣ ��ȸ �ȵǰ� ����
	@Override
	public Object selectAll() {
		ArrayList<ManagersDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM MANAGERS ";
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<ManagersDTO>();
			
			while(rs.next()){
				ManagersDTO managersDTO = new ManagersDTO();
				managersDTO.setManId(rs.getString("MAN_ID"));
				managersDTO.setDateHired(UtilDAO.date(rs.getDate("JOIN_DATE")));
				managersDTO.setDateResigned(UtilDAO.date(rs.getDate("RES_DATE")));
				managersDTO.setManName(rs.getString("MAN_NAME"));
				//managersDTO.setManPassword(rs.getString("MAN_PASSWORD"));
            	list.add(managersDTO);
            };
			
		}catch (SQLException sqle) {
            System.out.println("SELECT������ ���� �߻�");
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
	//������ ���� �ϳ� ��ȸ
	//��й�ȣ ��ȸ �ȵǰ� ����
	public ManagersDTO select(int managerId) {
		
		ManagersDTO managersDTO = new ManagersDTO();
		
		try{	
		String SQL = "SELECT * FROM ACCOUNTS WHERE ACC_NUM = ?";
		
		conn = UtilDAO.getConnection();
		pstm = conn.prepareStatement(SQL);
		pstm.setInt(1, managerId);
		rs = pstm.executeQuery();
		
		if(rs.next()) {
			managersDTO.setManId(rs.getString("ACC_NUM"));
			managersDTO.setManId(rs.getString("MAN_ID"));
			managersDTO.setDateHired(UtilDAO.date(rs.getDate("JOIN_DATE")));
			managersDTO.setDateResigned(UtilDAO.date(rs.getDate("RES_DATE")));
			managersDTO.setManName(rs.getString("MAN_NAME"));
			//managersDTO.setManPassword(rs.getString("MAN_PASSWORD"));
		}
		
	}catch(SQLException sqle) {
        System.out.println("SELECT������ ���� �߻�");
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
	return managersDTO;
	}
		
}
