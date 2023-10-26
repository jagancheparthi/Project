package com.te.hrms.service;

import java.util.List;

import com.te.hrms.dto.SkillDTO;
import com.te.hrms.exception.SkillNotFoundException;

public interface SkillService {

	SkillDTO getSkill(int skillId) throws SkillNotFoundException;

	List<SkillDTO> getSkills();

	boolean updateSkill(int skillId, SkillDTO skillDTO) throws SkillNotFoundException;

	boolean deleteSkill(int skillId) throws SkillNotFoundException;

}
