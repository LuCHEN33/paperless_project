package com.paperless.services;

import java.io.File;

public interface OcrService {
    String executeOCR(File file) throws Exception;
}
