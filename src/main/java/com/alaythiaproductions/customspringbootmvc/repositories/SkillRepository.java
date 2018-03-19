package com.alaythiaproductions.customspringbootmvc.repositories;

import com.alaythiaproductions.customspringbootmvc.models.Employee;
import com.alaythiaproductions.customspringbootmvc.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    List<Skill> findByEmployee(Employee employee);
}
