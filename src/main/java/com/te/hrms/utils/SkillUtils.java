package com.te.hrms.utils;

import org.springframework.stereotype.Component;

import com.te.hrms.dto.SkillDTO;
import com.te.hrms.entity.Skill;

@Component
public class SkillUtils {
	public Skill dtoToSkill(SkillDTO skill) {
		return Skill.builder()
					.description(skill.getDescription())
					.skillName(skill.getSkillName())
					.build();
	}
	public SkillDTO skillToDto(Skill skill) {
		return SkillDTO.builder()
				.description(skill.getDescription())
				.skillName(skill.getSkillName())
				.build();
	}
}
