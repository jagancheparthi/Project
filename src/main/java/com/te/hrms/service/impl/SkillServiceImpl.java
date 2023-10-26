package com.te.hrms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.te.hrms.dto.SkillDTO;
import com.te.hrms.entity.Skill;
import com.te.hrms.exception.SkillNotFoundException;
import com.te.hrms.repository.SkillRepository;
import com.te.hrms.service.SkillService;
import com.te.hrms.utils.SkillUtils;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class SkillServiceImpl implements SkillService{
	private final SkillRepository skillRepository;
	private final SkillUtils skillUtils;
	@Override
	public SkillDTO getSkill(int skillId) throws SkillNotFoundException {
		Skill skill = skillRepository.findById(skillId).orElseThrow(()->new SkillNotFoundException("SKILL NOT FOUND"));
		return skillUtils.skillToDto(skill);
	}
	@Override
	public List<SkillDTO> getSkills() {
		List<Skill> skills = skillRepository.findAll();
		return skills.stream().map(s->skillUtils.skillToDto(s)).collect(Collectors.toList());
	}
	@Override
	public boolean updateSkill(int skillId, SkillDTO skillDTO) throws SkillNotFoundException {
		Skill skill = skillRepository.findById(skillId).orElseThrow(()->new SkillNotFoundException("SKILL NOT FOUND"));
		skill.setDescription(skillDTO.getDescription());
		skill.setSkillName(skillDTO.getSkillName());
		skillRepository.save(skill);
		return true;
	}
	@Override
	public boolean deleteSkill(int skillId) throws SkillNotFoundException {
		Skill skill = skillRepository.findById(skillId).orElseThrow(()->new SkillNotFoundException("SKILL NOT FOUND"));
		skillRepository.delete(skill);
		return true;
	}

}
