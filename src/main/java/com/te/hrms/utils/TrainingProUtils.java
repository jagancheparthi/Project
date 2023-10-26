package com.te.hrms.utils;

import org.springframework.stereotype.Component;

import com.te.hrms.dto.TrainingProgrammeDTO;
import com.te.hrms.entity.TrainingProgramme;

@Component
public class TrainingProUtils {
	public TrainingProgramme dtoToTraining(TrainingProgrammeDTO trainingProgrammeDTO) {
		return TrainingProgramme.builder()
				.description(trainingProgrammeDTO.getDescription())
				.endDate(trainingProgrammeDTO.getEndDate())
				.programmeName(trainingProgrammeDTO.getProgrammeName())
				.build();
	}
	public TrainingProgrammeDTO entityToTrainingDTO(TrainingProgramme trainingProgramme) {
		return TrainingProgrammeDTO.builder()
				.description(trainingProgramme.getDescription())
				.endDate(trainingProgramme.getEndDate())
				.programmeName(trainingProgramme.getProgrammeName())
				.build();
	}
}
