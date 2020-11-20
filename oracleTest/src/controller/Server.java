package src.controller;

import java.io.*;

import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;





public class Server {


   public static void main(String arg[]) throws IOException
   {

      ServerSocket serverSocket;
      Socket socket;
      
      // <- 이 부분은 서버소켓의 포트번호도 매 연결마다 바뀔 필요가 있는지 확인이 필요.(본인 생각으로는 없을거라고 생각됨)
      //기능 요청시 마다 accept해주고 각 기능 별로 thread를 생성하고 연결을 종료함.
      //한 기능 내부에서 클라이언트로부터 데이터를 요청 받는 경우 해당 스레드 하나가 대기 하게됨
      //한 기능 내부에서 대기하게 되므로 이후에 별도의 func, user등 의 헤더는 불필요 body_length와 body부분만 채워서 주고 받는다고 생각해도 무방함.

      //각 유저를 관리 하는 클래스에서 전송까지 맡게 되고 메인 스레드에서는 단지 처음 수신 및 스레드 생성 역할이 전부 
      int port = 5000;
      serverSocket = new ServerSocket(port);
      
      while(true)
      {
    	  socket = s.accept();
    	  System.out.println("연결됨" + sock.getInetAddress());
    	  
    	  Thread thread = new Thread(new ServerController(socket)); 
    	  thread.run(); // 스레드가 기능을 수행하고 수행 후에 연결 종료 
    	  port++;
      }

   }
}

