package com.sunwoda.userservice.openfeigncontroller;

import com.sunwoda.userservice.entity.ProductModel;
import com.sunwoda.userservice.feignclient.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author shiguorang
 * @date 2021-04-06 15:03:58
 */
@RestController
public class TestFeignController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/user/getProduct")
    public String getProduct(){
        String msg = productClient.getProduct();
        return msg;
    }

    @GetMapping("/user/getOne")
    public String getOne(@RequestParam("id") String id){
        String msg = productClient.selectOne(id);
        return msg;
    }

    @GetMapping("/user/getBuId")
    public String getBuId(@RequestParam("id") String id, @RequestParam("productName") String productName, @RequestParam("price") Double price) {
        ProductModel productModel = new ProductModel();
        productModel.setId(id);
        productModel.setProductName(productName);
        productModel.setPrice(price);
        String msg = productClient.getById(productModel);
        return msg;
    }
}
