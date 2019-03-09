package fr.malgrange.tourizm.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.service.dto.StepDTO;
import fr.malgrange.tourizm.service.mapper.StepMapper;
import fr.malgrange.tourizm.repository.StepRepository;
import fr.malgrange.tourizm.service.StepService;

import javax.validation.constraints.NotNull;

@Service
public class StepServiceImpl implements StepService {

    private StepRepository stepRepository;

    public StepServiceImpl(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public List<StepDTO> findAllSteps() {
        final List<Step> steps = stepRepository.findAll();
        return StepMapper.MAPPER.toDto(steps);
    }

    @Override
    public List<StepDTO> getStepByTour(Integer tourId) {
        return null;
    }

    @Override
    public Optional<StepDTO> getStepById(@NotNull Integer id) {
        return stepRepository.findById(id).map(StepMapper.MAPPER::toDto);
    }

    @Override
    public StepDTO createStep(@NotNull StepDTO stepDTO) {
        return StepMapper.MAPPER.toDto(stepRepository.save(StepMapper.MAPPER.toEntity(stepDTO)));
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
