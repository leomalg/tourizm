package fr.malgrange.tourizm.service.mapper;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.service.dto.StepDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TourMapper.class)
public interface StepMapper extends EntityMapper<StepDTO, Step> {

    StepMapper MAPPER = Mappers.getMapper(StepMapper.class);

//    @Mapping(target = "tourDTO", source = "tour")
    StepDTO toDto(Step entity);

//    @Mapping(target = "tour", source = "tourDTO")
    Step toEntity(StepDTO dto);
}
