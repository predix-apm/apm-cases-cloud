package com.ge.apm.cases.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableJpaRepositories
@EnableDiscoveryClient
public class CasesReviewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasesReviewsApplication.class, args);
    }
}
