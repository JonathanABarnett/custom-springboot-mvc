package com.alaythiaproductions.customspringbootmvc.repositories;

import com.alaythiaproductions.customspringbootmvc.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
