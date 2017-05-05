package com.ps.util;

import java.util.Hashtable;

import com.ps.entity.CsvFile;

//This object is a wrapper for all the persisent objects.

public class EntityWrapper {

	private CsvFile file;

	private Hashtable<String, Integer> deals;

	public CsvFile getFile() {
		return file;
	}

	public void setFile(CsvFile file) {
		this.file = file;
	}

	public Hashtable<String, Integer> getDeals() {
		return deals;
	}

	public void setDeals(Hashtable<String, Integer> deals) {
		this.deals = deals;
	}

}
