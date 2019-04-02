package fr.malgrange.tourizm.service.mapper;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.service.dto.StepDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper/*(uses = TourMapper.class)*/
public interface StepMapper extends EntityMapper<StepDTO, Step> {

    StepMapper MAPPER = Mappers.getMapper(StepMapper.class);

//    @Mapping(target = "tourDTO", source = "tour")
    @Mapping(target = "order", source = "stepOrder")
    StepDTO toDto(Step entity);

    @Mapping(target = "stepOrder", source = "order")
    @Mapping(target = "tour.id", source = "tourDTO.id")
    Step toEntity(StepDTO dto);
}
