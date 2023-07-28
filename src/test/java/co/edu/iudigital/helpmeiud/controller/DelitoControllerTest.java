package co.edu.iudigital.helpmeiud.controller;

import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DelitoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IDelitoService delitoService;

    @BeforeEach
    public void setup() throws Exception{
        //delitoService.findAll();
    }

    @Test
    public void indexTest() throws Exception{

        mvc.perform(
                        get(new URI("/delitos"))
                )
                .andExpect(status().isOk());

        verify(delitoService, times(1)).consultarTodos();
    }
}