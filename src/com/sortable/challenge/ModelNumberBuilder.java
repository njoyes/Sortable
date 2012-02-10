package com.sortable.challenge;

public class ModelNumberBuilder {

	private String string;

	public ModelNumberBuilder(String string) {
		super();
		this.string = string;
	}

	public String build() {
		return string.replace("_", "").replace("-", "").replace(" ", "")
				.toUpperCase();
	}

}
