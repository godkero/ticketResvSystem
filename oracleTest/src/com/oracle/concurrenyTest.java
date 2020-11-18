package com.oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class concurrenyTest {
	    public static void main(String args[])
	    {    	
	        Connection conn = null;        
	        Statement stmt = null;
	        ResultSet rs = null;  
	        PreparedStatement pstm = null;
	        
	        try {
//	        	
	            String SQL = "SELECT NO,TITLE,ID FROM BOARD2";
	            
	            
	            //String pSQL = "INSERT INTO BOARD2(TITLE,CONTENT,ID,REGDATE)"+"VALUES(?,?,?,?)";
	            
	            conn = DBConnection.getConnection();
	            
	            stmt = conn.createStatement(
	            		ResultSet.TYPE_SCROLL_INSENSITIVE,
	            		ResultSet.CONCUR_UPDATABLE);
	                       
	            rs = stmt.executeQuery(SQL);
	            while(rs.next()) {
	            	Long no = rs.getLong("NO");            	
	            	String title = rs.getString("TITLE");
//	            	rs.getInt();
	            	//String content = rs.getString("CONTENT");
	            	String id = rs.getString("ID");
	            	//LocalDateTime regDateTime = rs.getTimestamp("REGDATE").toLocalDateTime();
	            	System.out.println(no + " | " + title + " | " +  
	            			" | " + id + " | " );            	
	            }
	          //  rs.getString(1,)
//	            
//	            rs.first();
//	            rs.updateString("ID", "JUNG");
//	            rs.updateRow();
	            
	           ResultSetMetaData rsmeta = rs.getMetaData();
	           
	           int numOfCols = rsmeta.getColumnCount();
	           System.out.println("ResultSet has"+numOfCols+"colums");
	           
	           
	        } catch (SQLException sqle) {
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
	    }
	}



