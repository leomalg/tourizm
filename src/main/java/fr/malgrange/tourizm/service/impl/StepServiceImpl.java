package fr.malgrange.tourizm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.dto.StepDTO;
import fr.malgrange.tourizm.mapper.StepMapper;
import fr.malgrange.tourizm.repository.StepRepository;
import fr.malgrange.tourizm.service.StepService;

@Service
public class StepServiceImpl implements StepService {

	private StepRepository stepRepository;
	
	public StepServiceImpl(StepRepository stepRepository) {
		this.stepRepository = stepRepository;
	}

	public List<StepDTO> findAllSteps() {
		final List<Step> steps = stepRepository.findAll();
		final List<StepDTO> stepDtos = steps.stream().map(step -> StepMapper.INSTANCE.toDto(step)).collect(Collectors.toList());
		return stepDtos;
	}
}
