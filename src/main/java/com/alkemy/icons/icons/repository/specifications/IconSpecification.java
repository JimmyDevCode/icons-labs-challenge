package com.alkemy.icons.icons.repository.specifications;


import com.alkemy.icons.icons.dto.IconFiltersDto;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

@Component
public class IconSpecification {

    //TODO: Falta la implementación
    public Specification<IconEntity> getByFilters(IconFiltersDto filtersDto){
        return((root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDto.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%" + filtersDto.getName().toLowerCase() + "%"
                        )
                );
            }
            if(StringUtils.hasLength(filtersDto.getDate())){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(filtersDto.getDate(), formatter);

                predicates.add(
                        criteriaBuilder.equal(root.<LocalDate>get("fechaCreacion"), date)
                );
            }
            if(!CollectionUtils.isEmpty(filtersDto.getCities())){
                Join<PaisEntity, IconEntity> join = root.join("paises", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add(citiesId.in(filtersDto.getCities()));
            }

            //remove duplicates
            query.distinct(true);

            //ordenamiento ASC and DESC

            String orderByField = "denominacion";
            query.orderBy(
                    filtersDto.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)):
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });


    }

}
