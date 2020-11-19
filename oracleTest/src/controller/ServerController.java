package controller;

import DAO.*;
import DTO.*;
import java.io.*;

import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;




public class ServerController  implements Runnable
{
   Socket socket;
   BufferedReader buffer;

   public ServerController(Socket sock, BufferedReader buf)
   {
      socket = sock;
      buffer = buf;
   }

   public void run()
   {
      int user = 0;
      int func = 0;
      
      
      while (true) {
		  
    	  try {
		     user = buffer.read();
		     func = buffer.read();
		  } catch (IOException e1) {
		     // TODO Auto-generated catch block
		     e1.printStackTrace();
		  }
		
    	  
		  try {
		     if(user == 1) // 각 헤더의 자료형은 우선 int라 가정하고 써 놓은것 String으로 받을경우에 수정 가능
		     {
		        DAO dao = new DAO();
		
		        if(func == 1)
		        	dao.selectAll();
		
		        else if(func == 2)
		        	dao.selectAll();
		
		        else if(func == 3)
		        	dao.selectAll();
		     }
		
		     else if(user == 2)
		     {
		    	 if(func == 1)
			        	dao.selectAll();
			
			        else if(func == 2)
			        	dao.selectAll();
			
			        else if(func == 3)
			        	dao.selectAll();		
		     }
		
		     else if(user == 3)
		     {
		        DAO dao = new DAO();
		
		        if(func == 1)
		        	dao.selectAll();
		
		        else if(func == 2)
		        	dao.selectAll();
		
		        else if(func == 3)
		        	dao.selectAll();
		     }
		  } catch (IOException | ParseException | SQLException e) {
		     e.printStackTrace();
		  }
      }
   }

}

