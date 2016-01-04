package com.ge.apm.cases.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class CasesCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasesCatalogApplication.class, args);
    }
}
