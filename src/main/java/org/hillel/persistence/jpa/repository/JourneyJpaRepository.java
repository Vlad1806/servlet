package org.hillel.persistence.jpa.repository;

import org.hillel.persistence.entity.JourneyEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface JourneyJpaRepository extends CrudRepository<JourneyEntity, Long>,
        JpaSpecificationExecutor<JourneyEntity> {

    Collection<JourneyEntity> findByStationFrom(String stationFrom);
}
