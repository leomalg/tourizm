package fr.malgrange.tourizm.service.mapper;

import fr.malgrange.tourizm.domain.Tour;
import fr.malgrange.tourizm.service.dto.TourDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = StepMapper.class)
public interface TourMapper extends EntityMapper<TourDTO, Tour> {

    TourMapper MAPPER = Mappers.getMapper(TourMapper.class);

    @Mapping(target = "steps", source = "steps")
    TourDTO toDto(Tour entity);

    @Mapping(target = "steps", source = "steps")
    Tour toEntity(TourDTO dto);
}
