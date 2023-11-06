package com.santosh.discovery.naminglbdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingLbDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingLbDiscoveryServerApplication.class, args);
	}

}
