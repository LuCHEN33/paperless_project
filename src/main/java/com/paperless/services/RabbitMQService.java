package com.paperless.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public interface RabbitMQService  {
    void sendToOcrDocumentInQueue(String message);

    void receiveMessage(String message);
}
