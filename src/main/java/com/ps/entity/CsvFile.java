package com.ps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class CsvFile {

	@Id
	@GeneratedValue
	@Column(name = "fileID")
	private int fileID;

	@Column(name = "name")
	private String fileName;

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "fileID")
	private List<ValidRecord> validRecords;

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "fileID")
	private List<InvalidRecord> invalidRecords;

	public int getFileID() {
		return fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<ValidRecord> getValidRecords() {
		return validRecords;
	}

	public void setValidRecords(List<ValidRecord> validRecords) {
		this.validRecords = validRecords;
	}

	public List<InvalidRecord> getInvalidRecords() {
		return invalidRecords;
	}

	public void setInvalidRecords(List<InvalidRecord> invalidRecords) {
		this.invalidRecords = invalidRecords;
	}

}
