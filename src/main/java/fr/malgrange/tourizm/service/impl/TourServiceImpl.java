package fr.malgrange.tourizm.service.impl;

import com.google.common.base.Strings;
import fr.malgrange.tourizm.domain.Tour;
import fr.malgrange.tourizm.repository.TourRepository;
import fr.malgrange.tourizm.service.TourService;
import fr.malgrange.tourizm.service.dto.TourDTO;
import fr.malgrange.tourizm.service.exception.BadRequestException;
import fr.malgrange.tourizm.service.exception.NotFoundException;
import fr.malgrange.tourizm.service.mapper.TourMapper;
import org.springframework.stereotype.Service;

import java.util.*;

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
        if (Objects.isNull(id)) {
            throw new BadRequestException("Impossible de trouver un circuit sans identifiant.");
        }
        return tourRepository.findById(id).map(TourMapper.MAPPER::toDto);
    }

    @Override
    public TourDTO createTour(TourDTO tourDTO) {
        if (Objects.nonNull(tourDTO.getId())) {
            throw new BadRequestException("Un circuit possédant déjà un identifiant ne peut pas être créé.");
        }
        checkRequiredFields(tourDTO);
        checkUniqueFields(tourDTO);
        final Tour tour = tourRepository.save(TourMapper.MAPPER.toEntity(tourDTO));
        return TourMapper.MAPPER.toDto(tour);
    }

    @Override
    public TourDTO updateTour(TourDTO tourDTO) {
        if (Objects.isNull(tourDTO.getId())) {
            throw new BadRequestException("Un circuit ne possédant pas d'identifiant ne peut pas être mis à jour.");
        }
        checkExists(tourDTO.getId());
        checkRequiredFields(tourDTO);
        checkUniqueFields(tourDTO);
        final Tour tour = tourRepository.save(TourMapper.MAPPER.toEntity(tourDTO));
        return TourMapper.MAPPER.toDto(tour);
    }

    @Override
    public void deleteTour(Integer id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException("Un circuit ne possédant pas d'identifiant ne peut pas être supprimé.");
        }
        checkExists(id);
        tourRepository.deleteById(id);
    }

    /**
     * Check if required fields of a tour are not empty
     *
     * @param tourDTO the DTO to check
     * @throws BadRequestException if some required fields are empty
     */
    private void checkRequiredFields(TourDTO tourDTO) {
        final List<String> errors = new ArrayList<>();
        if (Strings.isNullOrEmpty(tourDTO.getName())) {
            errors.add("Le nom du circuit est obligatoire.");
        }
        if (Objects.isNull(tourDTO.getDuration())) {
            errors.add("La durée du circuit est obligatoire.");
        }
        if (!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }

    /**
     * Check if unique fields of a tour are really unique
     *
     * @param tourDTO the tour to check
     * @throws BadRequestException if some fields already axists
     */
    private void checkUniqueFields(TourDTO tourDTO) {
        final List<String> errors = new ArrayList<>();
        if ((Objects.nonNull(tourDTO.getId()) && tourRepository.existsByNameIgnoreCase(tourDTO.getName())) ||
                Objects.isNull(tourDTO.getId()) && tourRepository.existsByNameIgnoreCaseAndIdNotIn(tourDTO.getName(), Collections.singletonList(tourDTO.getId()))) {
            errors.add("Un circuit existe déjà avec ce nom.");
        }
        if (!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }

    /**
     * Check if a tour exists
     *
     * @param id id of the tour to check
     * @throws NotFoundException if the tour doesn't exists
     */
    private void checkExists(Integer id) {
        if (!tourRepository.existsById(id)) {
            throw new NotFoundException("Le circuit est introuvable.");
        }
    }
}
