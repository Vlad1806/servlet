package org.hillel.persistence.entity;

import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hillel.persistence.entity.enums.DirectionType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JourneyEntity.class)
public abstract class JourneyEntity_ extends org.hillel.persistence.entity.AbstractModifyEntity_ {

	public static volatile SingularAttribute<JourneyEntity, Instant> arrival;
	public static volatile ListAttribute<JourneyEntity, VehicleSeatEntity> vehicleSeats;
	public static volatile SingularAttribute<JourneyEntity, Instant> departure;
	public static volatile ListAttribute<JourneyEntity, StopEntity> stops;
	public static volatile SingularAttribute<JourneyEntity, String> stationFrom;
	public static volatile SingularAttribute<JourneyEntity, String> stationTo;
	public static volatile SingularAttribute<JourneyEntity, DirectionType> direction;
	public static volatile SingularAttribute<JourneyEntity, VehicleEntity> vehicle;

	public static final String ARRIVAL = "arrival";
	public static final String VEHICLE_SEATS = "vehicleSeats";
	public static final String DEPARTURE = "departure";
	public static final String STOPS = "stops";
	public static final String STATION_FROM = "stationFrom";
	public static final String STATION_TO = "stationTo";
	public static final String DIRECTION = "direction";
	public static final String VEHICLE = "vehicle";

}

