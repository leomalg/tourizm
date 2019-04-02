package fr.malgrange.tourizm.service.mapper;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.domain.Tour;
import fr.malgrange.tourizm.service.dto.TourDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Objects;
import java.util.Set;

@Mapper(uses = StepMapper.class)
public interface TourMapper extends EntityMapper<TourDTO, Tour> {

    TourMapper MAPPER = Mappers.getMapper(TourMapper.class);

    @Mapping(target = "stepDTOs", source = "steps")
    @Mapping(target = "stepCount", source = "steps", qualifiedByName = "getStepCount")
    TourDTO toDto(Tour entity);

    @Mapping(target = "steps", source = "stepDTOs")
    Tour toEntity(TourDTO dto);

    @Named("getStepCount")
    default Integer getStepCount(Set<Step> steps) {
        return (Objects.isNull(steps) ? 0 : steps.size());
    }
}
