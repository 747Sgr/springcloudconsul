package com.sunwoda.userservice.feignclient;

import com.sunwoda.userservice.entity.ProductModel;
import com.sunwoda.userservice.fallback.ProductFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 *
 * @author shiguorang
 * @date 2021-04-06 15:09:34
 */
//该注解表示是一个feign的客户端  fallback:降级实现类
@FeignClient(value = "product-service", fallback = ProductFallBack.class)
public interface ProductClient {

    /**
     * @Author shiguorang
     * @Description // 调用商品服务
     * @Date 15:11:36 2021-04-06
     * @Param
     * @return
     **/
    @GetMapping("/product/getProduct")
    String getProduct();

    @GetMapping("product/selectOne")
    String selectOne(@RequestParam("id") String id);

    @PostMapping("product/getById")
    String getById(@RequestBody ProductModel productModel);
}
