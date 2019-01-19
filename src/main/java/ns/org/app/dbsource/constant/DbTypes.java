/**
  DbType.java
 ***********************************************************************************************************************
 Description: 	

 Revision History:
 -----------------------------------------------------------------------------------------------------------------------
 Date         	Author               	Reason for Change
 -----------------------------------------------------------------------------------------------------------------------
 20-Jan-2019		Nawal Sah				Initial Version

 Copyright (c) 2018,
 ***********************************************************************************************************************
 */
package ns.org.app.dbsource.constant;

import java.util.Arrays;

/**
 * Data type supported enum
 */
public enum DbTypes {
	SQL("SQL"),
	NO_SQL("NoSQL"),
	NOT_SUPPORTED("NotSupported");

	private String dbType;

	private DbTypes(String dbType) {
		this.dbType = dbType;
	}

	public static DbTypes getEnum(String dbType) {
		return Arrays.asList(DbTypes.values()).stream().filter(type -> type.value().equalsIgnoreCase(dbType))
				.findFirst().orElse(NOT_SUPPORTED);
	}

	public String value() {
		return this.dbType;
	}

}
