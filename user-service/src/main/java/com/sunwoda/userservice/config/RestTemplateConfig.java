package com.sunwoda.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 *
 * @author shiguorang
 * @date 2021-04-02 15:35:38
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced//    此注解带负载均衡功能，轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
