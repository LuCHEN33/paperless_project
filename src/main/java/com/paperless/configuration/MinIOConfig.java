package com.paperless.configuration;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MinIOConfig {

    @Value("${minio.url}")
    private String url;

    @Value("${minio.access.name}")
    private String accessKey;

    @Value("${minio.access.secret}")
    private String accessSecret;

    @Value("${minio.bucketName}")
    private String bucketName;


    @Bean
    public MinioClient MinioClient() {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(url)
                    .credentials(accessKey, accessSecret)
                    .build();

            return minioClient;
        } catch (Exception e) {
            throw new RuntimeException("Could not init MinioClient", e);
        }
    }

}