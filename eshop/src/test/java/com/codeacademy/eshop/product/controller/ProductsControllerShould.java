package com.codeacademy.eshop.product.controller;

import com.codeacademy.eshop.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductsController.class)
class ProductsControllerShould {

    @MockBean
    private DataSource dataSource;

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mvc;

    @Test
    void return_products_page_with_no_products_when_no_products_found() throws Exception {
        // given
        when(productService.getAllProducts(PageRequest.of(1, 10))).thenReturn(Page.empty());

        // when
        mvc.perform(get("/public/product")
                .param("page", "1")
                .param("size", "10"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/product-list"))
            .andExpect(model().attribute("productsPage", Page.empty()))
            .andExpect(content().string(containsString("<p>Jūs neturite pridėtų produktų!</p>")));
    }
}
