package com.te.hrms.service;

import java.util.List;

import com.te.hrms.dto.TrainingProgrammeDTO;
import com.te.hrms.exception.ProgrammeNotFoundException;

public interface TrainingProgrammeService {

	TrainingProgrammeDTO saveTrainingProgramme(TrainingProgrammeDTO trainingProgrammeDTO);

	TrainingProgrammeDTO getProgramme(int programmeId) throws ProgrammeNotFoundException;

	List<TrainingProgrammeDTO> getProgrammes();

}
