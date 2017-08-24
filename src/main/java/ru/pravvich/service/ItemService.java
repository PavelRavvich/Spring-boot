package ru.pravvich.service;

import ru.pravvich.domain.Item;

import java.util.List;

public interface ItemService {
    void add(Item item);
    List<Item> getAll();
    Item getItemById(int id);
}
