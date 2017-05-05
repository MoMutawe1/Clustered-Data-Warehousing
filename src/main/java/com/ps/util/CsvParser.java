package com.ps.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ps.entity.CsvFile;
import com.ps.entity.InvalidRecord;
import com.ps.entity.ValidRecord;

public class CsvParser {

	public static EntityWrapper parseFile(MultipartFile file) throws Exception {

		EntityWrapper wrapper = new EntityWrapper();

		CsvFile csv = new CsvFile();
		csv.setFileName(file.getOriginalFilename());

		// I am using hashtable to store the no of deals for given ordering
		// currency
		// The deals will be added only for the valid records

		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();

		DataInputStream in = new DataInputStream(file.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String line;
		List<ValidRecord> arrValidRecord = new ArrayList<ValidRecord>();
		List<InvalidRecord> arrInvalidRecord = new ArrayList<InvalidRecord>();
		while ((line = br.readLine()) != null) {

			String[] arrString = line.split(",");

			if (validateRecord(arrString)) {

				ValidRecord record = new ValidRecord();

				record.setUniqueID(arrString[0]);
				record.setFromCurrencyCode(arrString[1]);
				record.setToCurrencyCode(arrString[2]);
				record.setDateTime(arrString[3]);
				record.setAmount(Double.parseDouble(arrString[4]));

				arrValidRecord.add(record);

				// update the deals now

				hash.put(record.getFromCurrencyCode(), hash.get(record.getFromCurrencyCode()) == null ? 1
						: hash.get(record.getFromCurrencyCode()) + 1);

			} else {// if not validated

				InvalidRecord invRecord = new InvalidRecord();

				invRecord.setUniqueID(arrString[0]);
				invRecord.setFromCurrencyCode(arrString[1]);
				invRecord.setToCurrencyCode(arrString[2]);
				invRecord.setDateTime(arrString[3]);
				invRecord.setAmount(arrString[4]);

				arrInvalidRecord.add(invRecord);
			}
		}
		br.close();

		csv.setValidRecords(arrValidRecord);
		csv.setInvalidRecords(arrInvalidRecord);
		wrapper.setFile(csv);
		wrapper.setDeals(hash);

		return wrapper;
	}

	// For the time being , we are validating amount.The amount should be double
	public static boolean validateRecord(String[] arrString) {
		try {
			Double.parseDouble(arrString[4]);

		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
