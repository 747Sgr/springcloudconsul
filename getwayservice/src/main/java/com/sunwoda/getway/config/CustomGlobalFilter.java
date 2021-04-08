package com.sunwoda.getway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Description:自定义过滤器，所有的请求都要经过自定义过滤器
 *
 * @author shiguorang
 * @date 2021-04-08 14:13:06
 */
@Configuration
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入自定义filter");
        if (exchange.getRequest().getQueryParams().get("username") != null){
            return chain.filter(exchange);
        }
        log.info("非法用户，拒绝访问");
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
//          filter数字越小，执行优先级越高 0到任意整数
//        -1优先执行
        return -1;
    }
}
