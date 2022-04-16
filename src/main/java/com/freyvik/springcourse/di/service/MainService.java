package com.freyvik.springcourse.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("mainService")
public class MainService implements IService {
	
	@Override
	public String operacion() {
		return "ejecutando main service";
	}
}