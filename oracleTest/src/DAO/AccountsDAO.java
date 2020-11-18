package DAO;

import DAO.UtilDAO;
import java.sql.*;
import java.util.ArrayList;

import DTO.*;

public class AccountsDAO extends DAO<AccountsDTO> {

	private AccountsDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :");
			e.printStackTrace();
		}	
	}

	private static AccountsDAO dao;

	public static AccountsDAO getInstance() {
		if(dao == null)
			dao = new AccountsDAO();
		return dao;
	}

	//전체 내용 삽입
	@Override
	public boolean insert(AccountsDTO e) {
		boolean check = false;
		
		try { 
			String SQL = "INSERT INTO ACCOUNTS(ACC_NUM,CREATE_DATE,BANK,BALANCE,DEPOSITOR_ID) VALUES(?,,?,?,?)";
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			System.out.println("연결");
			pstm.setInt(1,e.getAccNum());
			pstm.setDate(2,UtilDAO.date(e.getCreateDate()));
			pstm.setString(3,e.getBank());
			pstm.setBigDecimal(4, e.getBalance());
			pstm.setString(5, e.getCliId());
			System.out.println("sql입력완료");
			pstm.executeUpdate();
			System.out.println("업데이트");
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
	
	//잔고 업데이트
	public boolean updateBalance(AccountsDTO e) {
		boolean check = false;
		
		try {
			String sql = "UPDATE ACCOUNTS SET BALANCE = ?";
				   sql+= " WHERE accNum = ?   ";
			
			conn = UtilDAO.getConnection();	   
			pstm = conn.prepareStatement(sql);
			
			pstm.setBigDecimal(1, e.getBalance());
			pstm.setInt(2, e.getAccNum());
		
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
	//계좌 삭제
	@Override
	public boolean delete(AccountsDTO e) {
		
		boolean check = false;
		
		try {
			String SQL = "DELETE  ACCOUNTS WHERE ACC_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			
			pstm.setInt(1, e.getAccNum());
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
	//전체 계좌 조회
	@Override
	public ArrayList<AccountsDTO> selectAll(){
		
		ArrayList<AccountsDTO> list = null; 
		
		try{
			String SQL = "SELECT * FROM ACCOUNTS";
			
			conn = UtilDAO.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			list = new ArrayList<AccountsDTO>();
			
			do {
				AccountsDTO accDTO = new AccountsDTO();
            	accDTO.setAccNum(rs.getInt("ACC_NUM"));
            	accDTO.setCreateDate(UtilDAO.date(rs.getDate("CREATE_DATE")));
            	accDTO.setBalance(rs.getBigDecimal("BALANCE"));
            	accDTO.setBank(rs.getString("BANK"));
            	accDTO.setCliId(rs.getString("CLI_ID"));
            	list.add(accDTO);
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
	//개인의 계좌 조회
	public AccountsDTO select(int accnum) {
		
			AccountsDTO accDTO = new AccountsDTO();
			
			try{	
			String SQL = "SELECT * FROM ACCOUNTS WHERE ACC_NUM = ?";
			
			conn = UtilDAO.getConnection();
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, accnum);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				accDTO.setAccNum(rs.getInt("ACC_NUM"));
            	accDTO.setCreateDate(UtilDAO.date(rs.getDate("CREATE_DATE")));
            	accDTO.setBalance(rs.getBigDecimal("BALANCE"));
            	accDTO.setBank(rs.getString("BANK"));
            	accDTO.setCliId(rs.getString("DEPOSITOR_ID"));
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
		return accDTO;
	}
	
	@Override
	public boolean update(AccountsDTO e) {
		// TODO Auto-generated method stub
		return false;
	}
		
}
