package com.sunwoda.userservice.controller;

import com.sunwoda.userservice.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Description:
 *
 * @author shiguorang
 * @date 2021-04-02 11:23:12
 */
@RestController
@Slf4j
public class UserController {

    @Value("${server.port}")
    private int port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @return
     * @Author shiguorang
     * @Description //TODO
     * @Date 11:23:26 2021-04-02
     * @Param
     **/
    @GetMapping("/user/userGetProduct")
    public String getProduct() {

//        使用RestTemplate直接调用
//        RestTemplate restTemplate = new RestTemplate();
//        String meg = restTemplate.getForObject("http://localhost:8887/product/getProduct", String.class);
//        log.info("用户服务调用商品服务。当前端口号： "+port);

//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("product-service");
//        serviceInstances.forEach(one -> {
//            System.out.println(one.getHost()+"  "+one.getPort());
//        });
//        默认轮循
//        ServiceInstance serviceInstance = loadBalancerClient.choose("product-service");
//        System.out.println(serviceInstance.getHost()+"   "+serviceInstance.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/getProduct", String.class);
        String meg = restTemplate.getForObject("http://product-service/product/getProduct",String.class);
        return meg;
    }
}
