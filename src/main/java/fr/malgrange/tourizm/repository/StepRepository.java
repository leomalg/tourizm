package fr.malgrange.tourizm.repository;

import fr.malgrange.tourizm.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Integer> {
	List<Step> findAllByTour_Id(Integer tourId);
}
