package com.ps.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CsvParserTest {
	
	@Test
	public void validateRecord(){
		String[] arr={"134xyz","from","to","11/02/2011 08:23", "45.00"};
		assertEquals(true, CsvParser.validateRecord(arr));
	}
	
	
	@Test
	public void inValidRecord(){
		String[] arr={"134xyz","from","to","11/02/2011 08:23", "45.00text"};
		assertEquals(false, CsvParser.validateRecord(arr));
	}

}
