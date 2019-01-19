/**
  UserRepo.java
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
package ns.org.app.dbsource.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ns.org.app.dbsource.entity.UserEntity;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Long>{

}
