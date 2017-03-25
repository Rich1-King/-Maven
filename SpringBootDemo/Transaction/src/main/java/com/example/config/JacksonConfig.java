package com.example.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Created by rich1 on 9/17/16.
 */
public class JacksonConfig extends ObjectMapper{
    public JacksonConfig() {
        Hibernate4Module hm = new Hibernate4Module();
        hm.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION); //序列化transient字段
        registerModule(hm);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
    }
}
