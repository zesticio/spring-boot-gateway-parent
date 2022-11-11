package in.zestic.gateway.app.service.impl;

import in.zestic.gateway.app.document.Route;
import in.zestic.gateway.app.exception.GatewayError;
import in.zestic.gateway.app.exception.GatewayException;
import in.zestic.gateway.app.repository.RouteRepository;
import in.zestic.gateway.app.service.RouteService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RouteServiceImpl implements RouteService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RouteServiceImpl.class);

    private final RouteRepository repository;

    public RouteServiceImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Route> create(Route entity) throws GatewayException {
        Mono<Route> route = repository.save(entity);
        if (route != null) {
            return route;
        } else {
            throw new GatewayException(GatewayError.SYSTEM_ERROR, "Unable to save the record");
        }
    }

    @Override
    public Flux<Route> save(Iterable<Route> entities) throws GatewayException {
        Flux<Route> list = repository.saveAll(entities);
        if (list != null) {
            return list;
        } else {
            throw new GatewayException(GatewayError.SYSTEM_ERROR, "Unable to save the record");
        }
    }

    @Override
    public Mono<Route> update(Route entity) throws GatewayException {
        Mono<Route> route = repository.save(entity);
        if (route != null) {
            return route;
        } else {
            throw new GatewayException(GatewayError.SYSTEM_ERROR, "Unable to save the record");
        }
    }

    @Override
    public void delete(Route entity) throws GatewayException {
        repository.delete(entity);
    }

    /**
     * TODO catch NoSuchElementException
     *
     * @param id
     * @return
     */
    @Override
    public Mono<Route> findById(String id) {
        return repository.findById(id).onErrorReturn(null);
    }

    @Override
    public Flux<Route> list() {
        return repository.findAll();
    }

    @Override
    public Mono<Long> count() {
        return repository.count();
    }

    @Override
    public void flush() {
    }
}
