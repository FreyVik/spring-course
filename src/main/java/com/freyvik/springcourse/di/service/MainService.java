package com.freyvik.springcourse.di.service;

import org.springframework.stereotype.Service;

@Service
public class MainService {
	
	public String operacion() {
		return "ejecutando service";
	}
}