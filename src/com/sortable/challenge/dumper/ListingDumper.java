package com.sortable.challenge.dumper;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import com.sortable.challenge.listing.Listing;
import com.sortable.challenge.listing.ListingComparator;
import com.sortable.challenge.product.Product;
import com.sortable.challenge.product.ProductLookup;

public class ListingDumper {

	private final List<Listing> listings;

	private final ProductLookup productLookup;

	public ListingDumper(List<Listing> listings, List<Product> products) {
		super();
		this.listings = listings;
		Collections.sort(listings, new ListingComparator());
		productLookup = new ProductLookup(products);
	}

	public void dump(PrintStream out) {
		String curManufacturer = null;
		for (Listing obj : listings) {
			curManufacturer = printManufacturer(out, curManufacturer, obj);
			printListing(out, obj);
			printProductForListing(out, obj);
			out.println();
		}
	}

	private String printManufacturer(PrintStream out, String curManufacturer,
			Listing obj) {
		if (!obj.getManufacturer().equals(curManufacturer)) {
			out.println(obj.getManufacturer());
			curManufacturer = obj.getManufacturer();
		}
		return curManufacturer;
	}

	private void printListing(PrintStream out, Listing obj) {
		out.print("  " + obj.getTitle() + " " + obj.getPrice());
	}

	private void printProductForListing(PrintStream out, Listing obj) {
		Product p = productLookup.lookup(obj);
		if (null != p) {
			out.print(" => " + p.getName());
		}
	}
}
