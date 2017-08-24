package ru.pravvich.service;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pravvich.domain.Item;
import ru.pravvich.repository.ItemRepository;

import java.util.List;

/**
 * Author : Pavel Ravvich.
 * Created : 18.08.17.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Item item) {
        repository.save(item);
    }

    @Override
    public List<Item> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Item getItemById(final int id) {
        return repository.findOne(id);
    }
}
