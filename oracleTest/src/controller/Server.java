package controller;

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

      ServerSocket s;
      Socket sock;
      InputStream is;
      BufferedReader reader; // ��û�ÿ� �ٷ� �����͸� �ް� �� ��츦 ����Ͽ� reader�� ��쿡�� ���� ���� �� ���� ��

      // <- �� �κ��� ���������� ��Ʈ��ȣ�� �� ���Ḷ�� �ٲ� �ʿ䰡 �ִ��� Ȯ���� �ʿ�.(���� �������δ� �����Ŷ�� ������)
      //��� ��û�� ���� accept���ְ� �� ��� ���� thread�� �����ϰ� ������ ������.
      //�� ��� ���ο��� Ŭ���̾�Ʈ�κ��� �����͸� ��û �޴� ��� �ش� ������ �ϳ��� ��� �ϰԵ�
      //�� ��� ���ο��� ����ϰ� �ǹǷ� ���Ŀ� ������ func, user�� �� ����� ���ʿ� body_length�� body�κи� ä���� �ְ� �޴´ٰ� �����ص� ������.

      //�� ������ ���� �ϴ� Ŭ�������� ���۱��� �ð� �ǰ� ���� �����忡���� ���� ó�� ���� �� ������ ���� ������ ���� 
      int port = 5000;
      s = new ServerSocket(port);
      while(true)
      {
         sock = s.accept();
         System.out.println("�����" + sock.getInetAddress());
         is=sock.getInputStream();
         reader = new BufferedReader(new InputStreamReader(is));
         Thread thread = new Thread(new ServerController(sock, reader)); 
         thread.run(); // �����尡 ����� �����ϰ� ���� �Ŀ� ���� ���� 
         port++;
      }

   }
}

