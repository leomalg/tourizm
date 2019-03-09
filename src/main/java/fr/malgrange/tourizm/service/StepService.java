package fr.malgrange.tourizm.service;

import java.util.List;
import java.util.Optional;

import fr.malgrange.tourizm.service.dto.StepDTO;

public interface StepService {

	/**
	 * Get all steps from the database
	 * @return list of StepDtos
	 */
	List<StepDTO> findAllSteps();

	List<StepDTO> getStepByTour(Integer tourId);

	/**
	 * Get a StepDTO given its id
	 * @param id id of the step
	 * @return
	 */
	Optional<StepDTO> getStepById(Integer id);

	/**
	 *
	 * @param stepDTO
	 * @return
	 */
	StepDTO createStep(StepDTO stepDTO);

	StepDTO updateStep(StepDTO stepDTO);

	void deleteStep(Integer id);
}
