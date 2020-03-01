package com.vilel.quintype.controller;

import java.util.List;
import java.util.Map;

//import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vilel.quintype.model.Customer;
import com.vilel.quintype.model.Location;
import com.vilel.quintype.model.Taxi;

import javafx.util.Pair;
import service.TaxiServiceCustomer;
import service.TaxiServiceCustomerImpl;

@Path("riderResource")
public class RiderResource {
	TaxiServiceCustomer tsc = new TaxiServiceCustomerImpl();
	
	//http://localhost:18080/quintype/webapi/riderResource/booktaxi?slat=0.0&slon=0.0&dlat=10&dlon=3&color=pink
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("booktaxi")
	public Response BookTaxi(
			@QueryParam("slat") Double sLat,
			@QueryParam("slon") Double sLon,
			@QueryParam("dlat") Double dLat,
			@QueryParam("dlon") Double dLon,
			@QueryParam("color") String color
			) {
		Location sLocation = new Location(sLat,sLon);
		Location dLocation = new Location(dLat,dLon);
		Pair<Taxi,Double> booked = tsc.bookRide(sLocation, dLocation, null, color);
		System.out.println(booked.getValue());
		if(booked != null)
			return Response.status(200).entity("Congrats, Taxi booked with color: "+booked.getKey().getColor()+", Reg No: "+booked.getKey().getVechicleNo()+", Estimated price is: "+booked.getValue()).build();
		else
			return Response.status(200).entity("Sorry, Taxi of your choice is not available. Please try again").build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("endtrip")
	public Response EndTrip(
			@QueryParam("slat") Double sLat,
			@QueryParam("slon") Double sLon,
			@QueryParam("dlat") Double dLat,
			@QueryParam("dlon") Double dLon,
			@QueryParam("taxiNo") String taxiNo
			) {
		Location sLocation = new Location(sLat,sLon);
		Location dLocation = new Location(dLat,dLon);
		String message = tsc.endRide(sLocation, dLocation, taxiNo);
		
		if(message != null)
			return Response.status(200).entity(message).build();
		else
			return Response.status(200).entity("Error encountered while ending your trip. Please try again").build();
	}
	
//	<customer>
//	<aadharNo>AAD101</aadharNo>
//	<custName>Navaneeth</custName>
//	</customer>
//
//	{
//	    "aadharNo": "AAD101",
//	    "custName": "Navaneeth"
//	}
	
	@POST
	@Path("newCustomer")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Customer createCustomer(Customer inc) {	
		if(tsc.registerCustomer(inc) !=null) {
			return inc;
		}
		return null;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON}) //,MediaType.APPLICATION_XML
	@Path("getCustomers")
	public List<Customer> getCustomers() {
		return tsc.getCustomer();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON}) //,MediaType.APPLICATION_XML
	@Path("getAvailableTaxis")
	public List<Taxi> getAvailableTaxis() {
		return tsc.getFreeTaxis();
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("canceltrip")
	public Boolean CancelTrip() {
		return true;
	}
}
