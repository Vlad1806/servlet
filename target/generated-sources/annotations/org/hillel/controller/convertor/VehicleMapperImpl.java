package org.hillel.controller.convertor;

import javax.annotation.processing.Generated;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.VehicleEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-06T16:55:45+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public VehicleDto vehicleToVehicleDto(VehicleEntity vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = vehicle.getId();
        name = vehicle.getName();

        VehicleDto vehicleDto = new VehicleDto( id, name );

        return vehicleDto;
    }

    @Override
    public VehicleEntity vehicleDtoToVehicle(VehicleDto dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleEntity vehicleEntity = new VehicleEntity();

        vehicleEntity.setId( dto.getId() );
        vehicleEntity.setName( dto.getName() );

        return vehicleEntity;
    }
}
