package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Library {
	
	  DatagramSocket datagramSocket;
	  byte[] buffer = new byte[2048];
	  DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	
	  public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		  Library ob=new Library();
		  System.out.println("start recieving...");
		  ob.datagramSocket = new DatagramSocket(16813);
		  System.out.println("socket is created...");
		  Database db=new Database();
     while(true){
	 System.out.println("start recieving...");
	 ob.datagramSocket.receive(ob.packet);
	 new Thread(new HandleProccess(ob.packet,db)).start();
		  System.out.println("start thread...");
	
          }

		}
	  
	
	//	Create the following main program to test your class.


	  
	  
    public boolean someLibraryMethod() {
        return true;
    }
}
