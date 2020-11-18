package com.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class oracleTest 
{
    public static void main(String args[])
    {    	
        Connection conn = null;        
        Statement stmt = null;
        ResultSet rs = null;  
        PreparedStatement pstm = null;
        
        try {
//        	String requestId = "KIM";
            String SQL = "SELECT * FROM BOARD2";
            //String SQL2 = "SELECT * FROM BOARD2 WHERE ID ='"+requestId+"'";
            
            String pSQL = "INSERT INTO BOARD2(TITLE,CONTENT,ID,REGDATE)"+"VALUES(?,?,?,?)";
            
            conn = DBConnection.getConnection();
            
            pstm = conn.prepareStatement(pSQL);
            
            pstm.setString(1, "prepared test");
            pstm.setString(2, "preparedstatement test contents");
            pstm.setString(3, "HONG");
            pstm.setTimestamp(4,Timestamp.valueOf(LocalDateTime.now()));
            
            pstm.executeUpdate();
            
            //동적 작성시 에러가 나고 복잡함 prepared statement 사용
            //preQuery = "INSERT INTO BOARD2(TITLE,CONTENT,ID,REGDATE) VALUES(?,?,?,?,?);
            
            //pstm = conn.prepareStatement(preQuery);
            //pstm.setString(1,"preparedStatement");
            //pstm.setString()
                       
//            conn = DBConnection.getConnection();
//            
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(SQL);
//            
//            while(rs.next()) {
//            	Long no = rs.getLong("NO");            	
//            	String title = rs.getString("TITLE");
////            	rs.getInt();
//            	String content = rs.getString("CONTENT");
//            	String id = rs.getString("ID");
//            	LocalDateTime regDateTime = rs.getTimestamp("REGDATE").toLocalDateTime();
//            	System.out.println(no + " | " + title + " | " + content + 
//            			" | " + id + " | " + regDateTime);            	
//            }
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

