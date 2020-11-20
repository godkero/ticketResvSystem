package controller;

import Protocol;
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
   Socket socket = null;
   OutputStream os = null;
   InputStream is = null;


   public ServerController(Socket sock)
   {
      socket = sock;
      os = socket.getOutputStream();
	  is = socket.getInputStream(); 
      
   }

   @override
   public void run()
   {
      
      System.out.println("thread start");
      while (true) {
		  
    	  System.out.println("waiting control char");
    	  if(is != null) {
	    	  
	    	  try {
		    		  	byte [] buf = protocol.getPacket();
		    		  	is.read(buf);
		    		  	int packetType = buf[0]
		    		  	protocol.setPacket(packetType, buf);
		    		  	
				  } catch (IOException e1) {
				     e1.printStackTrace();
				  }
		    	  
		    	  if(protocolType | 0x4f == 0xff ) {
		    		  //control 1
		    	  }
		    	  else if(protocolType | 0x4f == 0xff) {
		    		  
		    	  }
		    	  else if(protocolType | 0x4f == 0xff) {
		    		  
		    	  }
		    	  else if(protocolType | 0x4f == 0xff) {
		    		  
		    	  }
		    	  else if(protocolType | 0x4f == 0xff) {
		    		  
		    	  }
		    } catch (IOException | ParseException | SQLException e) {
		     e.printStackTrace();
		  }
      }
   }
}

