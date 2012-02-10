package com.sortable.challenge.product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product arg0, Product arg1) {
		if (!arg0.getManufacturer().equals(arg1.getManufacturer())) {
			return arg0.getManufacturer().compareTo(arg1.getManufacturer());
		}
		return arg0.getName().compareTo(arg1.getName());
	}

}
