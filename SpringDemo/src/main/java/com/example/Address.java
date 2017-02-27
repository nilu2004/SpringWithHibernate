package com.example;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;

	public Address() {
		System.out.println("address default constructor");
	}
	public Address(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adderess [city=" + city + "]";
	}
	
}
