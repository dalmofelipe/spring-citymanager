package com.citymanager.Secretariat.exceptions.contract;

import java.util.Map;

public interface MessageException {

	String getExceptionKey();
	Map<String, Object> getMapDetails();
}
