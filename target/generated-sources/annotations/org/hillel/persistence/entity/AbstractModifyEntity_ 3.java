package org.hillel.persistence.entity;

import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractModifyEntity.class)
public abstract class AbstractModifyEntity_ extends org.hillel.persistence.entity.AbstractEntity_ {

	public static volatile SingularAttribute<AbstractModifyEntity, Boolean> active;
	public static volatile SingularAttribute<AbstractModifyEntity, Instant> createDate;

	public static final String ACTIVE = "active";
	public static final String CREATE_DATE = "createDate";

}

