package fr.malgrange.tourizm.repository;

import fr.malgrange.tourizm.domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}
