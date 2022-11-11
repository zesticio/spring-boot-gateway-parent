package in.zestic.gateway.app.repository;

import in.zestic.gateway.app.document.Route;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends ReactiveMongoRepository<Route, String> {

}
