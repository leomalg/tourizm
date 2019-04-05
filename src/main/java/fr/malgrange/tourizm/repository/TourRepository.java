package fr.malgrange.tourizm.repository;

import fr.malgrange.tourizm.domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {
    boolean existsById(Integer id);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNotIn(String name, List<Integer> idList);
}
