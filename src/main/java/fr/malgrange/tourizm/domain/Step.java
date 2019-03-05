package fr.malgrange.tourizm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "STEP")
public class Step {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String latitude;
	private String longitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Step [id=" + id + ", name=" + name + ", description=" + description + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Step step = (Step) o;
		return id == step.id &&
				name.equals(step.name) &&
				Objects.equals(description, step.description) &&
				latitude.equals(step.latitude) &&
				longitude.equals(step.longitude);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, latitude, longitude);
	}
}
