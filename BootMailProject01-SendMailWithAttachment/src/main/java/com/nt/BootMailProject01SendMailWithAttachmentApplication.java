package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IShoping;

@SpringBootApplication
public class BootMailProject01SendMailWithAttachmentApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootMailProject01SendMailWithAttachmentApplication.class, args);
		//get Service class object
		IShoping service=ctx.getBean("shopping",IShoping.class);
		//invoke the b.method
		try {
			String result=service.shopping(new String[] {"shirt","trouser","belt"}, new float[] {1200,2300,3400}, new String[] {"singhsomanath247@gmail.com","bharatmurmu2002@gmail.com"});
			System.out.println(result);
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
	}

}
