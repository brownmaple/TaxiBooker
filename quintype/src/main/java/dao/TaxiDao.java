package dao;

import java.util.ArrayList;
import java.util.List;

import com.vilel.quintype.model.Driver;
import com.vilel.quintype.model.Location;
import com.vilel.quintype.model.Taxi;

public class TaxiDao {

public static List<Taxi> taxis = new ArrayList();	
	
	static {
		
		Driver d1 = new Driver();
		d1.setDriverName("driver1");
		d1.setLicenseNo("DL101");
		
		Taxi taxi1 = new Taxi();
		taxi1.setColor("green");
		Location loc1 = new Location();
		loc1.setLatitude(1.0);
		loc1.setLongitude(5.0);
		taxi1.setCurrLoc(loc1);
		taxi1.setIsAvailable(true);
		taxi1.setRate(5.0);
		taxi1.setVechicleNo("TN101");
		taxi1.setDriver(d1);
		taxi1.setModel("sedan");
		
		Driver d2 = new Driver();
		d2.setDriverName("driver2");
		d2.setLicenseNo("DL102");
		
		Taxi taxi2 = new Taxi();
		taxi2.setColor("red");
		Location loc2 = new Location();
		loc2.setLatitude(2.0);
		loc2.setLongitude(4.0);
		taxi2.setCurrLoc(loc2);
		taxi2.setIsAvailable(true);
		taxi2.setRate(5.0);
		taxi2.setVechicleNo("TN102");
		taxi2.setDriver(d2);
		taxi2.setModel("hatchback");
		
		Driver d3 = new Driver();
		d3.setDriverName("driver3");
		d3.setLicenseNo("DL103");
		
		Taxi taxi3 = new Taxi();
		taxi3.setColor("pink");
		Location loc3 = new Location();
		loc3.setLatitude(5.0);
		loc3.setLongitude(8.0);
		taxi3.setCurrLoc(loc3);
		taxi3.setIsAvailable(true);
		taxi3.setRate(15.0);
		taxi3.setVechicleNo("TN103");
		taxi3.setDriver(d3);
		taxi3.setModel("jeep");
		
		Driver d4 = new Driver();
		d4.setDriverName("driver4");
		d4.setLicenseNo("DL104");
		
		Taxi taxi4 = new Taxi();
		taxi4.setColor("yellow");
		Location loc4 = new Location();
		loc4.setLatitude(4.0);
		loc4.setLongitude(1.0);
		taxi4.setCurrLoc(loc4);
		taxi4.setIsAvailable(true);
		taxi4.setRate(6.0);
		taxi4.setVechicleNo("TN104");
		taxi4.setDriver(d4);
		taxi4.setModel("limousine");
		
		Driver d5 = new Driver();
		d5.setDriverName("driver5");
		d5.setLicenseNo("DL105");
		
		Taxi taxi5 = new Taxi();
		taxi5.setColor("white");
		Location loc5 = new Location();
		loc5.setLatitude(3.0);
		loc5.setLongitude(7.0);
		taxi5.setCurrLoc(loc5);
		taxi5.setIsAvailable(true);
		taxi5.setRate(6.0);
		taxi5.setVechicleNo("TN105");
		taxi5.setDriver(d5);
		taxi5.setModel("race");
		
		taxis.add(taxi5);
		taxis.add(taxi4);
		taxis.add(taxi3);
		taxis.add(taxi2);
		taxis.add(taxi1);
}
	
}
