package de.uni_stuttgart.ipvs.occpancy_monitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstimatePositionKNN {
	String mac;
	ArrayList<Mobile_info> current_ss;
	ArrayList<Fingerprint> finger_ss;
	Connection conn;
	Database db;
	public EstimatePositionKNN(String mac,Database db ) {
		super();
		this.mac = mac;
		this.db=db;
		this.conn=db.getConnect();
		this.finger_ss=new ArrayList<Fingerprint>();
		current_ss=new ArrayList<Mobile_info>();
	}

	
	
	
	public ArrayList<Mobile_info> get_last_rssi(String mac) throws SQLException
	{
		ArrayList<Mobile_info> list_of_rssi=new ArrayList<Mobile_info>();
		PreparedStatement   preparedStatement = null;
		ResultSet rs = null;
		try{
		
	     // Result set get the result of the SQL query
		   preparedStatement = conn.prepareStatement("select * from localization_db.mobile_info where mac_m=? ;");
	     preparedStatement.setString(1, mac);
 rs= preparedStatement.executeQuery();
 
  
	   
	    while (rs.next()) {
	    	Mobile_info m=new Mobile_info(rs.getString("mac_m"),rs.getString("mac_ap"),rs.getFloat("rssi"),rs.getInt("type"),rs.getTimestamp("timestamp"),db);
	    	list_of_rssi.add(m);
	    }
		}catch(Exception io){
			rs.close();
		    preparedStatement.close();
			
		}
		rs.close();
	    preparedStatement.close();
	   return list_of_rssi;
	}
	

	public ArrayList<Fingerprint> get_fingerprint() throws SQLException
	{
		ArrayList<Fingerprint> list_of_fingerprint=new ArrayList<Fingerprint>();
		PreparedStatement   preparedStatement = null;
		ResultSet rs = null;
		try{
					
	     // Result set get the result of the SQL query
		   preparedStatement = conn.prepareStatement("select * from localization_db.mobile_info where mac_m=? ;");
	     preparedStatement.setString(1, mac);
 rs= preparedStatement.executeQuery();
 
  
	   
	    while (rs.next()) {
	    	Fingerprint fp=new Fingerprint(rs.getInt("positionX"),rs.getInt("positionY"),rs.getString("mac_ap"),rs.getDouble("rssi"),rs.getInt("direction"));
	    	list_of_fingerprint.add(fp);
	    }
		}catch(Exception io){
			rs.close();
		    preparedStatement.close();
			
		}
		rs.close();
	    preparedStatement.close();
		return list_of_fingerprint;

	}
	
	
}
