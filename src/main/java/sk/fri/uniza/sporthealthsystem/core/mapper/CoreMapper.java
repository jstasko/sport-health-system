package sk.fri.uniza.sporthealthsystem.core.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public abstract class CoreMapper<T> implements RowMapper<T> {
    protected final T typ;

    public CoreMapper(T list) {
        this.typ = list;
    }

    public T getList() {
        return this.typ;
    }
}
