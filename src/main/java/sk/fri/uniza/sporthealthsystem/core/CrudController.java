package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    ListingResponse<T> findAll(
            Pageable pageable
            ) {
        return service.findAll(pageable);
    }

    @PostMapping()
    T save(@RequestBody T t) {
        return service.save(t);
    }

    @PostMapping("/{id}")
    T update(
            @PathVariable("id") U id,
            @RequestBody T t
    ) {
        return this.service.updateOne(id, t);
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") U id) { this.service.deleteById(id); }
}
