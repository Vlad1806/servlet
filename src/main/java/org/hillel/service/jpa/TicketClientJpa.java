package org.hillel.service.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.persistence.jpa.repository.SimpleVehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class TicketClientJpa {

    @Autowired
    private JpaTransactionalVehicleService vehicleService;

    @Autowired
    private JpaTransactionJourneyService journeyService;

    //Journey
    @Transactional(readOnly = true)
    public Optional<JourneyEntity> findJourneyById(Long journeyId){
        return journeyService.findById(journeyId);
    }

    @Transactional
    public JourneyEntity createJourney(JourneyEntity journeyEntity){
        return journeyService.createOrUpdateJourney(journeyEntity);
    }

    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findJourneyByStationFrom(String stationFrom){
        return journeyService.findByStationFrom(stationFrom);
    }

    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findAllByStationFrom(String stationFrom, Integer page, Integer size){
        return journeyService.findAllJourneyByStationFrom(stationFrom, page, size);
    }


    //VehicleEntity manipulation
    public VehicleEntity createOrUpdateVehicle(VehicleEntity vehicle) {
        return vehicleService.createOrUpdateVehicle(vehicle);
    }
    public Optional<VehicleEntity> findVehicleById(Long id, boolean withDependencies){
        notNull(id,"id must be set");
        return vehicleService.findById(id,withDependencies);
    }
    public void removeVehicle(final VehicleEntity vehicleEntity){
        vehicleService.remove(vehicleEntity);
    }

    public void removeVehicleById(Long id){
        vehicleService.removeById(id);
    }

    public Collection<VehicleEntity> findVehicleByIds(boolean withDependencies, Long ... ids){
        return vehicleService.findByIds(ids);
    }
    public Collection<VehicleEntity> findAllVehicles(){
        return vehicleService.findAll();
    }

    public Collection<VehicleEntity> findAllVehiclesByName(String name){
        return vehicleService.findByName(name);
    }

    public void disableById(Long id){
        vehicleService.disableById(id);
    }

    public List<SimpleVehicleDto> listAllSimpleVehicles(){
        return vehicleService.listAllSimpleVehicles();
    }
}
