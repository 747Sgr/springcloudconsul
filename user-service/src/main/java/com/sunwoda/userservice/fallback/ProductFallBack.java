package com.sunwoda.userservice.fallback;

import com.sunwoda.userservice.entity.ProductModel;
import com.sunwoda.userservice.feignclient.ProductClient;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author shiguorang
 * @date 2021-04-07 15:52:19
 */
@Component
public class ProductFallBack implements ProductClient {
    @Override
    public String getProduct() {
        return "商品服务已被降级";
    }

    @Override
    public String selectOne(String id) {
        return "商品服务已被降级";
    }

    @Override
    public String getById(ProductModel productModel) {
        return "商品服务已被降级";
    }
}
