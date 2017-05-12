package org.provider.rest;

import org.business.configuration.SpringBusinessConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * EdossierApplication : Class de l'application edossier avec les propriete
 * spring.
 */
@SpringBootApplication
@ComponentScan({ "org.provider.rest" })
@Import({ SpringBusinessConfig.class})
@PropertySource(value = { "file:C:/Users/W1NN1/Desktop/Socle/properties/meetunit.properties" })
public class SiteApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SiteApplication.class);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SiteApplication.class, args);
	}
}