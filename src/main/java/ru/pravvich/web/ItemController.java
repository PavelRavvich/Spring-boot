package ru.pravvich.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.pravvich.domain.Item;
import ru.pravvich.service.ItemService;

import java.util.List;

/**
 * Author : Pavel Ravvich.
 * Created : 18.08.17.
 */
@Controller
public class ItemController {

    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/get_all_items")
    public ModelAndView getAllItems() {

        final ModelAndView model = new ModelAndView();

        final List<Item> all = service.getAll();

        model.addObject("items", all);

        return model;
    }

    @PostMapping("/add_item")
    public String addItem(@ModelAttribute Item item) {
        service.add(item);
        return "redirect:get_all_items";
    }
}
