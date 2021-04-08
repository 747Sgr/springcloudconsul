package com.sunwoda.productservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunwoda.productservice.entity.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

/**
 * Description:
 *
 * @author shiguorang
 * @date 2021-04-02 11:17:03
 */
@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;

    /**
     * @Author shiguorang
     * @Description //TODO
     * @Date 11:17:22 2021-04-02
     * @Param
     * @return
     **/
    @GetMapping("/product/getProduct")
    public String getProduct(){
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println(dateTime);
        log.info("商品服务被调用"+port);
        return "商品服务被调用"+port;
    }

    @GetMapping("product/selectOne")
//    @HystrixCommand(fallbackMethod = "selectOneFallback")
//    @HystrixCommand(defaultFallback = "fallBack")
    public String selectOne(@RequestParam("id") String id){
        if (Integer.parseInt(id) < 0){
            throw new RuntimeException("非法参数"+id);
        }
        log.info("商品服务接收到的id为"+id+"当前端口为"+port);
        return "商品服务成功接收到id";
    }

    public String selectOneFallback(@RequestParam("id") String id){
        return "触发熔断器";
    }

    public String fallBack(){
        return "触发默认熔断方法";
    }

    @PostMapping("product/getById")
    public String getById(@RequestBody ProductModel productModel){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("商品服务被调用，当前端口号为： "+port+productModel.toString());
        return "被调用端口号为"+port;
    }
}
