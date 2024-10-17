# Spring-boot-RestTemplete-WebFlux

Consumer Development
======================

=> The application which is accessing services from other applications is called as Consumer application.

=> In Spring Boot we can develop Consumer in 3 ways

			1) RestTemplate (out dated)
			
			2) WebClient ( From Spring 5.x)
Steps To develop Make My Trip Application (Consumer)
=====================================================

1) Create Spring Boot app with below dependencies

		a) web-starter
		b) thymeleaf-starter
		c) lombok
		d) devtools

2) Create Request and Response Binding classes

3) Create Service class with Integration Logic

4) Create Controller with Required methods

			a) GET - load form
			b) POST - Book ticket
			c) GET - Get Ticket

6) Run the application



=> WebClient is a predefined interface introduced in Spring 5.x version

=> Using WebClient we can send HTTP Requests (GET, POST, PUT, DELETE)

=> WebClient supports both Synchronus & Asynchronus communications

=> To use WebClient, we need to add "web-flux-starter" in pom.xml file


Sync & Async Communication
============================

Sync Communication : After sending the request thread will wait for Response

ASync Communication : After sending the request thread will not wait for response


RestTemplate --> Class ---> Sync

WebClient --> Interface --> Sync & Async
   

   
