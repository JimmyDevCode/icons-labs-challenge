package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.ContinenteDto;
import com.alkemy.icons.icons.dto.IconBasicDto;
import com.alkemy.icons.icons.dto.IconDto;
import com.alkemy.icons.icons.dto.PaisDto;

import java.util.List;

public interface PaisService {

    PaisDto save(PaisDto dto);

    List<PaisDto> getAll();
    
    void addIcon(Long id, Long idIcon);

    void removeIcon(Long id, Long idIcon);
}
