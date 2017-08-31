package ru.pravvich.web;

import org.assertj.core.util.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pravvich.domain.XMLExample;

import java.util.List;

/**
 * Author : Pavel Ravvich.
 * Created : 01.09.17.
 */
@RestController
@RequestMapping("xml_ex")
public class RestControllerExample {

    @GetMapping("data")
    public List<XMLExample> getAllArticles() {
        return Lists.newArrayList(new XMLExample("test"));
    }
}
