package com.vilel.quintype.model;

public class Location {
	private Double longitude;
	private Double latitude;
	
	public Location() {
	}
	
	public Location(Double lati, Double longi) {
		this.latitude = lati;
		this.longitude = longi;
	}
	
	public Double getPoint() {
		return (longitude+latitude)/2;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
}
