package com.sortable.challenge;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.sortable.challenge.listing.Listing;
import com.sortable.challenge.parser.ListingLineParser;
import com.sortable.challenge.parser.ProductLineParser;
import com.sortable.challenge.product.Product;
import com.sortable.challenge.product.ProductListingJsonWriter;
import com.sortable.challenge.product.ProductListingMapper;

public class Bootstrap {

	private final String productsFile;

	private final String listingsFile;

	private final String outputFile;

	private final boolean printTiming;

	private final boolean printHelp;

	public Bootstrap(BootstrapArguments args) {
		super();
		this.productsFile = args.getProductsFile();
		this.listingsFile = args.getListingsFile();
		this.outputFile = args.getOutputFile();
		this.printTiming = args.isPrintTiming();
		this.printHelp = args.isPrintHelp();
	}

	private void run() throws IOException {
		long start = System.currentTimeMillis();
		if (printHelp) {
			printHelp();
		} else {
			new ProductListingJsonWriter(listingsByProduct(), outputFile).write();
		}
		if (printTiming) {
			System.out.println((System.currentTimeMillis() - start) + "ms");
		}
	}

	private void printHelp() {
		System.out
				.println("command to match product listings to products in a product database");
		System.out
				.println("  -p file - specify product file (defaults to products.txt)");
		System.out
				.println("  -l file - specify listing file (defaults to listings.txt)");
		System.out
				.println("  -o file - specify output file (defaults to listing_by_products.txt)");
		System.out.println("  -h - print this help menu");
		System.out.println("  -t - print execution timing");
	}

	private Map<Product, List<Listing>> listingsByProduct() {
		return new ProductListingMapper(loadProducts(), loadListings())
				.getListingsByProduct();
	}

	private List<Product> loadProducts() {
		return new FileLoader<Product>(new File(productsFile),
				new ProductLineParser()).load();
	}

	private List<Listing> loadListings() {
		return new FileLoader<Listing>(new File(listingsFile),
				new ListingLineParser()).load();
	}

	public static final void main(String[] args) {
		try {
			new Bootstrap(new BootstrapArguments(args)).run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	static class BootstrapArguments {

		private static final String DEFAULT_PRODUCTS_FILE = "products.txt";

		private static final String DEFAULT_LISTINGS_FILE = "listings.txt";

		private static final String DEFAULT_OUTPUT_FILE = "listing_by_products.txt";

		private static final boolean DEFAULT_PRINT_TIMING = false;

		private static final boolean DEFAULT_PRINT_HELP = false;

		private String productsFile = DEFAULT_PRODUCTS_FILE;

		private String listingsFile = DEFAULT_LISTINGS_FILE;

		private String outputFile = DEFAULT_OUTPUT_FILE;

		private boolean printTiming = DEFAULT_PRINT_TIMING;

		private boolean printHelp = DEFAULT_PRINT_HELP;

		public BootstrapArguments(String[] args) {
			super();
			for (int i = 0; i < args.length; i++) {
				if ("-h".equals(args[i]) || "--help".equals(args[i])) {
					printHelp = true;
				} else if ("-p".equals(args[i])) {
					productsFile = args[++i];
				} else if ("-l".equals(args[i])) {
					listingsFile = args[++i];
				} else if ("-o".equals(args[i])) {
					outputFile = args[++i];
				} else if ("-t".equals(args[i])) {
					printTiming = true;
				} else {
					printHelp = true;
				}
			}
		}

		public String getProductsFile() {
			return productsFile;
		}

		public String getListingsFile() {
			return listingsFile;
		}

		public String getOutputFile() {
			return outputFile;
		}

		public boolean isPrintTiming() {
			return printTiming;
		}

		public boolean isPrintHelp() {
			return printHelp;
		}

	}

}
