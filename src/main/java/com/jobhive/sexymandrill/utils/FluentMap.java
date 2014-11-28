package com.jobhive.sexymandrill.utils;

import java.util.HashMap;

public class FluentMap<K, V> extends HashMap<K, V>{
    
    private static final long serialVersionUID = 1L;
    
    public FluentMap<K, V> p(K key, V value){
        if(value != null) {
            put(key, value);
        }
        return this;
    }
}
