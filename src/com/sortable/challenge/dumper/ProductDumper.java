package com.sortable.challenge.dumper;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import com.sortable.challenge.product.Product;
import com.sortable.challenge.product.ProductComparator;

public class ProductDumper {

	private final List<Product> products;

	public ProductDumper(List<Product> products) {
		super();
		this.products = products;
		Collections.sort(products, new ProductComparator());
	}

	public void dump(PrintStream out) {
		String curManufacturer = null;
		for (Product product : products) {
			curManufacturer = printManufacturer(out, curManufacturer, product);
			out.println("  " + product.getModel());
		}
	}

	private String printManufacturer(PrintStream out, String curManufacturer,
			Product product) {
		if (!product.getManufacturer().equals(curManufacturer)) {
			out.println(product.getManufacturer());
			curManufacturer = product.getManufacturer();
		}
		return curManufacturer;
	}

}
