package com.sortable.challenge.parser;

import java.util.Map;

import com.sortable.challenge.product.Product;

public class ProductLineParser extends AbstractLineParser<Product> {

	private static final String NAME = "product_name";
	private static final String MANUFACTURER = "manufacturer";
	private static final String MODEL = "model";
	private static final String FAMILY = "family";
	private static final String ANNOUNCE = "announced-date";

	@Override
	protected Product toObject(Map<String, String> map) {
		return new Product(map.get(MANUFACTURER), map.get(NAME),
				map.get(MODEL), map.get(FAMILY), map.get(ANNOUNCE));
	}

}
