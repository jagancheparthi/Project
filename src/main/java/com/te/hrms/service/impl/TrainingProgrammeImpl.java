package com.te.hrms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.te.hrms.dto.TrainingProgrammeDTO;
import com.te.hrms.entity.TrainingProgramme;
import com.te.hrms.exception.ProgrammeNotFoundException;
import com.te.hrms.repository.TrainingProgrammeRepository;
import com.te.hrms.service.TrainingProgrammeService;
import com.te.hrms.utils.TrainingProUtils;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class TrainingProgrammeImpl implements TrainingProgrammeService{
	private final TrainingProgrammeRepository trainingProgrammeRepository;
	private final TrainingProUtils trainingProUtils;
	@Override
	public TrainingProgrammeDTO saveTrainingProgramme(TrainingProgrammeDTO trainingProgrammeDTO) {
		TrainingProgramme trainingProgramme = trainingProgrammeRepository.save(trainingProUtils.dtoToTraining(trainingProgrammeDTO));
		return trainingProUtils.entityToTrainingDTO(trainingProgramme);
	}
	@Override
	public TrainingProgrammeDTO getProgramme(int programmeId) throws ProgrammeNotFoundException {
		TrainingProgramme tProgramme = trainingProgrammeRepository.findById(programmeId).orElseThrow(()->new ProgrammeNotFoundException("NO PROGRAMME FOUND"));
		
		return trainingProUtils.entityToTrainingDTO(tProgramme);
	}
	@Override
	public List<TrainingProgrammeDTO> getProgrammes() {
		List<TrainingProgramme> pros = trainingProgrammeRepository.findAll();
		return pros.stream().map(p->trainingProUtils.entityToTrainingDTO(p)).collect(Collectors.toList());
	}

}
