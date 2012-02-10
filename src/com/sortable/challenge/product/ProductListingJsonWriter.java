package com.sortable.challenge.product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import com.sortable.challenge.listing.Listing;

public class ProductListingJsonWriter {

	private static final String NAME = "product_name";

	private static final String TITLE = "title";

	private static final String MANUFACTURER = "manufacturer";

	private static final String CURRENCY = "currency";

	private static final String PRICE = "price";

	private final Map<Product, List<Listing>> listingsByProduct;

	private final String outputFile;

	public ProductListingJsonWriter(
			Map<Product, List<Listing>> listingsByProduct, String outputFile) {
		super();
		this.listingsByProduct = listingsByProduct;
		this.outputFile = outputFile;
	}

	public void write() {
		Writer w = initWriter();
		for (Map.Entry<Product, List<Listing>> entry : listingsByProduct
				.entrySet()) {
			write("{", w);
			writeProduct(entry.getKey(), w);
			writeListings(w, entry);
			write("}", w);
			write("\n", w);
		}
		close(w);
	}

	private Writer initWriter() {
		try {
			return new FileWriter(new File(outputFile));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void writeProduct(Product product, Writer w) {
		writeJsonKeyValue(NAME, product.getName(), w);
		write(", ", w);
	}

	private void writeJsonKeyValue(String key, String value, Writer w) {
		write("\"" + key + "\" : \"" + value + "\"", w);
	}

	private void writeListings(Writer w, Map.Entry<Product, List<Listing>> entry) {
		write("\"listings\" : [ ", w);
		boolean firstListing = true;
		for (Listing l : entry.getValue()) {
			if (!firstListing) {
				write(", ", w);
			}
			writeListing(l, w);
			firstListing = false;
		}
		write("]", w);
	}

	private void writeListing(Listing l, Writer w) {
		write("{", w);
		writeJsonKeyValue(TITLE, l.getTitle(), w);
		write(", ", w);
		writeJsonKeyValue(MANUFACTURER, l.getManufacturer(), w);
		write(", ", w);
		writeJsonKeyValue(CURRENCY, l.getCurrency(), w);
		write(", ", w);
		writeJsonKeyValue(PRICE, l.getPrice(), w);
		write("}", w);
	}

	private void write(String string, Writer writer) {
		try {
			writer.write(string);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void close(Writer w) {
		try {
			w.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
