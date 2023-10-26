package com.te.hrms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.hrms.constants.SkillConstants;
import com.te.hrms.dto.SkillDTO;
import com.te.hrms.exception.SkillNotFoundException;
import com.te.hrms.response.SuccessResponse;
import com.te.hrms.service.SkillService;

import lombok.RequiredArgsConstructor;
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@RestController
public class SkillController {
	private final SkillService skillService;
	private final SkillConstants skillCons;
	@GetMapping(path = "/skills/{id}")
	public ResponseEntity<SuccessResponse> getSkill(int skillId) throws SkillNotFoundException {
		SkillDTO skill=skillService.getSkill(skillId);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().code(HttpStatus.FOUND).data(skill).build(), HttpStatus.FOUND);
	}
	@GetMapping(path = "/skills")
	public ResponseEntity<SuccessResponse> getSkills() {
		List<SkillDTO> skills=skillService.getSkills();
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().code(HttpStatus.FOUND).data(skills).build(), HttpStatus.FOUND);
	}
	@PutMapping(path = "/skills/{id}")
	public ResponseEntity<SuccessResponse> updateSkill(@PathVariable("id") int skillId,@RequestBody SkillDTO skillDTO) throws SkillNotFoundException {
		boolean result=skillService.updateSkill(skillId,skillDTO);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().code(HttpStatus.OK).message(skillCons.MSG).data(result).build(), HttpStatus.OK);
	}
	@DeleteMapping(path = "/skills/{id}")
	public ResponseEntity<SuccessResponse> deleteSkill(@PathVariable("id") int skillId) throws SkillNotFoundException {
		boolean result=skillService.deleteSkill(skillId);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().code(HttpStatus.NO_CONTENT).message(skillCons.MSG).data(result).build(), HttpStatus.NO_CONTENT);
	}
}
