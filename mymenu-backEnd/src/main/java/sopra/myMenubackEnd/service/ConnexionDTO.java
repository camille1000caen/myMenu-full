package sopra.myMenubackEnd.service;

public class ConnexionDTO {
	private String email;
	private String username;
	private String password;
	
	public ConnexionDTO(String email, String pseudo, String password) {
		super();
		this.email = email;
		this.username = pseudo;
		this.password = password;
	}
	

	public ConnexionDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
