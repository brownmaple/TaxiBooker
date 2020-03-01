package service;

import java.util.List;

import com.vilel.quintype.model.Customer;
import com.vilel.quintype.model.Location;
import com.vilel.quintype.model.Taxi;

import javafx.util.Pair;
import utils.TaxiUtils;

public class TaxiServiceCustomerImpl implements TaxiServiceCustomer{
	
	@Override
	public Pair<Taxi,Double> bookRide(Location sLoc, Location eLoc, Customer cust, String color) {
		Taxi myTaxi = TaxiUtils.findTaxi(sLoc,color);
		System.out.println(myTaxi);
		Double estimatedAmount = TaxiUtils.calcCharge(sLoc, eLoc, myTaxi);
		Pair<Taxi,Double> bookedDetails = new Pair(myTaxi, estimatedAmount);
		return bookedDetails;
	}
	
	@Override
	public Boolean cancelRide(String taxiNo) {
		return TaxiUtils.cancelRide(taxiNo);
	}

	@Override
	public Customer registerCustomer(Customer newCust) {
		TaxiUtils.addCustomer(newCust);
		return newCust;
	}

	@Override
	public List<Customer> getCustomer() {
		return TaxiUtils.getAllCustomers();
	}

	@Override
	public String endRide(Location sLoc, Location eLoc, String taxiNo) {
		return TaxiUtils.endRide(sLoc, eLoc, taxiNo);
	}

	@Override
	public List<Taxi> getFreeTaxis() {
		return TaxiUtils.getFreeTaxis();
	}
}
