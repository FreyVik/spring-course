package com.freyvik.springcourse.di.service;

import org.springframework.stereotype.Service;

@Service("complexService")
public class ComplexService implements IService {
	
	@Override
	public String operacion() {
		return "ejecutando complex service";
	}
}