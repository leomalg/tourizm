package fr.malgrange.tourizm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.malgrange.tourizm.domain.Step;
import fr.malgrange.tourizm.dto.StepDTO;

@Mapper
public interface StepMapper {

	StepMapper INSTANCE = Mappers.getMapper(StepMapper.class);
	
	StepDTO toDto(Step step);
	
	Step toEntity(StepDTO dto);
}
