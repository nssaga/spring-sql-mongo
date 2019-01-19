/**
  DBSourceConfiguration.java
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
package ns.org.app.dbsource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import ns.org.app.dbsource.condition.NoSqlDBCondition;
import ns.org.app.dbsource.condition.SqlDBCondition;
import ns.org.app.dbsource.service.UserService;
import ns.org.app.dbsource.service.UserServiceImpl;
import ns.org.app.dbsource.service.UserServiceMongoImpl;

@Configuration
public class ServiceBeanConfig {

	@Bean("userService")
	@Conditional(value = SqlDBCondition.class)
	public UserService getUserServiceSqlBean() {
		System.out.println("getUserServiceSqlBean");
		return new UserServiceImpl();
	}

	@Bean("userService")
	@Conditional(value = NoSqlDBCondition.class)
	public UserService getUserServiceNoSqlBean() {
		System.out.println("getUserServiceNoSqlBean");
		return new UserServiceMongoImpl();
	}

}
