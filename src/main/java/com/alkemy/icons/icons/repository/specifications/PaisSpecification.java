package com.alkemy.icons.icons.repository.specifications;

import com.alkemy.icons.icons.dto.PaisFiltersDto;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaisSpecification {

    //TODO: Falta la implementación
    public Specification<PaisEntity> getByFilters(PaisFiltersDto filtersDto){
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
            if(StringUtils.hasLength(filtersDto.getContinenteId())){
                Long continenteId = Long.parseLong(filtersDto.getContinenteId());
                predicates.add(
                        criteriaBuilder.equal(root.get("continenteId"), continenteId)
                );
            }

            //remove duplicates
            query.distinct(true);

            //ordenamiento ASC and DESC

            String orderByField = "denominacion";
            query.orderBy(
                    filtersDto.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });


    }
}
