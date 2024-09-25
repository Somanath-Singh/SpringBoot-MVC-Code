package com.nt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class BootMvcProject16FileUploadingAndDownloadingApplication {

	/*@Bean
	public   ViewResolver  createIRVR() {
	System.out.println("BootMvcProject16FileUploadingAndDownloadingApplication.createIRVR()");
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/

	//optional to place
	@Bean(name="multipartResolver")
	public StandardServletMultipartResolver  createCMResolver() {
		StandardServletMultipartResolver resolver=new StandardServletMultipartResolver();
		return resolver;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProject16FileUploadingAndDownloadingApplication.class, args);
	}

}
