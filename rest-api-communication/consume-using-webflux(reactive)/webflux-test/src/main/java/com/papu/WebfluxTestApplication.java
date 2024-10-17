package com.papu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebfluxTestApplication {

	static String url = "http://localhost:8080/make-my-trip/customers/{id}";

	public static void main(String[] args) {
		SpringApplication.run(WebfluxTestApplication.class, args);

		WebClient webClient = WebClient.create();

		System.out.println("request sending start ......");

		webClient.get()
				.uri(url,"CUST003")
				.retrieve()
				.bodyToMono(String.class)
				.subscribe(WebfluxTestApplication::handleResponse);//async

		//block() is for synchronous

		System.out.println("request sending end ......");
	}

	public static void handleResponse(String response) {
		System.out.println(response);
	}


}
