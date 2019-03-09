package fr.malgrange.tourizm.service.mapper;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.domain.Tour;
import fr.malgrange.tourizm.service.dto.StepDTO;
import fr.malgrange.tourizm.service.dto.TourDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TourMapper extends EntityMapper<TourDTO, Tour>  {

	TourMapper MAPPER = Mappers.getMapper(TourMapper.class);
}
