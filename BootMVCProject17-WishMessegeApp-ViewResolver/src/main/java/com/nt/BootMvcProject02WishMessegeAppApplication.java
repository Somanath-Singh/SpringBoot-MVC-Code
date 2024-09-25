package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@SpringBootApplication
public class BootMvcProject02WishMessegeAppApplication {

	/*@Bean
	public ViewResolver createURLBasedResolver() {
		
		System.out.println("BootMvcProject02WishMessegeAppApplication.URLBasedResolver()");
		UrlBasedViewResolver resolver=new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
			resolver.setViewClass(InternalResourceView.class);
		resolver.setViewClass(JstlView.class);
		return resolver;
		
	}*/
	
	/*@Bean
	public ViewResolver createIRVResolver() {
		
		System.out.println("BootMvcProject02WishMessegeAppApplication.URLBasedResolver()");
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}*/
	
	/*@Bean
	public ViewResolver createRVVResolver() {
		
		System.out.println("BootMvcProject02WishMessegeAppApplication.createRVVResolver()");
		ResourceBundleViewResolver resolver=new ResourceBundleViewResolver();
		resolver.setBasename("com/nt/commons/views");
		return resolver;
		
	}*/
	
	@Bean
	public ViewResolver createXMLResolver() {
		
		System.out.println("BootMvcProject02WishMessegeAppApplication.createXMLResolver()");
		XmlViewResolver resolver=new XmlViewResolver();
		resolver.setLocation(new ClassPathResource("com/nt/cfgs/views.xml"));
		return resolver;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProject02WishMessegeAppApplication.class, args);
	}

}
