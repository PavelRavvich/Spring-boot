package ru.pravvich.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.pravvich.domain.Item;
import ru.pravvich.service.ItemService;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest
public class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemService itemService;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void whenGetAllItemsThenControllerReturnAllItems() throws Exception {
        given(
                itemService.getAll()
        ).willReturn(
                new ArrayList<Item>()
        );

        mvc.perform(
                get("/get_all_items").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("all_items")
        );
    }

    @Test
    @WithUserDetails( "u")
    public void whenPostThenAdd() throws Exception {

        Item item = new Item();
        item.setDescription("test");

        mvc.perform(
                post("/get_all_items/add_item_page/add_item")
                        .param("description", "test")
        ).andExpect(
                status().is3xxRedirection()
        );
    }

}