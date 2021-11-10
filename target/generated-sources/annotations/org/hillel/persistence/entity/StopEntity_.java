package org.hillel.persistence.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StopEntity.class)
public abstract class StopEntity_ extends org.hillel.persistence.entity.AbstractModifyEntity_ {

	public static volatile ListAttribute<StopEntity, JourneyEntity> journeys;
	public static volatile SingularAttribute<StopEntity, StopAdditionalInfoEntity> additionalInfo;
	public static volatile SingularAttribute<StopEntity, CommonInfo> commonInfo;

	public static final String JOURNEYS = "journeys";
	public static final String ADDITIONAL_INFO = "additionalInfo";
	public static final String COMMON_INFO = "commonInfo";

}

