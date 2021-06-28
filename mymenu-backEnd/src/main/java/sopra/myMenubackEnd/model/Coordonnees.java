package sopra.myMenubackEnd.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;
@Embeddable
public class Coordonnees {
	@Column(name="longitude", length = 255)
	@JsonView(Views.ViewCommon.class)
	private Double longitude;
	@Column(name="latitude", length = 255)
	@JsonView(Views.ViewCommon.class)
	private Double latitude;
	
	public Coordonnees() {
		super();
	}

	public Coordonnees(Double longitude, Double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
}
