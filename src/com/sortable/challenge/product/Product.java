package com.sortable.challenge.product;

import com.sortable.challenge.ManufacturerKeyBuilder;
import com.sortable.challenge.ModelNumberBuilder;

public class Product {

	private final String manufacturer;
	private final String name;
	private final String model;
	private final String family;
	private final String announceDate;
	private final String manufacturerKey;
	private final String modelKey;

	public Product(String manufacturer, String name, String model,
			String family, String announceDate) {
		super();
		this.manufacturer = manufacturer;
		this.name = name;
		this.model = model;
		this.family = family;
		this.announceDate = announceDate;
		this.manufacturerKey = new ManufacturerKeyBuilder(manufacturer).build();
		this.modelKey = new ModelNumberBuilder(model).build();
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public String getFamily() {
		return family;
	}

	public String getAnnounceDate() {
		return announceDate;
	}

	public String getManufacturerKey() {
		return manufacturerKey;
	}

	public String getModelKey() {
		return modelKey;
	}

}
