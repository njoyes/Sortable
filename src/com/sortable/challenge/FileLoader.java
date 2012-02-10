package com.sortable.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sortable.challenge.parser.AbstractLineParser;

public class FileLoader<O extends Object> {

	private final File file;

	private final AbstractLineParser<O> parser;

	public FileLoader(File file, AbstractLineParser<O> parser) {
		super();
		this.file = file;
		this.parser = parser;
	}

	public List<O> load() {
		List<O> list = new ArrayList<O>();
		try {
			loadFile(list);
		} catch (IOException e) {
			// ignore
		}
		return list;
	}

	private void loadFile(List<O> list) throws FileNotFoundException,
			IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while (null != (line = reader.readLine())) {
			list.add(parser.parse(line));
		}
	}

}
