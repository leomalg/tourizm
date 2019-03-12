package fr.malgrange.tourizm.domain;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TOUR")
public class Tour {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private LocalTime duration;
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Step> steps;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Collection<Step> getSteps() {
        return steps;
    }

    public void setSteps(Collection<Step> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return id == tour.id &&
                name.equals(tour.name) &&
                Objects.equals(description, tour.description) &&
                Objects.equals(duration, tour.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, duration);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }
}
