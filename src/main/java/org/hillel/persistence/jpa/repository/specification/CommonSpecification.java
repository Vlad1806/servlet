package org.hillel.persistence.jpa.repository.specification;

import org.hillel.persistence.entity.AbstractModifyEntity_;
import org.hillel.persistence.entity.VehicleEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

public interface CommonSpecification<E>{

    Specification getSpecification(@Nullable String filter);

       default Specification<VehicleEntity> onlyActive () {
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.isTrue(root.get(AbstractModifyEntity_.ACTIVE));
        }
}
