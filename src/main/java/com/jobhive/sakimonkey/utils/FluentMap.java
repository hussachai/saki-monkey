package com.jobhive.sakimonkey.utils;

import java.util.HashMap;

/**
 * 
 * @author Hussachai
 *
 * @param <K>
 * @param <V>
 */
public class FluentMap<K, V> extends HashMap<K, V>{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     * @param key
     * @param value
     * @return
     */
    public FluentMap<K, V> p(K key, V value){
        if(value != null) {
            put(key, value);
        }
        return this;
    }
}
