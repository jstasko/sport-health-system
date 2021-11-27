package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<T, U, S extends CrudService<T, U>> {
    protected S service;

    public CrudController(S s) {
        service = s;
    }

    @GetMapping("/{id}")
    T findOne(@PathVariable("id") U id) {
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

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") U id) { this.service.deleteById(id); }
}
