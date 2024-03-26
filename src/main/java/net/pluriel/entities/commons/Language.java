package net.pluriel.entities.commons;

public enum Language {

	English("English"), Japanese("Japanese"), Chinese("Chinese"), Portuguese("Portuguese");

	private final String language;

	Language(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return this.language;
	}
}
