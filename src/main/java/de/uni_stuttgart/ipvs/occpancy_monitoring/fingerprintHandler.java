package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.net.DatagramPacket;

import org.json.JSONArray;
import org.json.JSONObject;

public class fingerprintHandler implements Runnable {
	private Database db = null;
	int positionX;
	int positionY;
	int direction;
	int region;
	 
	
	  private DatagramPacket packet = null;
	  byte[] buffer = new byte[2048];
	  
	public fingerprintHandler( DatagramPacket packet, Database db) {
		this.db=db;

		this.packet=packet;
		}
	@Override
	public void run() {
		
	//	String ss= "{Data:[{\"mac\":\"12:ed:23:65:f2\",\"rssi\":\"12\"},{\"mac\":\"12:ed:23:65:f2\",\"rssi\":\"12\"}]}";
		 System.out.println("start thread...");
		
		JSONObject jsonObj = new JSONObject( packet.getData().toString());
		JSONArray jsonArray=jsonObj.getJSONArray("Data");
		
		for(int i=0;i<jsonArray.length();i++)
		{	JSONObject js=jsonArray.getJSONObject(i);	
		
		Fingerprint referencePoint=new Fingerprint(this.positionX,this.positionY,js.getInt("direction"),packet.getAddress().toString(),(Double)js.getDouble("rssi"),db);
	//	Mobile_info mobile_info=new Mobile_info(js.getString("mac"),"df:dd:dd:de:23",(float)js.getDouble("rssi"),db);
		referencePoint.insert();
		}
	}
	



}
