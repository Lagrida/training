package net.pluriel.entities.commons;

public enum Country {

	American("American"), British("British"), French("French");

	private final String country;

	Country(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}
}
