package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vilel.quintype.model.Customer;
import com.vilel.quintype.model.Driver;
import com.vilel.quintype.model.Location;
import com.vilel.quintype.model.Taxi;

import dao.TaxiDao;

public class TaxiUtils {
	
	public static List<Customer> customers = new ArrayList();
		
	public static Taxi findTaxi(Location sLoc, String color) {
		System.out.println("inside find taxi method");
		//CreateTaxis();
		System.out.println("loaded Taxis is "+TaxiDao.taxis.size());
		Map<Taxi, Double> availableTaxis = new HashMap<Taxi,Double>();
		Double minVal = null;
		Taxi nearestTaxi = null;
		for(Taxi taxi: TaxiDao.taxis) {
			System.out.println("iterating taxis list");
			if(taxi.getIsAvailable()==true) {				//&& taxi.getModel().equals(color)
				if(taxi.getColor().equals(color) || color == null) {
					System.out.println("found taxi with color: "+taxi.getColor());
					Double away = Math.sqrt(Math.abs(Math.pow(taxi.getCurrLoc().getLatitude() - sLoc.getLatitude(),2)) + Math.abs(Math.pow(taxi.getCurrLoc().getLongitude() - sLoc.getLongitude(),2)));
					System.out.println("nearest Taxi away at: "+away);
					availableTaxis.put(taxi,away);
				}
			}
		}
		
		System.out.println("No of filtered taxis: "+availableTaxis.size());
		
		if(!availableTaxis.isEmpty()) {
			
			Iterator iter1 = availableTaxis.entrySet().iterator();
			Map.Entry firstElement = (Map.Entry)iter1.next();
			minVal = (Double)firstElement.getValue();
			nearestTaxi = (Taxi)firstElement.getKey();
			System.out.println("taxi is "+minVal+" units away");
			
			if(availableTaxis.size()>1) {	
					System.out.println("iterating filtered taxis");
					Iterator iter = availableTaxis.entrySet().iterator();
					while(iter.hasNext()) {
						System.out.println("iterating using the second iterator");
						Map.Entry mapElement = (Map.Entry)iter.next();
						if((Double)mapElement.getValue()<minVal) {
							minVal = (Double)mapElement.getValue();
							nearestTaxi = (Taxi)mapElement.getKey();
				        }
			        }
			   }
			nearestTaxi.setIsAvailable(false);
		}
			System.out.println(nearestTaxi.getColor());
			return nearestTaxi;
		}
	
	public static Double calcCharge(Location sLoc, Location eLoc, Taxi taxi) {
		Double distInKM = Math.sqrt(Math.abs(Math.pow(eLoc.getLatitude() - sLoc.getLatitude(),2)) + Math.abs(Math.pow(eLoc.getLongitude() - sLoc.getLongitude(),2)));
		Double charge = distInKM*taxi.getRate();
		return charge;
	}
	
	public static void addCustomer(Customer cust) {
		customers.add(cust);
	}
	
	//to remove
	public static List<Customer> getAllCustomers(){
		return customers;
	}
	
	public static Boolean cancelRide(String taxiNo) {
		for(Taxi taxi: TaxiDao.taxis) {
			if(taxi.getVechicleNo().equals(taxiNo)) {
				taxi.setIsAvailable(false);
				return true;
			}
		}
		return false;
	}
	
	public static String endRide(Location sLoc, Location eLoc,  String taxiNo) {
		for(Taxi taxi: TaxiDao.taxis) {
			if(taxi.getVechicleNo().equals(taxiNo) && taxi.getIsAvailable()==false) {
				taxi.setIsAvailable(true);
				Double fare = calcCharge(sLoc, eLoc, taxi);
				return "your payment for ride is: "+fare;
			}
		}
		return null;
	}
	
	public static List<Taxi> getFreeTaxis(){
		List<Taxi> freeTaxis = new ArrayList();
		for(Taxi taxi: TaxiDao.taxis) {
			if(taxi.getIsAvailable()) 
				freeTaxis.add(taxi);	
		}
		System.out.println(freeTaxis.size());
	return freeTaxis;
	}
	
}
