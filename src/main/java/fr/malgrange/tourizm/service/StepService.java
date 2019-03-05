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

	/**
	 * Get a StepDTO given its id
	 * @param id id of the step
	 * @return
	 */
	Optional<StepDTO> getById(Integer id);

	/**
	 *
	 * @param stepDTO
	 * @return
	 */
	StepDTO addOrUpdate(StepDTO stepDTO);
}
