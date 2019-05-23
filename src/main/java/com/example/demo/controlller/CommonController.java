package com.example.demo.controlller;

import com.example.demo.domain.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CommonController<E extends AbstractEntity, K> {

    @GetMapping
    ResponseEntity<E> findById(@RequestBody E entity, @PathVariable K id);

    @GetMapping
    ResponseEntity<E> getAll(@RequestBody E entity);

    @GetMapping
    ResponseEntity<E> findByName(@RequestBody E entity);

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);

    @PostMapping
    ResponseEntity<E> putCashIntoAtm(@RequestBody E entity);

    @PostMapping
    ResponseEntity<E> sendMoneyToAnotherUser(@RequestBody E entity);

    @PostMapping
    ResponseEntity<E> withdraw(@RequestBody E entity);

    @PutMapping
    ResponseEntity<E> update(@RequestBody E entity);

    @DeleteMapping
    ResponseEntity<E> delete(@RequestBody E entity, @PathVariable K id);


}
