package com.ps.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CsvParserTest {

	
	@Test
	public void validateRecord(){
		String[] arrString={"1","FROm","to","2045/10/20","34.50"};
		
		assertEquals(true,CsvParser.validateRecord(arrString));
		
		arrString= new String[]{"1","FROm","to","2045/10/20","34.50i"};
		assertEquals(false,CsvParser.validateRecord(arrString));
	}
}
