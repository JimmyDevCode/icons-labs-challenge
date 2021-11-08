package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.IconDto;
import com.alkemy.icons.icons.dto.IconFiltersDto;
import com.alkemy.icons.icons.dto.PaisDto;
import com.alkemy.icons.icons.dto.PaisFiltersDto;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.mapper.PaisMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.repository.specifications.PaisSpecification;
import com.alkemy.icons.icons.service.IconService;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    PaisMapper paisMapper;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private IconRepository iconRepository;
    @Autowired
    private IconService iconService;
    @Autowired
    private PaisSpecification paisSpecification;

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

    public void addIcon(Long id, Long idIcon) {
        PaisEntity entity = this.paisRepository.getById(id);
        entity.getIcons().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        entity.addIcon(iconEntity);
        this.paisRepository.save(entity);
    }

    public void removeIcon(Long id, Long idIcon) {
        PaisEntity entity = this.paisRepository.getById(id);
        entity.getIcons().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        entity.removeIcon(iconEntity);
        this.paisRepository.save(entity);

    }

    @Override
    public PaisDto update(Long id, PaisDto paisDto) {

        Optional<PaisEntity> entity = this.paisRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id país no valido");
        }
        this.paisMapper.paisEntityRefreshValues(entity.get(), paisDto);
        PaisEntity entitySaved = this.paisRepository.save(entity.get());
        PaisDto result = this.paisMapper.paisEntity2DTO(entitySaved, false);

        return result;
    }

    @Override
    public void delete(Long id) {

    }
    @Override
    public List<PaisDto> getByFilters(String name, String continente,  String order) {
        PaisFiltersDto filtersDto = new PaisFiltersDto(name, continente, order);
        List<PaisEntity> entities = this.paisRepository.findAll(this.paisSpecification.getByFilters(filtersDto));
        List<PaisDto> dtos = this.paisMapper.paisEntityList2DTOList(entities, true);
        return dtos;
    }

}
