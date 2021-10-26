package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDto;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;

    public ContinenteDto save(ContinenteDto dto) {
        //TODO: guardar continente
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
        ContinenteEntity entitySaved = continenteRepository.save(entity);
        ContinenteDto result = continenteMapper.continenteEntity2DTO(entitySaved);

        return result;
    }

    public List<ContinenteDto> getAllContinentes() {

        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDto> result = continenteMapper.continenteEntityList2DTOList(entities);
        return result;
    }
}
