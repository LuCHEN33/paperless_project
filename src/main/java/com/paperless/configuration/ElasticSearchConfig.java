package com.paperless.configuration;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig
{
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.username}")
    private String username;

    @Value("${elasticsearch.password}")
    private String password;

    public static final String DOCUMENTS_INDEX_NAME = "documents";

    @Bean
    public RestClient getRestClient() {
        final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        return RestClient.builder(new HttpHost(host, port))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
                .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setSocketTimeout(10000))
                .build();
    }

    @Bean
    public ElasticsearchTransport getElasticsearchTransport() {
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        mapper.objectMapper().registerModule(new JavaTimeModule());
        mapper.objectMapper().registerModule(new JsonNullableModule());
        return new RestClientTransport(
                getRestClient(), mapper);
    }

    @Bean
    public ElasticsearchClient getElasticsearchClient(){
        return new ElasticsearchClient(getElasticsearchTransport());
    }

}
