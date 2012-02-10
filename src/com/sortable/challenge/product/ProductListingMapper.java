package com.sortable.challenge.product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sortable.challenge.listing.Listing;

public class ProductListingMapper {

	private final ProductLookup lookup;
	private final Map<Product, List<Listing>> listingsByProduct;

	public ProductListingMapper(List<Product> products, List<Listing> listings) {
		super();
		this.lookup = new ProductLookup(products);
		this.listingsByProduct = new LinkedHashMap<Product, List<Listing>>();
		initMap(products);
		mapListingToProducts(listings);
	}

	private void initMap(List<Product> products) {
		for (Product product : products) {
			listingsByProduct.put(product, new ArrayList<Listing>());
		}
	}

	private void mapListingToProducts(List<Listing> listings) {
		for (Listing listing : listings) {
			Product product = lookup.lookup(listing);
			if (null != product) {
				listingsByProduct.get(product).add(listing);
			}
		}
	}

	public Map<Product, List<Listing>> getListingsByProduct() {
		return listingsByProduct;
	}

}
