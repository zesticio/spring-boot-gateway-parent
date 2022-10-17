package com.zestic.gateway.app.entity;

import com.googlecode.jmapper.JMapper;
import com.zestic.gateway.app.document.Route;

public class TestRouteMapper {

    public static void main(String[] args) {
        Route document = new Route();
        document.setId("1000000");
//        JMapper<RouteEntity, Route> mapper = new JMapper<>(RouteEntity.class, Route.class);
//        RouteEntity entity = mapper.getDestination(document);
//        System.out.println(entity.toJson());
    }
}
