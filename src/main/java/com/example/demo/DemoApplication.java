package com.example.demo;

import RequestHttp.RequestMarvel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static RequestMarvel requestMarvel = new RequestMarvel();
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		try {
			requestMarvel.requestGetMarvel();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
