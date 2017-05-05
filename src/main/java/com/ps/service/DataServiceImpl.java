package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ps.dao.DataDao;
import com.ps.entity.CsvFile;
import com.ps.util.CsvParser;
import com.ps.util.EntityWrapper;

@Service
@Transactional
public class DataServiceImpl implements DataService {

	@Autowired
	private DataDao dataDao;

	public EntityWrapper parseFile(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub

		EntityWrapper wrapper = CsvParser.parseFile(file);

		return wrapper;
	}

	public boolean save(EntityWrapper wrapper) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.save(wrapper);
	}

	@Override
	public CsvFile getCsvFile(String name) {
		// TODO Auto-generated method stub
		return dataDao.getCsvFile(name);
	}

}
