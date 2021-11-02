package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepository extends JpaRepository <IconEntity, Long> {

}
