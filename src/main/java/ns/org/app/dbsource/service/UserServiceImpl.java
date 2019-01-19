/**
  UserServiceImpl.java
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
package ns.org.app.dbsource.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import ns.org.app.dbsource.condition.SqlDBCondition;
import ns.org.app.dbsource.constant.AppConstants;
import ns.org.app.dbsource.entity.UserEntity;
import ns.org.app.dbsource.repo.UserEntityRepo;

@Conditional(value = SqlDBCondition.class)
@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserEntityRepo entityRepo;

	@Value(AppConstants.DB_TYPE_PROP)
	private String dbName;

	public void save() {
		log.info("Db Name : [{}]", dbName);

		UserEntity entity = new UserEntity();
		entity.setAge("25");
		entity.setName("NAWAl");

		entityRepo.save(entity);
		log.info("saved in sql");

	}
}
