package ru.pravvich.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pravvich.domain.Item;
import ru.pravvich.domain.User;
import ru.pravvich.service.ItemService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
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
    public String getAllItems(Model model) {

        model.addAttribute("items", service.getAll());

        return "all_items";
    }

    @GetMapping("/get_all_items/get_single_item_by_id")
    public String getItemById(final Model model,
                              @RequestParam(value = "id") final String id) {

        final Item item = service.getItemById(Integer.valueOf(id));

        model.addAttribute("item", item);

        return "single_item";
    }

    @GetMapping("/get_all_items/add_item_page")
    public String addItemPage() {
        return "add_item";
    }

    @PostMapping("/get_all_items/add_item_page/add_item")
    public String addItem(@RequestParam(value = "description")
                              final String description,

                          final Principal principal) {

        final User user = (User)principal;

        final Item item = new Item();

        item.setDescription(description);

        item.setAuthorId(user.getId());

        service.add(item);

        return "redirect:get_all_items";
    }
}
