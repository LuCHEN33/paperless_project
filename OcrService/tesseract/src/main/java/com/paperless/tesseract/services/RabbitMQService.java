package com.paperless.tesseract.services;

import com.paperless.tesseract.services.Impl.OcrServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public interface RabbitMQService {

    @RabbitListener(queues = "ocrScanQueue")
    void processQueue(String message);
}
