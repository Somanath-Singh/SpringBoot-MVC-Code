package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProject15I18nApplication {


    @Bean(name="localeResolver")//fixed bean id
    public SessionLocaleResolver createSLResolver() {
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","US"));
		return resolver;
	}

    @Bean
   public LocaleChangeInterceptor createLCIntercepter() {
		LocaleChangeInterceptor intercepter =new LocaleChangeInterceptor();
		 intercepter.setParamName("lang");//default is language
		 return intercepter;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProject15I18nApplication.class, args);
	}

}
