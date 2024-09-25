package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@SpringBootApplication
public class BootMvcProject19TilesIntegrationApplication {
	
	@Bean
	public TilesConfigurer createTilesConfigurer() {
		System.out.println("BootMvcProject19TilesIntegrationApplication.createTilesConfigurer()");
		TilesConfigurer configure=new TilesConfigurer();
		configure.setDefinitions("/WEB-INF/tiles.xml");
		return configure;
	}
	
	
	@Bean
	public TilesViewResolver createTVResolver() {
		System.out.println("BootMvcProject19TilesIntegrationApplication.createTVResolver()");
		 TilesViewResolver resolver=new  TilesViewResolver();
		 return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProject19TilesIntegrationApplication.class, args);
	}

}
