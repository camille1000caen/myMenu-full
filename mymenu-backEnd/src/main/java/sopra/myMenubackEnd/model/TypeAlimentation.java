package sopra.myMenubackEnd.model;

public enum TypeAlimentation {
	NONE("None"),VEGAN("VEGAN"),HALAL("HALAL"),VEGETARIEN("VEGETARIEN"),FLEXITARIEN("FLEXITARIEN");
	
	private final String label;

	private TypeAlimentation(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
