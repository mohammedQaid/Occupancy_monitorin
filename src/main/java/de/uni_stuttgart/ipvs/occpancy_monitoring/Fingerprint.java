package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Fingerprint {
	int positionX;
	int positionY;
	int direction;
	String mac_ap;
	Double rssi;
	int region;
	private Connection conn = null;
	
	
	
	public Fingerprint(int positionX, int positionY, int direction, String mac_ap, Double rssi,Database db) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
		this.mac_ap = mac_ap;
		this.rssi = rssi;
		this.conn=db.getConnect();
	}
	
	public Fingerprint(int positionX, int positionY,  String mac_ap, Double rssi,int direction) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
		this.mac_ap = mac_ap;
		this.rssi = rssi;
			}
	
	
public void insert(){
		try{
		
			
		System.out.println("start insert ..."+ positionX);
		
		PreparedStatement   preparedStatement = conn.prepareStatement("insert into  localization_db.fingerprint values ( ?,?,?, ?, ?, ?)");
		preparedStatement.setInt(1,  this.positionX);
		preparedStatement.setInt(2,  this.positionY);
		
	
		      preparedStatement.setString(3, mac_ap);
		      preparedStatement.setDouble(4, rssi);
		      preparedStatement.setInt(5,  this.direction);
		      preparedStatement.executeUpdate();	
		
		
	}catch( Exception io){
		
		 System.out.println("start exception..."+io);
	}
}
	
	
	public int getPositionX() {
		return positionX;
	}



	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}



	public int getPositionY() {
		return positionY;
	}



	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}



	public int getDirection() {
		return direction;
	}



	public void setDirection(int direction) {
		this.direction = direction;
	}



	public String getMac_ap() {
		return mac_ap;
	}



	public void setMac_ap(String mac_ap) {
		this.mac_ap = mac_ap;
	}



	public Double getRssi() {
		return rssi;
	}



	public void setRssi(Double rssi) {
		this.rssi = rssi;
	}



	
}
