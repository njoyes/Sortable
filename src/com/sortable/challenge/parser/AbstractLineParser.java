package com.sortable.challenge.parser;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLineParser<O extends Object> {

	public O parse(String line) {
		Map<String, String> map = new HashMap<String, String>();
		for (String part : splitLineByParts(line)) {
			map.put(lineKeyPart(part), lineValuePart(part));
		}
		return toObject(map);
	}

	private String[] splitLineByParts(String line) {
		return line.replace("{\"", "").replace("\"}", "").split("\",\"");
	}

	private String lineKeyPart(String part) {
		return part.substring(0, part.indexOf("\":\""));
	}

	private String lineValuePart(String part) {
		return part.substring(part.indexOf("\":\"") + 3);
	}

	protected abstract O toObject(Map<String, String> map);

}
