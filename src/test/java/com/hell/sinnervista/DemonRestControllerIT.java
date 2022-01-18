package com.hell.sinnervista;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DemonRestControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_getAllDemons() throws Exception{
        mockMvc.perform(get("/demons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[{\"id\":1,\"name\":\"Azazel\"},{\"id\":2,\"name\":\"Baal\"},{\"id\":3,\"name\":\"Beelzebub\"},{\"id\":4,\"name\":\"Saael\"},{\"id\":5,\"name\":\"Asmodan\"},{\"id\":6,\"name\":\"Bob\"}]"));
    }
}
