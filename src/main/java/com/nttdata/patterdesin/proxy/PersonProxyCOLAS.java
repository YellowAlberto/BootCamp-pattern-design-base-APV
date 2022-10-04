package com.nttdata.patterdesin.proxy;

import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.domain.Person;

public class PersonProxyCOLAS extends AbstractPersonProxy {
	
	public PersonProxyCOLAS(PersonProxyInterface person) {
		super(person);
	}

	public  void before() {
		System.out.println("Conexion con COLAS abierta...");
	}

	public  void after() {
		System.out.println("Conexión con COLAS cerrada...");
	}

}
