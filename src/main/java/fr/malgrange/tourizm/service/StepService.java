package fr.malgrange.tourizm.service;

import java.util.List;

import fr.malgrange.tourizm.dto.StepDTO;

public interface StepService {

	/**
	 * Get all steps from the database
	 * @return list of Steps
	 */
	public List<StepDTO> findAllSteps();
}
