package com.elasticsearch.git.elasticdemoqueries.config;

import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ElasticSearchConfiguration {

    @Bean(name = "highLevelClient", destroyMethod = "close")
    public RestHighLevelClient client(){
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        builder.setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(600 * 1000).setSocketTimeout(600 * 1000)
                .setConnectionRequestTimeout(-1));

        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }

}
