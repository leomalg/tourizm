package fr.malgrange.tourizm.web;

import fr.malgrange.tourizm.service.StepService;
import fr.malgrange.tourizm.service.dto.StepDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class StepController {

	private StepService stepService;

	public StepController(StepService stepService) {
		this.stepService = stepService;
	}

	@GetMapping("")
	public ResponseEntity<List<StepDTO>> getAllSteps() {
		final List<StepDTO> stepDtos = stepService.findAllStep();
		return ResponseEntity.ok(stepDtos);
	}

    @GetMapping("/{id}")
    public ResponseEntity<StepDTO> getStepById(@PathVariable Integer id) {
        Optional<StepDTO> stepDtoOpt = stepService.getStepById(id);
        return stepDtoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StepDTO> createStep(@RequestBody StepDTO stepDto) {
        if (Objects.isNull(stepDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stepService.createStep(stepDto));
    }

    @PutMapping
    public ResponseEntity<StepDTO> updateStep(@RequestBody StepDTO stepDto) {
        if (Objects.nonNull(stepDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stepService.updateStep(stepDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStep(@PathVariable Integer id) {
        stepService.deleteStep(id);
        return ResponseEntity.ok().build();
    }
}
