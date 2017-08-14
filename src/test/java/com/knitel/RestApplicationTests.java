package com.knitel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.hasSize;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class)
@WebAppConfiguration
public class RestApplicationTests {

    private static final String CONTACTS_URI = "/hello/contacts";
    private static final String FILTER = "?nameFilter=";
    private static final String CONTACTS_URI_WITH_FILTER = CONTACTS_URI + FILTER;

    private static final MediaType JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test1() throws Exception {
        String regex = "^A.*$";

        mockMvc.perform(get(CONTACTS_URI_WITH_FILTER + regex))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_UTF8))
                .andExpect(jsonPath("$.contacts", hasSize(16)));
    }

    @Test
    //unsupported post method
    public void test2() throws Exception {
        String regex = "^A.*$";

        mockMvc.perform(post(CONTACTS_URI_WITH_FILTER + regex))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    //without required nameFilter parameter
    public void test3() throws Exception {

        mockMvc.perform(get(CONTACTS_URI))
                .andExpect(status().isBadRequest());
    }

    @Test
    //with odd parameter
    public void test4() throws Exception {

        String regex = "^A.*$";

        mockMvc.perform(get(CONTACTS_URI_WITH_FILTER + regex + "&foo=bar"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_UTF8))
                .andExpect(jsonPath("$.contacts", hasSize(16)));
    }

    @Test
    public void test5() throws Exception {
        String regex = "^.*[aei].*$";

        mockMvc.perform(get(CONTACTS_URI_WITH_FILTER + regex))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_UTF8))
                .andExpect(jsonPath("$.contacts", hasSize(8)));
    }

    @Test
    //bad regex syntax
    public void test6() throws Exception {
        String regex = "[";

        mockMvc.perform(get(CONTACTS_URI_WITH_FILTER + regex))
                .andExpect(status().isBadRequest());
    }

    @Test
    //unsupported uri
    public void test7() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isNotFound());
    }


}
