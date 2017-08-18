package ru.pravvich.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pravvich.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
