package service;

import com.vilel.quintype.model.Taxi;

public interface TaxiServiceDriver {
	public Boolean startRide(Taxi taxi);
	public Boolean endRide();
}
