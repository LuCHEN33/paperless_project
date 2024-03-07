package com.paperless.services;

import com.paperless.configuration.RabbitMQConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class RabbitMQServiceTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private RabbitMQService rabbitMQService;

    @BeforeEach
    void setUp() {
        rabbitMQService = new RabbitMQService(rabbitTemplate);
    }

    @Test
    @DisplayName("Test send to OCR Document In Queue")
    void testSendToOcrDocumentInQueue() {
        String message = "Test Message";
        rabbitMQService.sendToOcrDocumentInQueue(message);
        verify(rabbitTemplate, times(1)).convertAndSend(RabbitMQConfig.MESSAGE_IN_QUEUE, message);
    }
}