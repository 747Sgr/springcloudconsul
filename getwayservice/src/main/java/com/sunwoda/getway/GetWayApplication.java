package com.sunwoda.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 2007130280
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GetWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetWayApplication.class, args);
	}

}
