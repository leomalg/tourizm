package fr.malgrange.tourizm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.malgrange.tourizm.domain.Step;

public interface StepRepository extends JpaRepository<Step, Integer> {
	
}
