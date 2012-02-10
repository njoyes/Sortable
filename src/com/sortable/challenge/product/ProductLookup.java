package com.sortable.challenge.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sortable.challenge.listing.Listing;

public class ProductLookup {

	private final Map<String, Collection<Product>> products;

	public ProductLookup(Collection<Product> products) {
		super();
		this.products = new HashMap<String, Collection<Product>>();
		initProductsByManufacturerMap(products);
	}

	private void initProductsByManufacturerMap(Collection<Product> ps) {
		for (Product p : ps) {
			addProductToManufacturerMap(p);
		}
	}

	private void addProductToManufacturerMap(Product p) {
		if (!products.containsKey(p.getManufacturerKey())) {
			initializeProductlist(p);
		}
		products.get(p.getManufacturerKey()).add(p);
	}

	private void initializeProductlist(Product p) {
		products.put(p.getManufacturerKey(), new ArrayList<Product>());
	}

	public Product lookup(Listing listing) {
		for (Product product : productsForManufacturer(listing)) {
			if (productMatchesListing(product, listing)) {
				return product;
			}
		}
		return null;
	}

	private Collection<Product> productsForManufacturer(Listing listing) {
		if (!products.containsKey(listing.getManufacturerKey())) {
			return new ArrayList<Product>();
		}
		return products.get(listing.getManufacturerKey());
	}

	private boolean productMatchesListing(Product p, Listing l) {
		return l.getTitleKey().contains(p.getModelKey());
	}

}
