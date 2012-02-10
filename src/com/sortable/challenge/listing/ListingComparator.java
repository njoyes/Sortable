package com.sortable.challenge.listing;

import java.util.Comparator;

public class ListingComparator extends Object implements Comparator<Listing> {

	@Override
	public int compare(Listing arg0, Listing arg1) {
		return arg0.getTitle().compareTo(arg1.getTitle());
	}
}
