package com.santosh.resilience.circuitbreakerservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api-retry")
    @Retry(name = "sampleApiRetry", fallbackMethod = "fallBackResponseForSampleAPI")
    public String sampleApiRetry(){
        logger.info("Sample API is called.");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-non-working-url", String.class);
        return responseEntity.getBody();
    }

    public String fallBackResponseForSampleAPI(Exception exception) {   // need to implement accepting class java.lang.Throwable as parameter
        logger.info("fallBackResponseForSampleAPI is returned.");
        return "Response from fallBackResponseForSampleAPI via fallbackMethod.";
    }

    @GetMapping("/sample-api-circuit-breaker")
    @CircuitBreaker(name = "sampleApiCircuitBreaker", fallbackMethod = "fallBackResponseForSampleAPI")
    public String sampleApiCircuitBreaker() {
        logger.info(" ********************* sampleApiCircuitBreaker is called");
        return new RestTemplate().getForEntity("http://localhost:8080/dummy", String.class).getBody();
    }

    @GetMapping("/rate-limiter-api")
    @RateLimiter(name = "default", fallbackMethod = "fallBackResponseForSampleAPI")
    public String rateLimiterApi() {
        logger.info(" ******************** rateLimiter is called.");
        return "Sample API Response";
    }

    @GetMapping("/bulk-head-api")
    @Bulkhead(name = "bulkHeadApi", fallbackMethod = "fallBackResponseForSampleAPI")
    public String bulkHeadApi() {
        logger.info(" *********** Bulk Head API is called.");
        return "Sample API Response";
    }
}
