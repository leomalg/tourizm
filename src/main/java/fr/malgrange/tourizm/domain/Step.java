package fr.malgrange.tourizm.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STEP")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String latitude;
    @Column(nullable = false)
    private String longitude;
    private int order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", referencedColumnName = "id", nullable = false)
    private Tour tour;

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

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return id == step.id &&
                order == step.order &&
                name.equals(step.name) &&
                Objects.equals(description, step.description) &&
                latitude.equals(step.latitude) &&
                longitude.equals(step.longitude)/* &&
                tour.equals(step.tour)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, latitude, longitude,/* tour, */order);
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                /*", tour=" + tour +*/
                ", order=" + order +
                '}';
    }
}
