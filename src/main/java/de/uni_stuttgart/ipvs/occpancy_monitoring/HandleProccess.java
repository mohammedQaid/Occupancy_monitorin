package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.net.DatagramPacket;

import org.json.JSONArray;
import org.json.JSONObject;



public class HandleProccess implements Runnable {
	private Database db = null;
	 
	
	  private DatagramPacket packet = null;
	  byte[] buffer = new byte[2048];
	  
	public HandleProccess( DatagramPacket packet, Database db) {
		this.db=db;

		this.packet=packet;
		}
	@Override
	public void run() {
		
	//	String ss= "{Data:[{\"mac\":\"12:ed:23:65:f2\",\"rssi\":\"12\"},{\"mac\":\"12:ed:23:65:f2\",\"rssi\":\"12\"}]}";
		 System.out.println("start thread...");
		
		JSONObject jsonObj = new JSONObject( packet.getData().toString());
		JSONArray jsonArray=jsonObj.getJSONArray("Data");
		
		
		JSONObject js=jsonArray.getJSONObject(0);	
		Mobile_info mobile_info=new Mobile_info(js.getString("mac"),packet.getAddress().toString(),(float)js.getDouble("rssi"),(int)js.getInt("type"),db);
//	Mobile_info mobile_info=new Mobile_info(js.getString("mac"),"df:dd:dd:de:23",(float)js.getDouble("rssi"),db);
		mobile_info.insert();
		
//	//	for(int i=0;i<jsonArray.length();i++)
//		{	JSONObject js=jsonArray.getJSONObject(i);	
//			Mobile_info mobile_info=new Mobile_info(js.getString("mac"),packet.getAddress().toString(),(float)js.getDouble("rssi"),(int)js.getInt("type"),db);
//	//	Mobile_info mobile_info=new Mobile_info(js.getString("mac"),"df:dd:dd:de:23",(float)js.getDouble("rssi"),db);
//			mobile_info.insert();
//		}
		
		
	}
	



}
