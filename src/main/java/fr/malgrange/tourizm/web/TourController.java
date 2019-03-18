package fr.malgrange.tourizm.web;

import fr.malgrange.tourizm.service.TourService;
import fr.malgrange.tourizm.service.dto.TourDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("tours")
public class TourController {

	private TourService tourService;

	public TourController(TourService tourService) {
		this.tourService = tourService;
	}

	@GetMapping("")
	public ResponseEntity<List<TourDTO>> getAllTours() {
		final List<TourDTO> tourDTOS = tourService.findAllTour();
		return ok(tourDTOS);
	}

	@GetMapping("/{id}")
    public ResponseEntity<TourDTO> getTourById(@PathVariable Integer id) {
		Optional<TourDTO> tourDtoOpt = tourService.getTourById(id);
		return tourDtoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

	@PostMapping
	public ResponseEntity<TourDTO> createTour(@RequestBody TourDTO tourDto) {
		return ResponseEntity.ok(tourService.createTour(tourDto));
	}

	@PutMapping
	public ResponseEntity<TourDTO> updateTour(@RequestBody TourDTO tourDto) {
		return ResponseEntity.ok(tourService.updateTour(tourDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteTour(@PathVariable Integer id) {
		tourService.deleteTour(id);
		return ResponseEntity.ok().build();
	}
}
