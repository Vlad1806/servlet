package org.hillel.service.jpa;

import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.persistence.jpa.repository.SimpleVehicleDto;
import org.hillel.persistence.jpa.repository.VehicleJpaRepository;
import org.hillel.persistence.jpa.repository.specification.VehicleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class JpaTransactionalVehicleService {

    @Autowired
    private VehicleJpaRepository vehicleJpaRepository;

    @Transactional
    public VehicleEntity createOrUpdateVehicle(VehicleEntity vehicle){
        return vehicleJpaRepository.save(vehicle);
    }
    private void vehicleDependencies(Collection<VehicleEntity> all){
        for (VehicleEntity entity2 :all) {
            entity2.getVehicleSeats().size();
        }
    }

    @Transactional(readOnly = true)
    public Optional<VehicleEntity> findById(Long id, boolean withDependencies){
        final Optional<VehicleEntity> vehicle = vehicleJpaRepository.findById(id);
        if (vehicle.isEmpty()) return vehicle;
        if (!withDependencies) return vehicle;
        vehicle.get().getVehicleSeats().size();
        return vehicle;
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findByIds(Long... ids){
        return (Collection<VehicleEntity>) vehicleJpaRepository.findAllById(Arrays.asList(ids));
    }

    @Transactional
    public void remove(VehicleEntity vehicleEntity){
        vehicleJpaRepository.delete(vehicleEntity);
    }

    @Transactional
    public void removeById(Long id){
        vehicleJpaRepository.deleteById(id);
    }


//    @Transactional(readOnly = true)
//    public Collection<VehicleEntity> findVehicleByMinSeats(){
//        final Collection<VehicleEntity> all = vehicleJpaRepository.findVehicleByMinSeats();
//        vehicleDependencies(all);
//        return all;
//    }
//
//    @Transactional(readOnly = true)
//    public Collection<VehicleEntity> findVehicleByMaxSeats(){
//        final Collection<VehicleEntity> all = vehicleJpaRepository.findVehicleByMaxSeats();
//        vehicleDependencies(all);
//        return all;
//    }


    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAll(){
        Collection<VehicleEntity> all = (Collection<VehicleEntity>) vehicleJpaRepository.findAll();
        if (all.isEmpty()) return all;
        vehicleDependencies(all);
        return all;
    }

    @Transactional(readOnly = true)
//            (noRollbackFor = IllegalArgumentException.class)
    public Collection<VehicleEntity> findByName(String name){
//        final Page<VehicleEntity> byName = vehicleJpaRepository.findByConditions( "%" + name + "%",
//                1L,
//                100L,
//                PageRequest.of(1, 3, Sort.by(VehicleEntity_.ID)));
//        final List<VehicleEntity> byName = vehicleJpaRepository.findOnlyActive();
        VehicleEntity entity = new VehicleEntity();
        entity.setActive(false);
        final Example<VehicleEntity> example = Example.of(entity);
        final VehicleEntity vehicleEntity = new VehicleEntity();vehicleEntity.setName("Bus_3");
        final List<VehicleEntity> byName = vehicleJpaRepository.findAll(VehicleSpecification.byNameAndExample(name, vehicleEntity));
//        if (byName.isEmpty()) return byName;
//        vehicleDependencies(byName);
        return byName;
    }

    @Transactional
    public void disableById(Long id){
        vehicleJpaRepository.disableById(id);
    }

    public List<SimpleVehicleDto> listAllSimpleVehicles(){
        return vehicleJpaRepository.findAllByActiveIsTrue();
    }
}
