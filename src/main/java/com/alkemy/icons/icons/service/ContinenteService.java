package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.ContinenteDto;

import java.util.List;

public interface ContinenteService {

    ContinenteDto save(ContinenteDto dto);

    List<ContinenteDto> getAllContinentes();
}
