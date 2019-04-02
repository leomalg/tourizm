package fr.malgrange.tourizm.service.impl;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.repository.StepRepository;
import fr.malgrange.tourizm.repository.TourRepository;
import fr.malgrange.tourizm.service.StepService;
import fr.malgrange.tourizm.service.TourService;
import fr.malgrange.tourizm.service.dto.StepDTO;
import fr.malgrange.tourizm.service.dto.TourDTO;
import fr.malgrange.tourizm.service.mapper.StepMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StepServiceImpl implements StepService {

    private StepRepository stepRepository;
    private TourService tourService;
    private TourRepository tourRepository ;

    public StepServiceImpl(StepRepository stepRepository, TourService tourService, TourRepository tourRepository) {
        this.stepRepository = stepRepository;
        this.tourService = tourService;
        this.tourRepository = tourRepository;
    }

    public List<StepDTO> findAllStep() {
        final List<Step> steps = stepRepository.findAll();
        return StepMapper.MAPPER.toDto(steps);
    }

    @Override
    public List<StepDTO> getStepByTour(Integer tourId) {
        if (Objects.isNull(tourId)) {
            // TODO throw exception
        }
        return StepMapper.MAPPER.toDto(stepRepository.findAllByTour_Id(tourId));
    }

    @Override
    public Optional<StepDTO> getStepById(@NotNull Integer id) {
        return stepRepository.findById(id).map(StepMapper.MAPPER::toDto);
    }

    @Override
    public StepDTO createStep(@NotNull Integer tourId, @NotNull StepDTO stepDTO) {
        Optional<TourDTO> tourDTOOpt = tourService.getTourById(tourId);
        if (!tourDTOOpt.isPresent()) {
            // TODO throw exception
        }
        if (Objects.nonNull(stepDTO.getId())) {
            // TODO throw exception
        }
        stepDTO.setTourDTO(tourDTOOpt.get());
        Step step = StepMapper.MAPPER.toEntity(stepDTO);
        return StepMapper.MAPPER.toDto(stepRepository.save(step));
    }

    @Override
    public StepDTO updateStep(@NotNull StepDTO stepDTO) {
        if (Objects.isNull(stepDTO.getId())) {
            // TODO throw exception
        }

        return StepMapper.MAPPER.toDto(stepRepository.save(StepMapper.MAPPER.toEntity(stepDTO)));
    }

    @Override
    public void deleteStep(@NotNull Integer id) {
        stepRepository.deleteById(id);
    }
}
