package service;

import java.util.List;
import java.util.Map;

import com.vilel.quintype.model.Customer;
import com.vilel.quintype.model.Location;
import com.vilel.quintype.model.Taxi;

import javafx.util.Pair;

public interface TaxiServiceCustomer {
	public Pair<Taxi,Double> bookRide(Location sLoc, Location eLoc, Customer cust,String choice);
	public Boolean cancelRide(String taxiNo);
	public Customer registerCustomer(Customer newCust);
	public List<Customer> getCustomer();
	public String endRide(Location sLoc, Location eLoc, String taxiNo);
	public List<Taxi> getFreeTaxis();
}
