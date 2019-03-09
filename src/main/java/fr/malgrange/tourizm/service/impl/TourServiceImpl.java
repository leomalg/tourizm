package fr.malgrange.tourizm.service.impl;

import fr.malgrange.tourizm.service.TourService;
import fr.malgrange.tourizm.service.dto.TourDTO;

import java.util.List;
import java.util.Optional;

public class TourServiceImpl implements TourService {

    @Override
    public List<TourDTO> findAllTour() {
        return null;
    }

    @Override
    public Optional<TourDTO> getTourById(Integer id) {
        return Optional.empty();
    }

    @Override
    public TourDTO createTour(TourDTO tourDTO) {
        return null;
    }

    @Override
    public TourDTO updateTour(TourDTO tourDTO) {
        return null;
    }

    @Override
    public void deleteTour(Integer id) {

    }
}
