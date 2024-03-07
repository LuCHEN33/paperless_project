package com.paperless;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PaperlessApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("Application context loads")
    void shouldLoadApplicationContext() {
        assertNotNull(applicationContext);
    }

    @Test
    @DisplayName("JsonNullableModule bean loads")
    void shouldLoadJsonNullableModuleBean() {
        assertNotNull(applicationContext.getBean("com.paperless.PaperlessApplication.jsonNullableModule"));
    }

}