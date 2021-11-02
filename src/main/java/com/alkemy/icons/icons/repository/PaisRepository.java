package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository <PaisEntity, Long> {


}
