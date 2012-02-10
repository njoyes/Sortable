package com.sortable.challenge;

public class ManufacturerKeyBuilder {

	private final String manufacturer;

	public ManufacturerKeyBuilder(String manufacturer) {
		super();
		this.manufacturer = manufacturer;
	}

	public String build() {
		return firstManufacturerNamePart().toUpperCase();
	}

	public String firstManufacturerNamePart() {
		if (-1 != manufacturer.indexOf(' ')) {
			return manufacturer.substring(0, manufacturer.indexOf(' '));
		}
		return manufacturer;
	}

}
