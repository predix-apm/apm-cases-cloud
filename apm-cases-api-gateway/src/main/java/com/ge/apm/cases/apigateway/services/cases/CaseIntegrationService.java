package com.ge.apm.cases.apigateway.services.cases;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Service
public class CaseIntegrationService {

    private Log log = LogFactory.getLog(CaseIntegrationService.class);

    @Autowired
    @Qualifier("loadBalancedRestTemplate")
    @LoadBalanced
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "stubMovie",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
            }
    )
    public Observable<ApmCase> getCase(final String mlId) {
        return new ObservableResult<ApmCase>() {
            @Override
            public ApmCase invoke() {
                final ApmCase aCase = getMeACase(mlId);
                log.debug(aCase);
                return aCase;
            }
        };
    }

    @SuppressWarnings("unused")
    private ApmCase stubMovie(final String mlId) {
        ApmCase stub = new ApmCase();
        stub.setMlId(mlId);
        stub.setTitle("Interesting...the wrong title. Sssshhhh!");
        return stub;
    }

    private ApmCase getMeACase(String mlId) {
        ApmCase aCase = new ApmCase();
        aCase.setMlId("100");
        aCase.setTitle("First Case");
        return aCase;
    }
}
