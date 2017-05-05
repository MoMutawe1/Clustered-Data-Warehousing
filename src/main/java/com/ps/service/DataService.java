package com.ps.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ps.entity.CsvFile;
import com.ps.util.EntityWrapper;

@Component
public interface DataService {

	public EntityWrapper parseFile(MultipartFile file) throws Exception;

	public boolean save(EntityWrapper wrapper) throws Exception;

	public CsvFile getCsvFile(String name);
}
