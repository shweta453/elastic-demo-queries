package com.elasticsearch.git.elasticdemoqueries.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MyObjectMapper extends ObjectMapper{

    public MyObjectMapper() {
        super();
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
