package org.hillel.service.jpa;

import lombok.AllArgsConstructor;
import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.jpa.repository.JourneyJpaRepository;
import org.hillel.persistence.jpa.repository.specification.JourneySpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JpaTransactionJourneyService {

    private final JourneyJpaRepository journeyRepository;

    public Optional<JourneyEntity> findById(Long journeyId){
        return journeyRepository.findById(journeyId);
    }

    public Collection<JourneyEntity> findByStationFrom(String stationFrom){
        return journeyRepository.findByStationFrom(stationFrom);
    }

    public JourneyEntity createOrUpdateJourney(JourneyEntity journey){
        return journeyRepository.save(journey);
    }

    public List<JourneyEntity> findAllJourneyByStationFrom(String stationFrom, Integer page, Integer size){
        return journeyRepository
                .findAll(JourneySpecification.BY_STATION_FROM.getSpecification(stationFrom),
                        PageRequest.of(page,size)).getContent();
    }

}
