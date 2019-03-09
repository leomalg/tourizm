package fr.malgrange.tourizm.web;

import fr.malgrange.tourizm.service.TourService;
import fr.malgrange.tourizm.service.dto.StepDTO;
import fr.malgrange.tourizm.service.dto.TourDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tours")
public class TourController {

//	private TourService tourService;

//	public TourController(TourService tourService) {
//		this.tourService = tourService;
//	}

//	@GetMapping("")
//	public ResponseEntity<List<TourDTO>> getAllTours() {
//		final List<TourDTO> tourDTOS = tourService.findAllTour();
//		return ResponseEntity.ok(tourDTOS);
//	}
}
