package fr.malgrange.tourizm.service;

import fr.malgrange.tourizm.service.dto.StepDTO;

import java.util.List;
import java.util.Optional;

public interface StepService {

	/**
	 * Get all steps from the database
	 * @return list of StepDtos
	 */
	List<StepDTO> findAllStep();

	List<StepDTO> getStepByTour(Integer tourId);

	/**
	 * Get a StepDTO given its id
	 * @param id id of the step
	 * @return
	 */
	Optional<StepDTO> getStepById(Integer id);

	/**
	 *
	 * @param routId
	 * @param stepDTO
	 * @return
	 */
	StepDTO createStep(Integer routId, StepDTO stepDTO);

	StepDTO updateStep(StepDTO stepDTO);

	void deleteStep(Integer id);
}
