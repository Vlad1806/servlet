package org.hillel.controller.convertor;

import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleMapper {

//    @Mapping(source = "vehicleName", target = "name")
    VehicleDto vehicleToVehicleDto(VehicleEntity vehicle);

    //    @Mapping(source = "name", target = "vehicleName")
    VehicleEntity vehicleDtoToVehicle(VehicleDto dto);
}
