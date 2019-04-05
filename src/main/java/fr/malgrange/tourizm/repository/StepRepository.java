package fr.malgrange.tourizm.repository;

import fr.malgrange.tourizm.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Integer> {
	List<Step> findAllByTour_Id(Integer tourId);

    boolean existsByNameIgnoreCaseAndTour_Id(String name, Integer tourId);

    boolean existsByNameIgnoreCaseAndIdNotInAndTour_Id(String name, List<Integer> idList, Integer tourId);

    boolean existsByStepOrderAndTour_Id(Integer order, Integer tourId);
}
