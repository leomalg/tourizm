package fr.malgrange.tourizm.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.repository.StepRepository;

@RestController
public class StepController {

	private StepRepository stepRepository;

	public StepController(StepRepository stepRepository) {
		this.stepRepository = stepRepository;
	}

	@RequestMapping("steps")
	public ResponseEntity<List<Step>> index() {
		final List<Step> steps = stepRepository.findAll();
		return ResponseEntity.ok(steps);
	}
}
