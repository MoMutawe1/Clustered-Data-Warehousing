package com.ps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valid_records")
public class ValidRecord {

	@Id
	@GeneratedValue
	@Column(name = "recordID")
	private int recordID;

	@Column(name = "uniqueID")
	private String uniqueID;

	@Column(name = "fromCode")
	private String fromCurrencyCode;

	@Column(name = "toCode")
	private String toCurrencyCode;

	@Column(name = "dateTime")
	private String dateTime;

	@Column(name = "amount")
	private double amount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fileID")
	private CsvFile file;

	public CsvFile getFile() {
		return file;
	}

	public void setFile(CsvFile file) {
		this.file = file;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

}
