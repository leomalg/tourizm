package fr.malgrange.tourizm.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.service.dto.StepDTO;

@Mapper
public interface StepMapper extends EntityMapper<StepDTO, Step>  {

	StepMapper MAPPER = Mappers.getMapper(StepMapper.class);
}
