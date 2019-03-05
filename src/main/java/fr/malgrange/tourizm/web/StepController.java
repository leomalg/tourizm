package fr.malgrange.tourizm.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.malgrange.tourizm.service.dto.StepDTO;
import fr.malgrange.tourizm.service.StepService;

@RestController
@RequestMapping("step")
public class StepController {

	private StepService stepService;

	public StepController(StepService stepService) {
		this.stepService = stepService;
	}

	@RequestMapping("")
	public ResponseEntity<List<StepDTO>> getAllSteps() {
		final List<StepDTO> stepDtos = stepService.findAllSteps();
		return ResponseEntity.ok(stepDtos);
	}
}
