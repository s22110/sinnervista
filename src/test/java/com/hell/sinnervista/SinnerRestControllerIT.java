package com.hell.sinnervista;

import com.hell.sinnervista.Models.HellCircle;
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
public class SinnerRestControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_getSinnersByHellCircle() throws Exception{
        HellCircle hellCircle = HellCircle.JavaDevs;
        mockMvc.perform(get("/sinners/circle/{hellCircle}", String.valueOf(hellCircle)))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(content().string("[{\"id\":5,\"name\":\"James\",\"surname\":\"Gosling\",\"hellCircle\":\"JavaDevs\"}]"));
    }
}
