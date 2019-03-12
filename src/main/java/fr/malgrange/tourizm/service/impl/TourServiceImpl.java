package fr.malgrange.tourizm.service.impl;

import com.google.common.base.Strings;
import fr.malgrange.tourizm.domain.Tour;
import fr.malgrange.tourizm.repository.TourRepository;
import fr.malgrange.tourizm.service.TourService;
import fr.malgrange.tourizm.service.dto.TourDTO;
import fr.malgrange.tourizm.service.mapper.TourMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<TourDTO> findAllTour() {
        List<Tour> tours = tourRepository.findAll();
        return TourMapper.MAPPER.toDto(tours);
    }

    @Override
    public Optional<TourDTO> getTourById(Integer id) {
        return tourRepository.findById(id).map(TourMapper.MAPPER::toDto);
    }

    @Override
    public TourDTO createTour(TourDTO tourDTO) {
        if (Objects.nonNull(tourDTO.getId())) {
            // TODO throw exception
        }
        checkTour(tourDTO);
        final Tour tour = tourRepository.save(TourMapper.MAPPER.toEntity(tourDTO));
        return TourMapper.MAPPER.toDto(tour);
    }

    @Override
    public TourDTO updateTour(TourDTO tourDTO) {
        if (Objects.isNull(tourDTO.getId())) {
            // TODO throw exception
        }
        checkTour(tourDTO);
        final Tour tour = tourRepository.save(TourMapper.MAPPER.toEntity(tourDTO));
        return TourMapper.MAPPER.toDto(tour);
    }

    @Override
    public void deleteTour(Integer id) {
        if (Objects.isNull(id)) {
            // TODO throw exception
        }
        tourRepository.deleteById(id);
    }

    /**
     * Check if a tour is valid
     * Throw an exception if the tour is not valid
     * @param tourDTO the DTO to check
     */
    private void checkTour(TourDTO tourDTO) {
        if (Strings.isNullOrEmpty(tourDTO.getName()) || Objects.isNull(tourDTO.getDuration())) {
            // TODO throw exception
        }
    }
}
