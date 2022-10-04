package com.nttdata.patterdesin.patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nttdata.patterdesin.patterns.chain.Unidad;
import com.nttdata.patterdesin.patterns.chain.Unidad2;
import com.nttdata.patterdesin.patterns.chain.UnidadDeMando;
import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.domain.Person;
import com.nttdata.patterdesin.proxy.AbstractPersonProxy;
import com.nttdata.patterdesin.proxy.PersonProxyBBDD;
import com.nttdata.patterdesin.proxy.PersonProxyCOLAS;
import com.nttdata.patterdesin.patterns.singleton.PersonSingletonEnum;

@SpringBootApplication
@ComponentScan(value = "com.nttdata")
public class PatternsApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    private PersonInterface personPrototype;

    public PatternsApplication(PersonInterface personPrototype) {
        this.personPrototype = personPrototype;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicio...");

        System.out.println("=============================================================================");
        System.out.println("Prácticas con Singleton");
        System.out.println("=============================================================================");
        PersonSingletonEnum.INSTANCE.person().setName("Joselito");

        System.out.println(PersonSingletonEnum.INSTANCE.person().getName());

        System.out.println("Fin...");
        
        System.out.println("Clonar un objeto");
        
        Person Alberto = new Person("Alberto", 20);
        
        Person AlbertoClone = Alberto.clone();
        
        System.out.println("Nombre del objeto: " + Alberto.getName() + " con edad: " + Alberto.getAge());
        
        System.out.println("Nombre del objeto clonado: " + AlbertoClone.getName() + " con edad: " + AlbertoClone.getAge());
        
        System.out.println("Fin...");
        
        System.out.println("Proxy");
        
        Person persona = Person.Builder().age(20).name("Alberto").build();
		
		
		AbstractPersonProxy proxyBBDD = new PersonProxyBBDD(persona);
		AbstractPersonProxy proxyCOLAS = new PersonProxyCOLAS(persona);
		
		proxyBBDD.operacion();
		proxyCOLAS.operacion();
		
		UnidadDeMando Unidad = new UnidadDeMando();
		
		Unidad.anadirEjercito(new Unidad2("Capitan"));
		Unidad.anadirEjercito(new Unidad("Sargento"));
		Unidad.anadirEjercito(new Unidad("Soldado"));
		
		Unidad.ejecutaOrden("Completar la misión ");
	
		System.out.println("Fin...");
        
        
    }
}
