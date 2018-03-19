package com.alaythiaproductions.customspringbootmvc.services;

import com.alaythiaproductions.customspringbootmvc.models.Employee;
import com.alaythiaproductions.customspringbootmvc.models.Skill;
import com.alaythiaproductions.customspringbootmvc.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;


    public void addSkill(Skill skill, Employee employee) {
        skill.setEmployee(employee);
        skillRepository.save(skill);
    }

    public List<Skill> findByEmployeeId(int id) {
        return skillRepository.findByEmployeeId(id);
    }

    public List<Skill> findByName(String name ) {
        return skillRepository.findByName(name);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }
}
