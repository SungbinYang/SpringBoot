package me.sungbin.demospringmvc.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("UserController 테스트")
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("hello() 테스트")
    void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    @DisplayName("유저를 생성하여 json형태로 반환하는 테스트")
    void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"sungbin\", \"password\":\"1234\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(equalTo("sungbin"))))
                .andExpect(jsonPath("$.password", is(equalTo("1234"))));

    }

    @Test
    @DisplayName("유저를 생성하여 xml형태로 반환하는 테스트")
    void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"sungbin\", \"password\":\"1234\"}";
        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_XML)
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("sungbin"))
                .andExpect(xpath("/User/password").string("1234"));

    }
}