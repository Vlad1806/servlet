package org.hillel.persistence.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CommonInfo.class)
public abstract class CommonInfo_ {

	public static volatile SingularAttribute<CommonInfo, String> name;
	public static volatile SingularAttribute<CommonInfo, String> description;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

}

