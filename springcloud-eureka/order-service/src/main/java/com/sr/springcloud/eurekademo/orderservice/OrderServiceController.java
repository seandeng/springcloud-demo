package com.sr.springcloud.eurekademo.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@Configuration
@SpringBootApplication
public class OrderServiceController {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceController.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

    /**
     * 根据订单 id 查找商品信息
     * @param id 订单 id
     * @return 商品服务返回的数据
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable("id") String id) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject("http://ProductService/product/" + id, String.class);
    }
}
