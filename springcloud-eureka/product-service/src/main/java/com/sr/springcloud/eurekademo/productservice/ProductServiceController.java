package com.sr.springcloud.eurekademo.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableEurekaClient
@SpringBootApplication
public class ProductServiceController {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceController.class, args);
    }

    /**
     * 订单服务
     * @param name 商品名称
     * @return 测试返回商品名
     */
    @RequestMapping(value = "/product/{name}",
            method = RequestMethod.GET)
    public String getProduct(@PathVariable("name") String name) {

        System.out.println("商品服务被调用了");
        return "order" + name;
    }
}
