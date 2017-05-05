package com.ps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "count_of_deals")
public class CountDeal {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int id;

	@Column(name = "isoCode")
	private String code;

	@Column(name = "countOfDeals")
	private int countOfDeals;

	public CountDeal(String code, int countOfDeals) {
		this.code = code;
		this.countOfDeals = countOfDeals;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCountOfDeals() {
		return countOfDeals;
	}

	public void setCountOfDeals(int countOfDeals) {
		this.countOfDeals = countOfDeals;
	}

}
