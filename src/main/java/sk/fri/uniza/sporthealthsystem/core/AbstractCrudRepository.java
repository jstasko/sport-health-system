package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.data.repository.CrudRepository;

public interface AbstractCrudRepository<T extends BaseDocumentDto> extends CrudRepository<T, Long> {
}
