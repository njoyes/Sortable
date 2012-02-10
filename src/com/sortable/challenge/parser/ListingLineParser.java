package com.sortable.challenge.parser;

import java.util.Map;

import com.sortable.challenge.listing.Listing;

public class ListingLineParser extends AbstractLineParser<Listing> {

	private static final String MANUFACTURER = "manufacturer";
	private static final String TITLE = "title";
	private static final String CURRENCY = "currency";
	private static final String PRICE = "price";

	@Override
	protected Listing toObject(Map<String, String> map) {
		return new Listing(map.get(MANUFACTURER), map.get(TITLE),
				map.get(CURRENCY), map.get(PRICE));
	}

}
