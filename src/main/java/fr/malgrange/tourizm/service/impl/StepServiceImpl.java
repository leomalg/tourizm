package fr.malgrange.tourizm.service.impl;

import com.google.common.base.Strings;
import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.domain.Tour;
import fr.malgrange.tourizm.repository.StepRepository;
import fr.malgrange.tourizm.repository.TourRepository;
import fr.malgrange.tourizm.service.StepService;
import fr.malgrange.tourizm.service.dto.StepDTO;
import fr.malgrange.tourizm.service.exception.BadRequestException;
import fr.malgrange.tourizm.service.exception.NotFoundException;
import fr.malgrange.tourizm.service.mapper.StepMapper;
import fr.malgrange.tourizm.service.mapper.TourMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;

@Service
public class StepServiceImpl implements StepService {

    private StepRepository stepRepository;
    private TourRepository tourRepository ;

    public StepServiceImpl(StepRepository stepRepository, TourRepository tourRepository) {
        this.stepRepository = stepRepository;
        this.tourRepository = tourRepository;
    }

    public List<StepDTO> findAllStep() {
        final List<Step> steps = stepRepository.findAll();
        return StepMapper.MAPPER.toDto(steps);
    }

    @Override
    public List<StepDTO> getStepByTour(Integer tourId) {
        if (Objects.isNull(tourId)) {
            throw new BadRequestException("Impossible de trouver les étapes d'un circuit sans identifiant.");
        }
        return StepMapper.MAPPER.toDto(stepRepository.findAllByTour_Id(tourId));
    }

    @Override
    public Optional<StepDTO> getStepById(Integer id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException("Impossible de trouver une étape sans identifiant.");
        }
        return stepRepository.findById(id).map(StepMapper.MAPPER::toDto);
    }

    @Override
    public StepDTO createStep( Integer tourId, StepDTO stepDTO) {
        if (Objects.isNull(stepDTO)) {
            throw new BadRequestException("Impossible de créer une étape vide.");
        }
        if (Objects.nonNull(stepDTO.getId())) {
            throw new BadRequestException("Une étape possédant déjà un identifiant ne peut pas être créée.");
        }
        checkRequiredFields(stepDTO);
        final Optional<Tour> tourOpt = tourRepository.findById(tourId);
        if (!tourOpt.isPresent()) {
            throw new BadRequestException("Le circuit rattaché à l 'étape n'existe pas.");
        }
        stepDTO.setTourDTO(TourMapper.MAPPER.toDto(tourOpt.get()));
        checkRequiredFields(stepDTO);
        final Step step = StepMapper.MAPPER.toEntity(stepDTO);
        return StepMapper.MAPPER.toDto(stepRepository.save(step));
    }

    @Override
    public StepDTO updateStep(@NotNull StepDTO stepDTO) {
        if (Objects.isNull(stepDTO.getId())) {
            throw new BadRequestException("Une étape ne possédant pas d'identifiant ne peut pas être mise à jour.");
        }
        checkExists(stepDTO.getId());
        checkRequiredFields(stepDTO);
        checkUniqueFields(stepDTO);
        return StepMapper.MAPPER.toDto(stepRepository.save(StepMapper.MAPPER.toEntity(stepDTO)));
    }

    @Override
    public void deleteStep(Integer id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException("Une étape ne possédant pas d'identifiant ne peut pas être supprimée.");
        }
        checkExists(id);
        stepRepository.deleteById(id);
    }

    /**
     * Check if required fields of a step are not empty
     *
     * @param stepDTO the DTO to check
     * @throws BadRequestException if some required fields are empty
     */
    private void checkRequiredFields(StepDTO stepDTO) {
        final List<String> errors = new ArrayList<>();
        if (Strings.isNullOrEmpty(stepDTO.getName())) {
            errors.add("Le nom de l'étape est obligatoire.");
        }
        if (Objects.isNull(stepDTO.getLatitude())) {
            errors.add("La latitude de l'étape est obligatoire.");
        }
        if (Objects.isNull(stepDTO.getLongitude())) {
            errors.add("La longitude de l'étape est obligatoire.");
        }
        if (Objects.isNull(stepDTO.getOrder())) {
            errors.add("L'ordre de l'étape est obligatoire.");
        }
        if (Objects.isNull(stepDTO.getTourDTO()) || Objects.isNull(stepDTO.getTourDTO().getId())) {
            errors.add("Une étape doit être rattachée à un circuit.");
        }
        if (!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }

    /**
     * Check if unique fields of a step are really unique
     *
     * @param stepDTO the tour to check
     * @throws BadRequestException if some fields already axists
     */
    private void checkUniqueFields(StepDTO stepDTO) {
        final List<String> errors = new ArrayList<>();
        if ((Objects.nonNull(stepDTO.getId()) && stepRepository.existsByNameIgnoreCaseAndTour_Id(stepDTO.getName(), stepDTO.getTourDTO().getId())) ||
                Objects.isNull(stepDTO.getId()) && stepRepository.existsByNameIgnoreCaseAndIdNotInAndTour_Id(stepDTO.getName(), Collections.singletonList(stepDTO.getId()), stepDTO.getTourDTO().getId())) {
            errors.add("Une étape existe déjà dans ce circuit avec ce nom.");
        }
        if (stepRepository.existsByStepOrderAndTour_Id(stepDTO.getOrder(), stepDTO.getTourDTO().getId())) {
            errors.add("Une étape existe déjà dans ce circuit avec cet ordre.");
        }
        if (!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }

    /**
     * Check if a step exists
     *
     * @param id id of the step to check
     * @throws NotFoundException if the step doesn't exists
     */
    private void checkExists(Integer id) {
        if (!stepRepository.existsById(id)) {
            throw new NotFoundException("L'étape est introuvable.");
        }
    }
}
