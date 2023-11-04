package model.service;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		
	  double minute = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
	  double hour = minute / 60.0;
	  
	  double basicPayment;
	  if(hour <= 12.0) {
		  basicPayment = pricePerHour * Math.ceil(hour);
	  }
	  else {
		  basicPayment = pricePerDay * Math.ceil(hour / 24.0);
	  }
	  
	  double tax = taxService.tax(basicPayment);
	  
	  carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
}
