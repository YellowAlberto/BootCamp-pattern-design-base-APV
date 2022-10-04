package com.nttdata.patterdesin.proxy;

public class PersonProxyBBDD extends AbstractPersonProxy {
	
	public PersonProxyBBDD(PersonProxyInterface person) {
		super(person);
	}

	public  void before() {
		System.out.println("Conexion con BBDD abierta...");
	}

	public  void after() {
		System.out.println("Conexion con BBDD cerrada...");
	}

}
