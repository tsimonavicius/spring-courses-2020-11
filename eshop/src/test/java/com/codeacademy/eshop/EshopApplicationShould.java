package com.codeacademy.eshop;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.repository.ProductRepository;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestEntityManager
@AutoConfigureMockMvc
@Transactional
class EshopApplicationShould {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void createProduct() throws Exception {
        // when
        MvcResult mvcResult = mvc.perform(post("/public/product")
                .with(csrf())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(EntityUtils.toString(
                        new UrlEncodedFormEntity(
                                List.of(new BasicNameValuePair("name", "Produkto pavadinimas"),
                                        new BasicNameValuePair("inStock", "10"),
                                        new BasicNameValuePair("price", "10.10"),
                                        new BasicNameValuePair("description", "Aprasymas")))
                )))
                .andExpect(status().is3xxRedirection()).andReturn();

        // then
        String[] redirectUrlParts = mvcResult.getModelAndView().getViewName().split("/");
        Long productId = Long.valueOf(redirectUrlParts[redirectUrlParts.length - 1]);

        Product productFromEm = em.find(Product.class, productId);
        Product productFromRepo = productRepository.getOne(productId);

        assertNotNull(productFromEm);
        assertNotNull(productFromRepo);
    }

}
