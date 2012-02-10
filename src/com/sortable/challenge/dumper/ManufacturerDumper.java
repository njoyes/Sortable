package com.sortable.challenge.dumper;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sortable.challenge.listing.Listing;
import com.sortable.challenge.product.Product;

public class ManufacturerDumper {

	private final Collection<String> manufacturers;

	public ManufacturerDumper(List<Product> products, List<Listing> listings) {
		super();
		this.manufacturers = initManufacturers(products, listings);
	}

	private Collection<String> initManufacturers(List<Product> products,
			List<Listing> listings) {
		List<String> ms = new ArrayList<String>();
		initProductManufacturers(products, ms);
		initListingManufacturers(listings, ms);
		Collections.sort(ms);
		return ms;
	}

	private void initProductManufacturers(List<Product> products,
			List<String> manufacturers) {
		for (Product p : products) {
			if (!manufacturers.contains(p.getManufacturer())) {
				manufacturers.add(p.getManufacturer());
			}
		}
	}

	private void initListingManufacturers(List<Listing> listings,
			List<String> manufacturers) {
		for (Listing l : listings) {
			if (!manufacturers.contains(l.getManufacturer())) {
				manufacturers.add(l.getManufacturer());
			}
		}
	}

	public void dump(PrintStream out) {
		for (String m : manufacturers) {
			out.println(m);
		}
	}

}
