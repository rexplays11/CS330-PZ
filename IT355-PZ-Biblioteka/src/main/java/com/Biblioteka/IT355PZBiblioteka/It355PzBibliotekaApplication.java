package com.Biblioteka.IT355PZBiblioteka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class It355PzBibliotekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(It355PzBibliotekaApplication.class, args);
	}
	@GetMapping("/")
	public String GlavnaStranica() {
		return "GlavnaStranica";
	}

}
