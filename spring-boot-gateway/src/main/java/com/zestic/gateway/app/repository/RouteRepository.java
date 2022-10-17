package com.zestic.gateway.app.repository;

import com.zestic.gateway.app.document.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {

}
