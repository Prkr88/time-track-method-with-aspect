package com.aspectDemo.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aspectDemo.aspect.TrackTime;
import com.aspectDemo.data.Dao;

@Service
public class BusinessLogic {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Dao dao;

	// using Spring constructor injection
	public BusinessLogic(Dao dao) {
		this.dao = dao;
	}

	@TrackTime
	public String executeBusinessLogic() {
		String data = dao.retrieveSomethingFromDB();
		logger.info("In BusinessLogic - {}", data);
		return data;
	}
}
