package com.alkemy.icons.icons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
//TODO: FALTA IMPLEMENTAR ESTOS ATRIBUTOS
public class PaisFiltersDto {

    private String name;
    private String continenteId;
    private String order;

    public PaisFiltersDto(String name, String continenteId, String order) {
        this.name = name;
        this.continenteId = continenteId;
        this.order = order;
    }
    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
        return this.order.compareToIgnoreCase("DESC") == 0;
    }

}
