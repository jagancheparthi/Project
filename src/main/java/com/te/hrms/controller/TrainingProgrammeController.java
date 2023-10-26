package com.te.hrms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.hrms.dto.TrainingProgrammeDTO;
import com.te.hrms.exception.ProgrammeNotFoundException;
import com.te.hrms.response.SuccessResponse;
import com.te.hrms.service.TrainingProgrammeService;

import lombok.RequiredArgsConstructor;
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@RestController
public class TrainingProgrammeController {
	private final TrainingProgrammeService trainingProgrammeService;
	@PostMapping(path = "/programs")
	public ResponseEntity<SuccessResponse> saveTrainingPro(@RequestBody TrainingProgrammeDTO trainingProgrammeDTO) {
		TrainingProgrammeDTO trainingProgramme=trainingProgrammeService.saveTrainingProgramme(trainingProgrammeDTO);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().code(HttpStatus.OK).data(trainingProgramme.getProgrammeName()).message("SUCCESS").build(), HttpStatus.OK);

	}
	@GetMapping(path = "/programs/{id}")
	public ResponseEntity<SuccessResponse> getProgramme(@PathVariable("id") int programmeId) throws ProgrammeNotFoundException {
		TrainingProgrammeDTO programme=trainingProgrammeService.getProgramme(programmeId);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().code(HttpStatus.FOUND).data(programme).message("SUCCESS").build(), HttpStatus.FOUND);
	}
	@GetMapping(path = "programs")
	public ResponseEntity<SuccessResponse> getProgrammes() {
		List<TrainingProgrammeDTO> programmes=trainingProgrammeService.getProgrammes();
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().code(HttpStatus.FOUND).data(programmes).message("SUCCESS").build(), HttpStatus.FOUND);
	}
}
