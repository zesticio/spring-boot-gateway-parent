package com.zestic.gateway.app.entity;

import com.zestic.gateway.app.document.Route;

public class TestRouteEntity {

    public static void main(String[] args) {
        Route entity = new Route();
        System.out.println(entity.toJson());
    }
}
