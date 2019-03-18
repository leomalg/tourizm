package fr.malgrange.tourizm.service.dto;

import java.util.Objects;

public class StepDTO {

	private Integer id;
	private String name;
	private String description;
	private String latitude;
	private String longitude;
	private Integer order;
	private TourDTO tourDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public TourDTO getTourDTO() {
		return tourDTO;
	}

	public void setTourDTO(TourDTO tourDTO) {
		this.tourDTO = tourDTO;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StepDTO stepDTO = (StepDTO) o;
		return id.equals(stepDTO.id) &&
				name.equals(stepDTO.name) &&
				Objects.equals(description, stepDTO.description) &&
				latitude.equals(stepDTO.latitude) &&
				longitude.equals(stepDTO.longitude) &&
				order.equals(stepDTO.order) &&
				tourDTO.equals(stepDTO.tourDTO);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, latitude, longitude, order, tourDTO);
	}

	@Override
	public String toString() {
		return "StepDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", order=" + order +
				", tourDTO=" + tourDTO +
				'}';
	}
}
