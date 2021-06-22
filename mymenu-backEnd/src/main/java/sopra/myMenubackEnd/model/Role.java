package sopra.myMenubackEnd.model;

public enum Role {
	ADMIN("ADMIN"), USER("USER");
	
	private final String label;

	private Role(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
