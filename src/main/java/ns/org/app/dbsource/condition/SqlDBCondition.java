/**
  DataSourceCondition.java
 ***********************************************************************************************************************
 Description: 	

 Revision History:
 -----------------------------------------------------------------------------------------------------------------------
 Date         	Author               	Reason for Change
 -----------------------------------------------------------------------------------------------------------------------
 16-Dec-2018		Nawal Sah				Initial Version

 Copyright (c) 2018,
 ***********************************************************************************************************************
 */
package ns.org.app.dbsource.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import ns.org.app.dbsource.constant.AppConstants;
import ns.org.app.dbsource.constant.DbTypes;

public class SqlDBCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String dbName = context.getEnvironment().getProperty(AppConstants.DB_TYPE_PROP);
		return dbName.equalsIgnoreCase(DbTypes.SQL.value());
	}

}
