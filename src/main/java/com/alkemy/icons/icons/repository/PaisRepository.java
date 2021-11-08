package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PaisRepository extends JpaRepository <PaisEntity, Long> {

    List<PaisEntity> findAll(Specification<PaisEntity> spec);
}
