package com.centene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.centene.services.CasenetController;

@SpringBootApplication
public class Application  implements CommandLineRunner{
	
	@Autowired private CasenetController fooBarController;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {

       System.out.println("hi");
       fooBarController.fooBar();
    }
}
