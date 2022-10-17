package com.zestic.gateway.app.service.impl;

import com.zestic.gateway.app.document.Route;
import com.zestic.gateway.app.exception.GatewayError;
import com.zestic.gateway.app.exception.GatewayException;
import com.zestic.gateway.app.repository.RouteRepository;
import com.zestic.gateway.app.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RouteServiceImpl.class);

    private final RouteRepository repository;

    public RouteServiceImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Route create(Route entity) throws GatewayException {
        Route route = repository.save(entity);
        if (route != null) {
            return route;
        } else {
            throw new GatewayException(GatewayError.SYSTEM_ERROR, "Unable to save the record");
        }
    }

    @Override
    public List<Route> save(Iterable<Route> entities) throws GatewayException {
        List<Route> list = repository.saveAll(entities);
        if (list != null) {
            return list;
        } else {
            throw new GatewayException(GatewayError.SYSTEM_ERROR, "Unable to save the record");
        }
    }

    @Override
    public Route update(Route entity) throws GatewayException {
        Route route = repository.save(entity);
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
    public Route findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Route> list() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public void flush() {
    }
}
