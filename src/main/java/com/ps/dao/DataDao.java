package com.ps.dao;

import com.ps.entity.CsvFile;
import com.ps.util.EntityWrapper;

public interface DataDao {

	public boolean save(EntityWrapper wrapper);

	public CsvFile getCsvFile(String name);

}
