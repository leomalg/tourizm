package fr.malgrange.tourizm.service.dto;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

public class TourDTO {

    private Integer id;
    private String name;
    private String description;
    private LocalTime duration;
    private Set<StepDTO> stepDTOs;
    private Integer stepCount;

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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public Integer getStepCount() {
        return stepCount;
    }

    public void setStepCount(Integer stepCount) {
        this.stepCount = stepCount;
    }

    public Set<StepDTO> getStepDTOs() {
        return stepDTOs;
    }

    public void setStepDTOs(Set<StepDTO> stepDTOs) {
        this.stepDTOs = stepDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourDTO tourDTO = (TourDTO) o;
        return id.equals(tourDTO.id) &&
                name.equals(tourDTO.name) &&
                Objects.equals(description, tourDTO.description) &&
                duration.equals(tourDTO.duration) &&
                Objects.equals(stepDTOs, tourDTO.stepDTOs) &&
                Objects.equals(stepCount, tourDTO.stepCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, duration, stepDTOs, stepCount);
    }

    @Override
    public String toString() {
        return "TourDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", stepDTOs=" + stepDTOs +
                ", stepCount=" + stepCount +
                '}';
    }
}
