package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconBasicDto;
import com.alkemy.icons.icons.dto.IconDto;
import com.alkemy.icons.icons.dto.PaisDto;
import com.alkemy.icons.icons.entity.IconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class IconMapper {

    @Autowired
    PaisMapper paisMapper;

    //le llega un dto y lo convierte en un entity para guardarlo
    public IconEntity iconDTO2Entity(IconDto dto) {
        IconEntity entity = new IconEntity();
        entity.setId(dto.getId());
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setFechaCreacion(this.string2localDate(dto.getFechaCreacion()));
        entity.setAltura(dto.getAltura());
        entity.setHistoria(dto.getHistoria());

        return entity;
    }
    //recibo una entidad y lo convierto a dto para ser mostrada
    public IconDto iconEntity2DTO(IconEntity entity, boolean loadPaises){
        IconDto dto  = new IconDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setFechaCreacion(entity.getFechaCreacion().toString());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
       if(loadPaises){
           List<PaisDto> paisesDto = paisMapper.paisEntityList2DTOList(entity.getPaises(), false);
        dto.setPaises(paisesDto);
       }
        return dto;
    }

    //recibo dtos y lo convierto en entidades para ser guardadas
    public Set<IconEntity> iconDTO2List2Entity(List<IconDto> dtos){
        Set<IconEntity> entities = new HashSet<>();
        for(IconDto dto: dtos){
            entities.add(this.iconDTO2Entity(dto));
        }
        return  entities;
    }

    //recibo entidades y lo convierto en dtos para ser mostradas
   public List<IconDto> iconEntitySet2DTOList(Collection<IconEntity> entities, boolean loadPaises){
        List<IconDto> dtos = new ArrayList<>();
        for(IconEntity entity: entities){
            dtos.add(this.iconEntity2DTO(entity, loadPaises));
        }
        return dtos;
   }

   public List<IconBasicDto> iconEntitySetBasic2DTOList(Collection<IconEntity> entities){
        List<IconBasicDto> dtos = new ArrayList<>();
        IconBasicDto basicDto;
        for(IconEntity entity: entities){
            basicDto = new IconBasicDto();
            basicDto.setId(entity.getId());
            basicDto.setImagen(entity.getImagen());
            basicDto.setDenominacion(entity.getDenominacion());
            dtos.add(basicDto);
        }
        return dtos;
   }

   public void iconEntityRefreshValues(IconEntity entity, IconDto iconDto){
        entity.setImagen(iconDto.getImagen());
        entity.setDenominacion(iconDto.getDenominacion());
        entity.setFechaCreacion(this.string2localDate(iconDto.getFechaCreacion()));
        entity.setAltura(iconDto.getAltura());
        entity.setHistoria(iconDto.getHistoria());
   }

    //formateo la fecha en formato año-mes-dia
    private LocalDate string2localDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return  date;
    }
}
