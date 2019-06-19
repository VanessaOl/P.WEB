package br.fatec.ra1511039.util;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
  	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	            .configure( "hibernate.cfg.xml" )
	            .build();

		List<Class<?>> classes = EntityScanner
		            .scanPackages("br.fatec.ra1721040.controller").result();
		    MetadataSources metadataSources = new MetadataSources(standardRegistry);
		    
		    for (Class<?> annotatedClass : classes) {
		        metadataSources.addAnnotatedClass(annotatedClass);
		    }
		    return metadataSources.buildMetadata()
		        .buildSessionFactory();	
	}

	public static SessionFactory getSessionFactory() {
          return sessionFactory;
      }
	
}

