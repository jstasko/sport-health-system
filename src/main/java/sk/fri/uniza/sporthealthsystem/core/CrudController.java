package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class CrudController<T, S extends CrudService<T>> {
    protected S service;

    public CrudController(S s) {
        service = s;
    }

    @GetMapping("/{id}")
    T findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping()
    List<T> findAll() {
        return service.findAll();
    }

    @PostMapping()
    T save(@RequestBody T t) {
        return service.save(t);
    }
}
