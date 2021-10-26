package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.ContinenteDto;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {

    //le llega un dto y lo convierte ne un entity
    public ContinenteEntity continenteDTO2Entity(ContinenteDto dto) {
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(dto.getImagen());
        continenteEntity.setDenominacion(dto.getDenominacion());
        return continenteEntity;
    }

    public ContinenteDto continenteEntity2DTO(ContinenteEntity entity){
        ContinenteDto dto = new ContinenteDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }

    public List<ContinenteDto> continenteEntityList2DTOList(List<ContinenteEntity> entities){
        List<ContinenteDto> dtos = new ArrayList<>();
        for(ContinenteEntity entity: entities){
            dtos.add(this.continenteEntity2DTO(entity));
        }
        return dtos;
    }
}
