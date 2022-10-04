package com.nttdata.patterdesin.patterns.decorator;

public class PersonaDecorator implements PersonInterface {

	private PersonInterface delegate;
	
	public PersonaDecorator(PersonInterface delegate) {
		this.delegate = delegate;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return delegate.getName();
	}

	@Override
	public void setName(String name) {
		this.delegate.setName(name);
		
	}

	@Override
	public int getAge() {
		return delegate.getAge();
	}

	@Override
	public void setAge(int age) {
		this.delegate.setAge(age);
		
	}

}
