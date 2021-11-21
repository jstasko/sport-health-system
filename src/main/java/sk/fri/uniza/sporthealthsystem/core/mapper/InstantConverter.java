package sk.fri.uniza.sporthealthsystem.core.mapper;

import org.dozer.DozerConverter;

import java.time.Instant;

public class InstantConverter extends DozerConverter<Instant, Instant> {

    public InstantConverter() {
        super(Instant.class, Instant.class);
    }

    public Instant convertTo(Instant source, Instant destination) {
        if (source == null) {
            return null;
        }
        return Instant.from(source);
    }

    public Instant convertFrom(Instant source, Instant destination) {
        if (source == null) {
            return null;
        }

        return Instant.from(source);
    }
}
