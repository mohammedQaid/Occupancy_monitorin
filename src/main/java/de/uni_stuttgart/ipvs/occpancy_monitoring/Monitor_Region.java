package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.util.ArrayList;
import java.util.List;

public class Monitor_Region implements Runnable{
	// TODO Auto-generated constructor stub
			List<String> possibleListDevices;
		    List<Mobile_info> Deviceslist;
		    int id;
		    Region region= new Region(id);
	
	public Monitor_Region(int id) {
		this.id=id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// get all possible devices in a region by collecting all  associated devices on the AP's
		
						
	}
	
//	public List<String> getallpossible_devices_in_region(int id){
//		ArrayList<String> list= new ArrayList<>();
//		return list;
		
		
	}
	

