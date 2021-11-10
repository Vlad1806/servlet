package org.hillel.persistence.entity;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StopAdditionalInfoEntity.class)
public abstract class StopAdditionalInfoEntity_ {

	public static volatile SingularAttribute<StopAdditionalInfoEntity, LocalDate> dateBuild;
	public static volatile SingularAttribute<StopAdditionalInfoEntity, StopEntity> stop;
	public static volatile SingularAttribute<StopAdditionalInfoEntity, String> city;
	public static volatile SingularAttribute<StopAdditionalInfoEntity, Double> latitude;
	public static volatile SingularAttribute<StopAdditionalInfoEntity, Long> id;
	public static volatile SingularAttribute<StopAdditionalInfoEntity, Double> longitude;

	public static final String DATE_BUILD = "dateBuild";
	public static final String STOP = "stop";
	public static final String CITY = "city";
	public static final String LATITUDE = "latitude";
	public static final String ID = "id";
	public static final String LONGITUDE = "longitude";

}

