package com.hrushikeshsalkade.annotation;

@Table(tableName="Country", databaseName="hsalkade", databaseUri="content://hsalkade/country")
public class Country {

	private String name;
	private String continent;
	private int category;
	private String currency;
	
	public Country() {
		this("", "", 0, "");
	}
	
	public Country(String name, String continent, int category, String currency) {
		super();
		this.name = name;
		this.continent = continent;
		this.category = category;
		this.currency = currency;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", continent=" + continent + ", category=" + category + ", currency="
				+ currency + "]";
	}
}
