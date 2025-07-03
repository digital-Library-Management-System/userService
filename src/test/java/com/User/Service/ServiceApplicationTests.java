package com.User.Service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @MockBean
    private BookClient bookClient;
}
