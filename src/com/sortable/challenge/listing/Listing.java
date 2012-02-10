package com.sortable.challenge.listing;

import com.sortable.challenge.ManufacturerKeyBuilder;
import com.sortable.challenge.ModelNumberBuilder;

public class Listing {

	private final String manufacturer;
	private final String title;
	private final String currency;
	private final String price;
	private final String manufacturerKey;
	private final String titleKey;

	public Listing(String manufacturer, String title, String currency,
			String price) {
		super();
		this.manufacturer = manufacturer;
		this.title = title;
		this.currency = currency;
		this.price = price;
		this.manufacturerKey = new ManufacturerKeyBuilder(manufacturer).build();
		this.titleKey = new ModelNumberBuilder(title).build();
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getTitle() {
		return title;
	}

	public String getCurrency() {
		return currency;
	}

	public String getPrice() {
		return price;
	}

	public String getManufacturerKey() {
		return manufacturerKey;
	}

	public String getTitleKey() {
		return titleKey;
	}

}
