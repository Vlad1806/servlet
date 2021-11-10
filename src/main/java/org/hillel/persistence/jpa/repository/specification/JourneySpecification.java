package org.hillel.persistence.jpa.repository.specification;

import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.entity.JourneyEntity_;
import org.springframework.data.jpa.domain.Specification;

public enum JourneySpecification implements CommonSpecification<JourneyEntity> {

    BY_STATION_FROM{
        @Override
        public Specification<JourneyEntity> getSpecification(String stationFrom){
            return (root, query, builder) ->
                    builder.equal(root.get(JourneyEntity_.STATION_FROM), builder.literal(stationFrom));
        }
    }
}
