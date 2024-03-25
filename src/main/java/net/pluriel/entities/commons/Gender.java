package net.pluriel.entities.commons;

public enum Gender {
	Homme("Homme"), Femme("Femme");
	
	private final String gender;
	
	Gender(String gender){
		this.gender = gender;
	}
	
	public String getGender() {
		return this.gender;
	}

}
