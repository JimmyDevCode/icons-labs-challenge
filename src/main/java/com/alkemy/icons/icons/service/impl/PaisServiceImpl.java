package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDto;
import com.alkemy.icons.icons.dto.IconBasicDto;
import com.alkemy.icons.icons.dto.IconDto;
import com.alkemy.icons.icons.dto.PaisDto;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import com.alkemy.icons.icons.mapper.PaisMapper;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    PaisMapper paisMapper;
    @Autowired
    private PaisRepository paisRepository;

    public PaisDto save(PaisDto dto) {
        PaisEntity entity = paisMapper.paisDTO2Entity(dto);
        PaisEntity entitySaved = paisRepository.save(entity);
        PaisDto result = paisMapper.paisEntity2DTO(entitySaved, true);

        return result;
    }

    public List<PaisDto> getAll() {

        List<PaisEntity> entities = paisRepository.findAll();
        List<PaisDto> result = paisMapper.paisEntityList2DTOList(entities, true);
        return result;

    }

    @Override
    public void addIcono(Long id, Long idIcon) {

    }

    @Override
    public void removeIcon(Long id, Long idIcon) {

    }

    //TODO: Falta actualizar y eliminar
}
