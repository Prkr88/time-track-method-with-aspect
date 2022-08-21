package com.aspectDemo.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {
	public String retrieveSomethingFromDB() {
		return "Data from DB";
	}
}
