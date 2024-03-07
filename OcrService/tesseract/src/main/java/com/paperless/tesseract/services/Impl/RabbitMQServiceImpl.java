package com.paperless.tesseract.services.Impl;

import com.paperless.tesseract.services.RabbitMQService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {

    private final OcrServiceImpl ocrService;

    @Autowired
    public RabbitMQServiceImpl(OcrServiceImpl ocrService) {
        this.ocrService = ocrService;
    }

    @RabbitListener(queues = "OCR_QUEUE")
    @Override
    public void processQueue(String message) {
        ocrService.performOCR(message);
    }
}
