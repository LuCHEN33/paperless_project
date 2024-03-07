package com.paperless.tesseract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(
		nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(basePackages = {"com.paperless.tesseract", "com.paperless.tesseract.configuration", "com.paperless.tesseract.dto",
		"com.paperless.tesseract.persistence","com.paperless.tesseract.service"},
		nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class

)
public class TesseractApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesseractApplication.class, args);
	}

}
