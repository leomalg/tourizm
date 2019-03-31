package fr.malgrange.tourizm.web;

import fr.malgrange.tourizm.service.StepService;
import fr.malgrange.tourizm.service.dto.StepDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("")
public class StepController {

	private StepService stepService;

	public StepController(StepService stepService) {
		this.stepService = stepService;
	}

	@GetMapping("steps")
	public ResponseEntity<List<StepDTO>> getAllSteps() {
		final List<StepDTO> stepDtos = stepService.findAllStep();
		return ResponseEntity.ok(stepDtos);
	}

    @GetMapping("steps/{id}")
    public ResponseEntity<StepDTO> getStepById(@PathVariable Integer id) {
        final Optional<StepDTO> stepDtoOpt = stepService.getStepById(id);
        return stepDtoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("tours/{tourId}/steps")
    public ResponseEntity<List<StepDTO>> getStepByTour(@PathVariable Integer tourId) {
        final List<StepDTO> stepDTOList = stepService.getStepByTour(tourId);
        return ResponseEntity.ok(stepDTOList);
    }

    @PostMapping("tours/{tourId}/steps")
    public ResponseEntity<StepDTO> createStep(@PathVariable Integer tourId, @RequestBody StepDTO stepDto) {
        return ResponseEntity.ok(stepService.createStep(tourId, stepDto));
    }

    @PutMapping("tours/{tourId}/steps")
    public ResponseEntity<StepDTO> updateStep(@PathVariable Integer tourId, @RequestBody StepDTO stepDto) {
        return ResponseEntity.ok(stepService.updateStep(stepDto));
    }

    @DeleteMapping("tours/{tourId}/steps")
    public ResponseEntity deleteStep(@PathVariable Integer tourId, @PathVariable Integer id) {
        stepService.deleteStep(id);
        return ResponseEntity.ok().build();
    }
}
