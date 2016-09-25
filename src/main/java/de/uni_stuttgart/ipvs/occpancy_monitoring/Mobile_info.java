package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class Mobile_info {

	private String mac_Ap;
	private float rssi;
	private String macAddr;
	private static int i=0;
	private Timestamp timestamp;
private Connection conn = null;
int type_ass;

	public Mobile_info(String macAddr, String mac_Ap, float rssi,int type,Database db ) {
		this.i++;
		this.macAddr = macAddr;
		this.mac_Ap = mac_Ap;
		this.rssi = rssi;
		
		// Convert it to java.sql.Date
		this.timestamp=new Timestamp(System.currentTimeMillis());
		type_ass=type;
		this.conn=db.getConnect();
	}
	
	public Mobile_info(String macAddr, String mac_Ap, float rssi,int type,Timestamp timestamp,Database db ) {
		this.i++;
		this.macAddr = macAddr;
		this.mac_Ap = mac_Ap;
		this.rssi = rssi;
		this.timestamp = timestamp;
		type_ass=type;
		this.conn=db.getConnect();
	}
	
	
	
	public boolean isExist(String macAddr)throws SQLException{
		
		try{
			Statement	statement = conn.createStatement();
		
	     // Result set get the result of the SQL query
		 PreparedStatement   preparedStatement = conn.prepareStatement("select * from localization_db.mobile_info where mac_m=? ;");
	     preparedStatement.setString(1, macAddr);
	     ResultSet resultSet= preparedStatement.executeQuery();
	    
	    
	   
	    if(!resultSet.next())	
	    {
	    	statement.close();
		    preparedStatement.close();
		    return false;
	    }else{
	    	 
	    	 
	    	 statement.close();
	 	    preparedStatement.close();
	 	    
	 	    return true;
	    }
		}catch(Exception io){
			
			
		}
		return true;
	}
	
	
	
	public void insert(){
			try{
			

			
 PreparedStatement   preparedStatement = conn.prepareStatement("insert into  localization_db.mobile_info values (?, ?, ?,?,?)");
			
			      preparedStatement.setString(1, this.macAddr);
			      preparedStatement.setString(2, this.mac_Ap);
			      preparedStatement.setFloat(3, this.rssi);
			      preparedStatement.setTimestamp(4,this.timestamp );
			      preparedStatement.setInt(4,this.type_ass );
			      preparedStatement.executeUpdate();	
						
		}catch( Exception io){
			
			 System.out.println("start exception..."+io);
		}
	}

	
	
	
	
	public String getMacAddr() {
        return macAddr;
	}
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}
	public String getMac_Ap() {
		return mac_Ap;
	}
	public void setMac_Ap(String mac_Ap) {
		this.mac_Ap = mac_Ap;
	}
	public float getRssi() {
		return rssi;
	}
	public void setRssi(float rssi) {
		this.rssi = rssi;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getType_ass() {
		return type_ass;
	}

	public void setType_ass(int type_ass) {
		this.type_ass = type_ass;
	}
	
	
	

}
