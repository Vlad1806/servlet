package org.hillel.persistence.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VehicleEntity.class)
public abstract class VehicleEntity_ extends org.hillel.persistence.entity.AbstractModifyEntity_ {

	public static volatile ListAttribute<VehicleEntity, JourneyEntity> journeys;
	public static volatile ListAttribute<VehicleEntity, VehicleSeatEntity> vehicleSeats;
	public static volatile SingularAttribute<VehicleEntity, String> name;
	public static volatile SingularAttribute<VehicleEntity, Integer> maxSeats;

	public static final String JOURNEYS = "journeys";
	public static final String VEHICLE_SEATS = "vehicleSeats";
	public static final String NAME = "name";
	public static final String MAX_SEATS = "maxSeats";

}

