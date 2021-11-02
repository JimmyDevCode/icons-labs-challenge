package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.IconEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PaisDto {

    private Long id;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long superficie;
    private Long continenteId;
    private List<IconDto> iconos;

}
