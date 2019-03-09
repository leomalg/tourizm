package fr.malgrange.tourizm.service;

import fr.malgrange.tourizm.service.dto.TourDTO;

import java.util.List;
import java.util.Optional;

public interface TourService {

    List<TourDTO> findAllTour();

    Optional<TourDTO> getTourById(Integer id);

    TourDTO createTour(TourDTO tourDTO);

    TourDTO updateTour(TourDTO tourDTO);

    void deleteTour(Integer id);
}
