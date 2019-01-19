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

import ns.org.app.dbsource.condition.NoSqlDBCondition;
import ns.org.app.dbsource.constant.AppConstants;
import ns.org.app.dbsource.entity.UserDoc;
import ns.org.app.dbsource.repo.UserDocRepo;

@Service
@Conditional(value = NoSqlDBCondition.class)
public class UserServiceMongoImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceMongoImpl.class);

	@Autowired
	UserDocRepo docRepo;

	@Value(AppConstants.DB_TYPE_PROP)
	private String dbName;

	public void save() {
		log.info("Db Name : [{}]", dbName);

		UserDoc userDoc = new UserDoc();
		userDoc.setAge("25");
		userDoc.setName("nawl");
		docRepo.save(userDoc);

		log.info("saved in mongodb");
	}
}
