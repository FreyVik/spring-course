package com.freyvik.springcourse.di.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 6974228388270942415L;

	@Autowired
	private Cliente cliente;
	
	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private List<ItemFactura> items;
	
	@PostConstruct
	public void init() {
		System.out.println("Se inicia el objeto factura");
		
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Felipe"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Se destruye objeto factura");
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}	
}