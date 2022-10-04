package com.nttdata.patterdesin.proxy;

public abstract class AbstractPersonProxy implements PersonProxyInterface {
	private PersonProxyInterface person;

	public AbstractPersonProxy(PersonProxyInterface person) {
		this.person = person;
	}

	@Override
	public void operacion() {
		before();
		person.operacion();
		after();
	}

	public abstract void before();

	public abstract void after();

}
