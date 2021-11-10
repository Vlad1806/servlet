package org.hillel.persistence.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VehicleSeatEntity.class)
public abstract class VehicleSeatEntity_ extends org.hillel.persistence.entity.AbstractModifyEntity_ {

	public static volatile SingularAttribute<VehicleSeatEntity, Boolean> booked;
	public static volatile SingularAttribute<VehicleSeatEntity, JourneyEntity> journey;
	public static volatile SingularAttribute<VehicleSeatEntity, Integer> seatNumber;
	public static volatile SingularAttribute<VehicleSeatEntity, VehicleEntity> vehicle;

	public static final String BOOKED = "booked";
	public static final String JOURNEY = "journey";
	public static final String SEAT_NUMBER = "seatNumber";
	public static final String VEHICLE = "vehicle";

}

