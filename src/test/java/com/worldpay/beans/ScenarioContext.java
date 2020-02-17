package com.worldpay.beans;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ScenarioContext {
    private Map<String, Object> context = new LinkedHashMap<>();

    public void setNamedValue(String key, Object value){
        context.put(key, value);
    }

    public <T> T getNamedValue(String key, Class<T> clazz ){
        return context.containsKey(key) && context.get(key)!=null ? (T) context.get(key) : null;
    }

    public void reset(){
        context = new LinkedHashMap<>();
    }
}
