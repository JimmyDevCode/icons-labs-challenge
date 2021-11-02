package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.IconBasicDto;
import com.alkemy.icons.icons.dto.IconDto;

import java.util.List;
import java.util.Set;

public interface IconService {

    IconDto getDetailsById(Long id);

    List<IconBasicDto> getAll();

    List<IconDto> getByFilters(String name, String date, Set<Long> cities, String order);

    IconDto save(IconDto iconDto);

    IconDto update(Long id, IconDto icon);

    void delete(Long id);

}
