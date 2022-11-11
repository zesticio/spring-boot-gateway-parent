package in.zestic.gateway.app.base;

import in.zestic.gateway.app.base.Entity;
import in.zestic.gateway.app.exception.ApplicationException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

public interface EntityService<K extends Serializable & Comparable<K>, E extends Entity<K, ?>> {

    /**
     * @param entity
     * @throws ApplicationException
     */
    Mono<E> create(E entity) throws ApplicationException;

    /**
     * @param entities
     * @throws ApplicationException
     */
    Flux<E> save(Iterable<E> entities) throws ApplicationException;

    /**
     * @param entity
     * @throws ApplicationException
     */
    Mono<E> update(E entity) throws ApplicationException;

    /**
     * @param entity
     * @throws ApplicationException
     */
    void delete(E entity) throws ApplicationException;

    /**
     * @param id
     * @return
     */
    Mono<E> findById(K id);

    /**
     * @return
     */
    Flux<E> list();

    /**
     * @return
     */
    Mono<Long> count();

    /**
     *
     */
    void flush();
}
