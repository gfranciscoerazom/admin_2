package com.microservice_2.admin_2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Admin2Application {

	@GetMapping("/admin2")
	public String admin2(@RequestParam String id) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest getRequest = HttpRequest.newBuilder()
				// .uri(new URI("https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp?ps_tipo_identificacion=CED&ps_identificacion=" + numeroCedula + "&ps_placa=" + placa))
				// https://www.gob.ec/api/v1/instituciones/{id}
				.uri(new URI("https://www.gob.ec/api/v1/instituciones/" + id))
				.build();

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		System.out.println(getResponse.body());
		return getResponse.body();
	}

	// .\mvnw clean package && docker build -t springservice_2 . && docker run -it --rm -p 3002:8080 --name mymicroservice_2 springservice_2
	public static void main(String[] args) {
		SpringApplication.run(Admin2Application.class, args);
	}

}