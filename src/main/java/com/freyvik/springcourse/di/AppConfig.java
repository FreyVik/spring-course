package com.freyvik.springcourse.di;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.freyvik.springcourse.di.domain.ItemFactura;
import com.freyvik.springcourse.di.domain.Producto;

@Configuration
public class AppConfig {
	
	/* Define beans in config
	@Bean("mainService")
	public IService registerMainService( ) {
		return new MainService();
	}
	
	@Primary
	@Bean("complexService")
	public IService registerComplexService( ) {
		return new ComplexService();
	}
	*/
	
	@Bean("itemFactura")
	public List<ItemFactura> registrarItems() {
		Producto prod1 = new Producto("Camara", 100);
		Producto prod2 = new Producto("Bicicleta", 200);
		
		ItemFactura item1 = new ItemFactura(prod1, 3);
		ItemFactura item2 = new ItemFactura(prod2, 5);
		
		return Arrays.asList(item1, item2);
	}
}
