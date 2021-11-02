package com.alkemy.icons.icons.service.impl;


import com.alkemy.icons.icons.dto.IconBasicDto;
import com.alkemy.icons.icons.dto.IconDto;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IconImpl implements IconService {

    @Autowired
    IconMapper iconMapper;
    @Autowired
    private IconRepository iconRepository;


    public IconDto getDetailsById(Long id) {
        Optional<IconEntity> entity = this.iconRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id icono no valido");
        }
        IconDto iconDto = this.iconMapper.iconEntity2DTO(entity.get(), true);
        return iconDto;
    }

    public List<IconBasicDto> getAll() {

        List<IconEntity> entities = this.iconRepository.findAll();
        List<IconBasicDto> iconBasicDTOS = this.iconMapper.iconEntitySetBasic2DTOList(entities);
        return  iconBasicDTOS;
    }

    //TODO: Falta implementar
    public List<IconDto> getByFilters(String name, String date, Set<Long> cities, String order) {
        return null;
    }

    public IconDto save(IconDto iconDto) {
        IconEntity entity = iconMapper.iconDTO2Entity(iconDto);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDto result = iconMapper.iconEntity2DTO(entitySaved, true);

        return result;
    }

    //TODO: Falta implementar el método actualizar
    public IconDto update(Long id, IconDto iconDto) {

        Optional<IconEntity> entity = this.iconRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id icono no valido");
        }
        this.iconMapper.iconEntityRefreshValues(entity.get(), iconDto);
        IconEntity entitySaved = this.iconRepository.save(entity.get());
        IconDto result = this.iconMapper.iconEntity2DTO(entitySaved, false);

        return result;
    }

    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }
}
